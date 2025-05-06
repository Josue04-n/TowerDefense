/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.towerdefense;

/**
 *
 * @author LENOVO
 */
public class TowerType {
    private String name;
    private int range;
    private int damage;

    public TowerType(String name, int range, int damage) {
        this.name = name;
        this.range = range;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getRange() {
        return range;
    }

    public int getDamage() {
        return damage;
    }
}
