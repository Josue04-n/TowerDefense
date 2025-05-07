/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TowerDefense;

public class CozyFactory {
    public static Cozy create(CozyType type) {
        return new Cozy(type.getHp(), type.getSpeed());
    }
}