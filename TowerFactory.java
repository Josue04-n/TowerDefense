/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TowerDefense;


import java.util.HashMap;
import java.util.Map;

public class TowerFactory {
    private static final Map<String, TowerType> types = new HashMap<>();

    static {
        types.put("basic", new TowerType("Basic", 2, 20));
        types.put("sniper", new TowerType("Sniper", 4, 35));
        types.put("cannon", new TowerType("Cannon", 3, 50));
    }

    public static Tower create(String typeName, int x, int y) {
        TowerType type = types.get(typeName.toLowerCase());
        if (type == null) {
            throw new IllegalArgumentException("Tipo de torre no válido: " + typeName);
        }
        return new Tower(x, y, type);
    }

    public static TowerType getTowerType(String name) {
        return types.get(name.toLowerCase());
    }
}
