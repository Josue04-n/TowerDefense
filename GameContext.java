/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TowerDefense;

import java.util.Queue;
import java.util.LinkedList;




public class GameContext {
    private int playerHealth = 100;
    private int score = 0;
    private Queue<Cozy> cozyQueue = new LinkedList<>();



    public void reducePlayerHealth(int amount) {
    playerHealth -= amount;
    if (playerHealth < 0) playerHealth = 0;
}
    
    
  
    public int getPlayerHealth() {
        return playerHealth;
    }

    public void addScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }

    public void requeueCozy(Cozy cozy) {
        cozyQueue.add(cozy);
    }

    public Queue<Cozy> getCozyQueue() {
        return cozyQueue;
    }
}