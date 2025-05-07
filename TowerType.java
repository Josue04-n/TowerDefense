package TowerDefense;

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
