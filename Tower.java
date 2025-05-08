package TowerDefense;

import javax.swing.ImageIcon;
import java.awt.Image;

public class Tower {

    private int x, y;
    private TowerType type;
    private int level;
    private Integer overrideDamage = null;
    private Integer overrideRange = null;

    private Image image;

    public Tower(int x, int y, TowerType type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.level = 1;
        this.image = loadImageForLevel(level); // Cargar imagen de nivel 1
    }

    public void upgrade() {
        level++;
        this.image = loadImageForLevel(level); // Cargar imagen del nuevo nivel
    }

    public void downgrade() {
        if (level > 1) {
            level--;
            this.image = loadImageForLevel(level); // Cargar imagen del nuevo nivel
        }
    }

    private Image loadImageForLevel(int level) {
        String basePath = type.getImagePath(); // Ej: "/TowerDefense/imgs/soldado1.png"
        String levelPath = basePath.replace(".png", "_lvl" + level + ".png");

        try {
            return new ImageIcon(getClass().getResource(levelPath)).getImage();
        } catch (Exception e) {
            System.err.println("⚠️ Imagen para nivel " + level + " no encontrada. Usando imagen base.");
            try {
                return new ImageIcon(getClass().getResource(basePath)).getImage();
            } catch (Exception ex) {
                System.err.println("❌ Imagen base también no encontrada.");
                return null;
            }
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
    
    public int getUpgradeCost() {
    switch (level) {
        case 1: return 30;
        case 2: return 50;
        default: return Integer.MAX_VALUE; // Muy alto para evitar mejoras adicionales
    }
}


    public boolean isInRange(int enemyX, int enemyY) {
        int dx = enemyX - x;
        int dy = enemyY - y;
        return Math.sqrt(dx * dx + dy * dy) <= getRange();
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

    public Image getImage() {
        return image;
    }
}
