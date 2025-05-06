/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.towerdefense;

/**
 *
 * @author LENOVO
 */
public class UpgradeTowerCommand implements Command {
    private Tower tower;

    public UpgradeTowerCommand(Tower tower) {
        this.tower = tower;
    }

    @Override
    public void execute() {
        tower.upgrade();
        System.out.println("Torre en (" + tower.getX() + ", " + tower.getY() + ") mejorada a nivel " + tower.getLevel());
    }

    @Override
    public void undo() {
        tower.downgrade();
        System.out.println("Torre en (" + tower.getX() + ", " + tower.getY() + ") revertida a nivel " + tower.getLevel());
    }
}
