package TowerDefense;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TowerDefense extends javax.swing.JFrame {

    private GameMap map;
    private GameContext context;
    private GamePanel gamePanel;
    private boolean juegoIniciado = false;
    private int oleadaActual = 0;
    private final int TOTAL_OLEADAS = 100;
    private int oro = 60;
    private Timer gameTickTimer;
    private Timer attackTimer;
    private boolean esperandoSiguienteOleada = false;
    private final int MAX_TORRES = 6;
    private final Stack<Command> undoStack = new Stack<>();
    private final Stack<Command> redoStack = new Stack<>();
    private boolean oleadasFinalizadas = false;

    public TowerDefense() {
        initComponents();
        configurarLogicaDeJuego();
    }

    public int getOro() {
        return oro;
    }

    public int getOleadaActual() {
        return oleadaActual;
    }

    public int getMaxTorres() {
        return MAX_TORRES;
    }

    public void restarOro(int cantidad) {
        oro -= cantidad;
        if (oro < 0) oro = 0;
    }

    public void clearRedoStack() {
        redoStack.clear();
    }

    public void addToUndoStack(Command cmd) {
        undoStack.push(cmd);
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    private void configurarLogicaDeJuego() {
        getContentPane().removeAll();

        map = new GameMap(15, 8);
        List<Position> path = new ArrayList<>();
        for (int x = 0; x < 15; x++) {
            path.add(new Position(x, 3));
            path.add(new Position(x, 4));
        }
        map.setPath(path);

        context = new GameContext();
        gamePanel = new GamePanel(map, context);

        JButton startButton = new JButton("Iniciar");
        JButton undoButton = new JButton("Deshacer");
        JButton refreshButton = new JButton("Actualizar");
        JButton redoButton = new JButton("Rehacer");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(undoButton);
        buttonPanel.add(refreshButton);
        buttonPanel.add(redoButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(gamePanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        gameTickTimer = new Timer(500, e -> moverEnemigos());
        gameTickTimer.start();

        attackTimer = new Timer(200, e -> atacarConTorres());
        attackTimer.start();

        refreshButton.addActionListener(e -> {
            oleadaActual = 0;
            juegoIniciado = false;
            oleadasFinalizadas = false;
            context = new GameContext();
            map.clearTowers();
            undoStack.clear();
            redoStack.clear();
            gamePanel.repaint();
            JOptionPane.showMessageDialog(this, "🔄 Juego reiniciado.");
        });

        undoButton.addActionListener(e -> {
            if (!undoStack.isEmpty()) {
                Command cmd = undoStack.pop();
                cmd.undo();
                redoStack.push(cmd);
                gamePanel.repaint();
            } else {
                JOptionPane.showMessageDialog(this, "⛔ Nada para deshacer.");
            }
        });

        redoButton.addActionListener(e -> {
            if (!redoStack.isEmpty()) {
                Command cmd = redoStack.pop();
                cmd.execute();
                undoStack.push(cmd);
                gamePanel.repaint();
            } else {
                JOptionPane.showMessageDialog(this, "🔁 Nada para rehacer.");
            }
        });

        startButton.addActionListener(e -> {
            if (juegoIniciado) return;

            if (map.getTowers().size() != 3) {
                JOptionPane.showMessageDialog(this, "⚠️ Debes colocar exactamente 3 torres antes de iniciar.");
                return;
            }
            if (oro < 0) {
                JOptionPane.showMessageDialog(this, "💰 No tienes suficiente oro para iniciar.");
                return;
            }
            juegoIniciado = true;
            iniciarOleada();
        });

        pack();
        revalidate();
        repaint();
    }

    private void iniciarOleada() {
        int enemigosEnOleada = 5 + oleadaActual * 2;
        int delayEntreEnemigos = 500;

        oleadaActual++;
        esperandoSiguienteOleada = true;

        final int[] contador = {0};
        Timer spawnTimer = new Timer(delayEntreEnemigos, null);
        spawnTimer.addActionListener(ev -> {
            if (contador[0] >= enemigosEnOleada) {
                ((Timer) ev.getSource()).stop();
                esperandoSiguienteOleada = false;
                return;
            }
            Cozy enemy = new Cozy(100 + oleadaActual * 20, 1);
            context.getCozyQueue().add(enemy);
            contador[0]++;
        });
        spawnTimer.start();
    }

    private void moverEnemigos() {
        int size = context.getCozyQueue().size();
        for (int i = 0; i < size; i++) {
            Cozy cozy = context.getCozyQueue().poll();
            cozy.tick(map, context);

            if (cozy.getPositionIndex() >= map.getPath().size()) {
                context.reducePlayerHealth(10);
                continue;
            }

            if (cozy.isDead()) {
                oro += 10;
                continue;
            }

            context.getCozyQueue().add(cozy);
        }

        if (juegoIniciado && context.getCozyQueue().isEmpty() && !esperandoSiguienteOleada) {
            if (oleadaActual >= TOTAL_OLEADAS) {
                oleadasFinalizadas = true;
                juegoIniciado = false;
                detenerTimers();
                JOptionPane.showMessageDialog(this, "🏆 ¡Felicidades! Has ganado.");
            } else {
                esperandoSiguienteOleada = true;
                new Timer(3000, e -> {
                    iniciarOleada();
                    ((Timer) e.getSource()).stop();
                }).start();
            }
        }

        if (context.getPlayerHealth() <= 0) {
            juegoIniciado = false;
            detenerTimers();
            JOptionPane.showMessageDialog(this, "💀 Has perdido.");
        }

        gamePanel.repaint();
    }

    private void atacarConTorres() {
        for (Tower tower : map.getTowers()) {
            for (Cozy enemy : context.getCozyQueue()) {
                int idx = enemy.getPositionIndex();
                if (idx >= 0 && idx < map.getPath().size()) {
                    Position pos = map.getPath().get(idx);
                    if (tower.isInRange(pos.getX(), pos.getY())) {
                        tower.attack(enemy);
                        break;
                    }
                }
            }
        }

        gamePanel.repaint();
    }

    private void detenerTimers() {
        if (gameTickTimer != null) gameTickTimer.stop();
        if (attackTimer != null) attackTimer.stop();
    }

public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(() -> {
        new TowerDefense().setVisible(true);
    });
}

/*
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}