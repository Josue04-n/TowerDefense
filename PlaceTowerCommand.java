/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.towerdefense;

/**
 *
 * @author LENOVO
 */
public class PlaceTowerCommand implements Command {
    private GameMap map;
    private Tower tower;
    private boolean executed;

    public PlaceTowerCommand(GameMap map, Tower tower) {
        this.map = map;
        this.tower = tower;
        this.executed = false;
    }

    @Override
    public void execute() {
        if (map.placeTower(tower)) {
            executed = true;
            System.out.println("Tower placed at (" + tower.getX() + ", " + tower.getY() + ")");
        } else {
            System.out.println("Failed to place tower.");
        }
    }

    @Override
    public void undo() {
        if (executed) {
            if (map.removeTower(tower.getX(), tower.getY())) {
                System.out.println("Tower removed from (" + tower.getX() + ", " + tower.getY() + ")");
            }
        }
    }
}
