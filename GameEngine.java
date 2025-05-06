/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.towerdefense;
import java.util.*;

/**
 *
 * @author LENOVO
 */

public class GameEngine {
    private GameMap gameMap;
    private List<Wave> waves;
    private int currentWaveIndex;
    private CircularQueue<Cozy> cozyQueue;
    private int playerHealth;
    private int score;

    public GameEngine(GameMap gameMap, List<Wave> waves, int maxCozyCapacity, int initialHealth) {
        this.gameMap = gameMap;
        this.waves = waves;
        this.currentWaveIndex = 0;
        this.cozyQueue = new CircularQueue<>(maxCozyCapacity);
        this.playerHealth = initialHealth;
        this.score = 0;
    }

    public void startNextWave() {
        if (currentWaveIndex < waves.size()) {
            Wave wave = waves.get(currentWaveIndex);
            while (wave.hasNextCozy()) {
                cozyQueue.enqueue(wave.getNextCozy());
            }
            currentWaveIndex++;
            System.out.println("Wave " + wave.getWaveNumber() + " started.");
        } else {
            System.out.println("All waves completed!");
        }
    }

    public void tick() {
        int size = cozyQueue.getSize();
        for (int i = 0; i < size; i++) {
            Cozy cozy = cozyQueue.dequeue();

            // Movimiento del Cozy
            cozy.moveForward();

            // Comprobar si llegó al final del camino
            if (cozy.getPositionIndex() >= gameMap.getPath().size()) {
                playerHealth -= 10;
                System.out.println("Cozy reached the end! Player health: " + playerHealth);
                continue; // no se re-agrega a la cola
            }

            // Coordenadas actuales del Cozy
            Position pos = gameMap.getPath().get(cozy.getPositionIndex());

            // Las torres atacan al Cozy si está en su rango
            for (Tower tower : gameMap.getTowers()) {
                if (tower.isInRange(pos.getX(), pos.getY())) {
                    tower.attack(cozy);
                }
            }

            if (cozy.isDead()) {
                System.out.println("Cozy defeated!");
                score += 5;
            } else {
                cozyQueue.enqueue(cozy); // seguir procesándolo en el siguiente ciclo
            }
        }
    }

    public boolean isGameOver() {
        return playerHealth <= 0;
    }

    public int getScore() {
        return score;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public boolean hasMoreWaves() {
        return currentWaveIndex < waves.size();
    }

    public boolean hasActiveCozy() {
        return !cozyQueue.isEmpty();
    }
}

