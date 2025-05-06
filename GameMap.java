/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.towerdefense;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class GameMap {

    private int width;
    private int height;
    private char[][] mapGrid; // Representación visual del mapa
    private List<Tower> towers;
    private List<Position> path; // Camino predefinido que seguirán los Cozys

    public GameMap(int width, int height, List<Position> path) {
        this.width = width;
        this.height = height;
        this.mapGrid = new char[height][width];
        this.towers = new ArrayList<>();
        this.path = path;
        initializeMap();
    }

    private void initializeMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                mapGrid[i][j] = '.'; // '.' indica celda vacía
            }
        }
        for (Position p : path) {
            mapGrid[p.getY()][p.getX()] = '*'; // '*' indica camino
        }
    }

    public boolean placeTower(Tower tower) {
        int x = tower.getX();
        int y = tower.getY();

        if (isValidPosition(x, y) && mapGrid[y][x] == '.') {
            towers.add(tower);
            mapGrid[y][x] = 'T';
            return true;
        }
        return false;
    }

    public boolean removeTower(int x, int y) {
        for (Tower tower : towers) {
            if (tower.getX() == x && tower.getY() == y) {
                towers.remove(tower);
                mapGrid[y][x] = '.';
                return true;
            }
        }
        return false;
    }

    public List<Tower> getTowers() {
        return towers;
    }

    public List<Position> getPath() {
        return path;
    }

    public void printMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(mapGrid[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public boolean hasTowerAt(int x, int y) {
        return mapGrid[y][x] == 'T';
    }

}
