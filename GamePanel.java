package TowerDefense;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel {

    private GameMap map;
    private GameContext context;
    private Image towerImage;
    private Image backgroundImage;
    private Tower torreSeleccionada = null;

    private static final int TILE_SIZE = 80;

    public GamePanel(GameMap map, GameContext context) {
        this.map = map;
        this.context = context;

        try {
            backgroundImage = new ImageIcon(getClass().getResource("/TowerDefense/imgs/fondo.png")).getImage();
        } catch (Exception e) {
            System.err.println("⚠️ Imagen de fondo no encontrada.");
            backgroundImage = null;
        }

        int width = map.getWidth() * TILE_SIZE;
        int height = map.getHeight() * TILE_SIZE;
        setPreferredSize(new Dimension(width, height));

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = e.getX() / TILE_SIZE;
                int y = e.getY() / TILE_SIZE;
                TowerDefense ventana = (TowerDefense) SwingUtilities.getWindowAncestor(GamePanel.this);

                if (SwingUtilities.isRightMouseButton(e)) {
                    // ✅ Clic derecho: buscar si hay una torre en esa posición
                    for (Tower t : map.getTowers()) {
                        if (t.getX() == x && t.getY() == y) {
                            torreSeleccionada = t;
                            JOptionPane.showMessageDialog(GamePanel.this,
                                    "🔧 Torre seleccionada para mejora\nNivel: " + t.getLevel()
                                    + "\nDaño actual: " + t.getDamage());
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(GamePanel.this, "⚠️ No hay torre aquí para mejorar.");
                    return;
                }

                // ⚠️ Clic izquierdo: colocar torre normalmente
                if (map.getTowers().size() >= ventana.getMaxTorres()) {
                    JOptionPane.showMessageDialog(GamePanel.this, "🚫 Límite de torres alcanzado.");
                    return;
                }

                TowerType tipo = ventana.getSelectedTowerType();
                if (tipo == null) {
                    JOptionPane.showMessageDialog(GamePanel.this, "Selecciona un tipo de torre primero.");
                    return;
                }

                if (ventana.getOro() >= tipo.getCost()) {
                    Tower tower = new Tower(x, y, tipo);
                    PlaceTowerCommand cmd = new PlaceTowerCommand(map, tower);
                    cmd.execute();
                    ventana.addToUndoStack(cmd);
                    ventana.clearRedoStack();
                    ventana.restarOro(tipo.getCost());
                    repaint();
                } else {
                    JOptionPane.showMessageDialog(GamePanel.this, "💰 Oro insuficiente para colocar la torre.");
                }
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Fondo
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        } else {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        // Camino
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(new Color(255, 255, 0, 180));
        for (Position p : map.getPath()) {
            g2d.fillRect(p.getX() * TILE_SIZE, p.getY() * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }
        g2d.dispose();

        // Torres
        for (Tower tower : map.getTowers()) {
            Image img = tower.getImage();
            if (img != null) {
                g.drawImage(img, tower.getX() * TILE_SIZE, tower.getY() * TILE_SIZE, TILE_SIZE, TILE_SIZE, this);
            } else {
                g.setColor(Color.DARK_GRAY);
                g.fillRect(tower.getX() * TILE_SIZE, tower.getY() * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }

        // HUD: dibuja vida, oleada y oro
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 16));

        TowerDefense ventana = (TowerDefense) SwingUtilities.getWindowAncestor(this);
        int vida = context.getPlayerHealth();
        int oleada = ventana.getOleadaActual();
        int oro = ventana.getOro();

        g.drawString("Vida: " + vida, 10, 20);
        g.drawString("Oleada: " + (oleada + 1), 10, 40);
        g.drawString("Oro: " + oro, 10, 60);

        // Enemigos (Cozy)
        for (Cozy cozy : context.getCozyQueue()) {
            int idx = cozy.getPositionIndex();
            if (idx >= 0 && idx < map.getPath().size()) {
                Position pos = map.getPath().get(idx);
                Image cozyImg = cozy.getState().getImage(cozy);
                if (cozyImg != null) {
                    g.drawImage(cozyImg, pos.getX() * TILE_SIZE, pos.getY() * TILE_SIZE, TILE_SIZE, TILE_SIZE, this);
                } else {
                    g.setColor(Color.RED);
                    g.fillOval(pos.getX() * TILE_SIZE + 5, pos.getY() * TILE_SIZE + 5, TILE_SIZE - 10, TILE_SIZE - 10);
                }
            }
        }

        // Dibujar ataque (círculo rojo)
        g.setColor(Color.RED);
        for (Tower tower : map.getTowers()) {
            for (Cozy cozy : context.getCozyQueue()) {
                int idx = cozy.getPositionIndex();
                if (idx >= 0 && idx < map.getPath().size()) {
                    Position pos = map.getPath().get(idx);
                    if (tower.isInRange(pos.getX(), pos.getY())) {
                        int cx = pos.getX() * TILE_SIZE + TILE_SIZE / 4;
                        int cy = pos.getY() * TILE_SIZE + TILE_SIZE / 4;
                        int size = TILE_SIZE / 2;
                        g.fillOval(cx, cy, size, size);
                        break;
                    }
                }
            }
        }
    }

    public Tower getTorreSeleccionada() {
        return torreSeleccionada;
    }

}
