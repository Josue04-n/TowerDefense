package TowerDefense;

/**
 *
 * @author LENOVO
 */
public class CozyType {

    private String name;
    private int hp;
    private int speed;

    public CozyType(String name, int hp, int speed) {
        this.name = name;
        this.hp = hp;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return name + " (HP: " + hp + ", Speed: " + speed + ")";
    }

}
