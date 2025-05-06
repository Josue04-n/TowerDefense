/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.towerdefense;

/**
 *
 * @author LENOVO
 */
public class Tower {
    private int x, y;
    private TowerType type;
    private int level;

    public Tower(int x, int y, TowerType type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.level = 1; // empieza en nivel 1
    }

    public void upgrade() {
        level++;
    }

    public void downgrade() {
        if (level > 1) level--;
    }

    public int getEffectiveDamage() {
        return type.getDamage() * level;
    }

    public boolean isInRange(int enemyX, int enemyY) {
        int dx = enemyX - x;
        int dy = enemyY - y;
        return Math.sqrt(dx * dx + dy * dy) <= type.getRange();
    }

    public void attack(Cozy cozy) {
        cozy.takeDamage(getEffectiveDamage());
    }

    // Getters
    public int getX() { return x; }
    public int getY() { return y; }
    public int getLevel() { return level; }
}
