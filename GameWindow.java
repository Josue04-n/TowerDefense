/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.towerdefense;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author LENOVO
 */


public class GameWindow extends JFrame {
    private GameMap gameMap;
    private GameEngine engine;
    private CommandManager commandManager;

    private MapPanel mapPanel;
    private JLabel coinsLabel;

    public GameWindow(GameMap gameMap, GameEngine engine, CommandManager commandManager) {
        this.gameMap = gameMap;
        this.engine = engine;
        this.commandManager = commandManager;

        setTitle("Tower Defense");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear panel del mapa
        mapPanel = new MapPanel(10, 10); // Ajusta si es dinámico
        add(mapPanel, BorderLayout.CENTER);

        // Panel inferior (HUD)
        JPanel bottomPanel = new JPanel();
        JButton nextWaveBtn = new JButton("Siguiente Ola");
        nextWaveBtn.addActionListener(e -> engine.startNextWave());

        JButton tickBtn = new JButton("Tick");
        tickBtn.addActionListener(e -> engine.tick());

        JButton undoBtn = new JButton("Undo");
        undoBtn.addActionListener(e -> commandManager.undo());

        JButton redoBtn = new JButton("Redo");
        redoBtn.addActionListener(e -> commandManager.redo());

        coinsLabel = new JLabel("Monedas: " + mapPanel.getCoins());
        bottomPanel.add(nextWaveBtn);
        bottomPanel.add(tickBtn);
        bottomPanel.add(undoBtn);
        bottomPanel.add(redoBtn);
        bottomPanel.add(coinsLabel);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    public void updateCoins(int coins) {
        coinsLabel.setText("Monedas: " + coins);
    }
}
