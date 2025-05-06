package com.mycompany.towerdefense;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MapPanel extends JPanel {

    private int rows;
    private int cols;
    private JButton[][] grid;
    private boolean[][] hasTower;
    private int coins = 10;
    private final int towerCost = 3;

    public MapPanel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new JButton[rows][cols];
        this.hasTower = new boolean[rows][cols];

        setLayout(new GridLayout(rows, cols));
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JButton cell = new JButton();
                cell.setBackground(Color.LIGHT_GRAY);
                cell.setFocusPainted(false);
                int finalI = i;
                int finalJ = j;

                cell.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleCellClick(finalI, finalJ);
                    }
                });

                grid[i][j] = cell;
                hasTower[i][j] = false;
                add(cell);
            }
        }
    }

    private void handleCellClick(int row, int col) {
        if (!hasTower[row][col]) {
            if (coins >= towerCost) {
                grid[row][col].setBackground(Color.BLUE);
                hasTower[row][col] = true;
                coins -= towerCost;

                // Actualizar HUD en GameWindow
                Component parent = SwingUtilities.getWindowAncestor(this);
                if (parent instanceof GameWindow) {
                    ((GameWindow) parent).updateCoins(coins);
                }

                System.out.println("Torre colocada en (" + row + "," + col + "). Monedas restantes: " + coins);
            } else {
                JOptionPane.showMessageDialog(this,
                        "No tienes suficientes monedas para colocar una torre.",
                        "Monedas insuficientes", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public boolean[][] getTowerMap() {
        return hasTower;
    }

    public int getCoins() {
        return coins;
    }

    public void addCoins(int amount) {
        coins += amount;
        Component parent = SwingUtilities.getWindowAncestor(this);
        if (parent instanceof GameWindow) {
            ((GameWindow) parent).updateCoins(coins);
        }
    }

    public boolean hasTowerAt(int row, int col) {
        return hasTower[row][col];
    }
}
