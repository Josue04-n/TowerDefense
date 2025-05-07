package TowerDefense;

import java.awt.Image;

public class Cozy {
    private int hp;
    private int positionIndex;
    private int speed;

    public Cozy(int hp, int speed) {
        this.hp = hp;
        this.speed = speed;
    }

    public void moveForward() {
        positionIndex += speed;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public void takeDamage(int damage) {
        hp -= damage;
    }

    public void tick(GameMap map, GameContext context) {
        getState().tick(this, map, context);
    }

    public int getPositionIndex() {
        return positionIndex;
    }

    public int getHP() {
        return hp;
    }

    public int getSpeed() {
        return speed;
    }

    public Image getCurrentImage() {
        return getState().getImage(this);
    }

    // Nuevo: selecciona estado automáticamente basado en HP
    public CozyState getState() {
        if (isDead()) return new DeadState();
        if (hp >= 60) return new HealthyState();
        if (hp >= 30) return new InjuredState();
        return new CriticalState();
    }
    

    
    
    void setState(DeadState deadState) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
