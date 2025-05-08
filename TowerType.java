package TowerDefense;

/**
 * Representa un tipo de torre disponible para construir. Cada tipo tiene un
 * nombre, un rango de ataque y una cantidad de daño base.
 */
public class TowerType {
    private String name;
    private int range;
    private int damage;
    private int cost;          // 💰 Nuevo atributo
    private String imagePath;

    public TowerType(String name, int range, int damage, int cost, String imagePath) {
        this.name = name;
        this.range = range;
        this.damage = damage;
        this.cost = cost;
        this.imagePath = imagePath;
    }

    public String getName() { return name; }
    public int getRange() { return range; }
    public int getDamage() { return damage; }
    public int getCost()   { return cost; }         // ✅ Getter nuevo
    public String getImagePath() { return imagePath; }

    @Override
    public String toString() {
        return name + " (Range: " + range + ", Damage: " + damage + ", Cost: " + cost + ")";
    }
}

