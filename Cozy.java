/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.towerdefense;

/**
 *
 * @author LENOVO
 */
public class Cozy {

    private String name;
    private int maxHp;
    private int currentHp;
    private int positionIndex; // posición en el camino
    private CozyType type;

    public Cozy(CozyType type) {
        this.name = type.getName();
        this.maxHp = type.getHp();
        this.currentHp = this.maxHp;
        this.positionIndex = 0;
        this.type = type;
    }

    public void moveForward() {
        positionIndex++;
    }

    public void takeDamage(int damage) {
        currentHp -= damage;
    }

    public boolean isDead() {
        return currentHp <= 0;
    }

    public int getPositionIndex() {
        return positionIndex;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public String getName() {
        return name;
    }

    public void reset() {
        this.currentHp = this.maxHp;
        this.positionIndex = 0;

    }

    @Override
    public String toString() {
        return name + " (HP: " + currentHp + "/" + maxHp + ", Pos: " + positionIndex + ")";
    }
    
    public CozyType getType() {
    return type;
}


}
