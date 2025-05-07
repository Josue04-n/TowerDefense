package TowerDefense;

import java.util.LinkedList;
import java.util.Queue;

public class Wave {
    private Queue<Cozy> cozyQueue;
    private int waveNumber;

    public Wave(int waveNumber, CozyType cozyType, int quantity) {
        this.waveNumber = waveNumber;
        this.cozyQueue = new LinkedList<>();

        for (int i = 0; i < quantity; i++) {
            cozyQueue.add(CozyFactory.create(cozyType));
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
