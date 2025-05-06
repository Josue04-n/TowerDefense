/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.towerdefense;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author LENOVO
 */

public class Wave {
    private Queue<Cozy> cozyQueue;
    private int waveNumber;

    public Wave(int waveNumber, CozyType cozyType, int quantity) {
        this.waveNumber = waveNumber;
        this.cozyQueue = new LinkedList<>();

        for (int i = 0; i < quantity; i++) {
            cozyQueue.add(new Cozy(cozyType));
        }
    }

    public boolean hasNextCozy() {
        return !cozyQueue.isEmpty();
    }

    public Cozy getNextCozy() {
        return cozyQueue.poll();
    }

    public int getRemainingCozyCount() {
        return cozyQueue.size();
    }

    public int getWaveNumber() {
        return waveNumber;
    }
}
