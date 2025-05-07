package TowerDefense;

public class Tower {

    private int x, y;
    private TowerType type;
    private int level;
    private Integer overrideDamage = null;
    private Integer overrideRange = null;

    public Tower(int x, int y, TowerType type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.level = 1; // empieza en nivel 1
    }

    public void upgrade() {
        level++;
    }

    public void downgrade() {
        if (level > 1) {
            level--;
        }
    }

    public int getEffectiveDamage() {
        return type.getDamage() * level;
    }

    public int getDamage() {
        return overrideDamage != null ? overrideDamage : getEffectiveDamage();
    }

    public int getRange() {
        return overrideRange != null ? overrideRange : type.getRange();
    }

    public void setDamage(int damage) {
        this.overrideDamage = damage;
    }

    public void setRange(int range) {
        this.overrideRange = range;
    }

    public boolean isInRange(int enemyX, int enemyY) {
        int dx = enemyX - x;
        int dy = enemyY - y;
        return Math.sqrt(dx * dx + dy * dy) <= type.getRange();
    }

    public void attack(Cozy cozy) {
        cozy.takeDamage(getEffectiveDamage());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLevel() {
        return level;
    }
}
