/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.towerdefense;

/**
 *
 * @author LENOVO
 */
import java.util.*;

import javax.swing.*;

public class main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crear mapa y camino
            GameMap gameMap = new GameMap(10, 10, createPath());

            // Crear oleadas
            List<Wave> waveList = List.of(
                    new Wave(1, new CozyType("Slime", 30, 1), 5),
                    new Wave(2, new CozyType("Goblin", 50, 1), 7)
            );

            // Inicializar motor del juego y manejador de comandos
            GameEngine engine = new GameEngine(gameMap, waveList, 20, 100);
            CommandManager commandManager = new CommandManager();

            // Lanzar ventana gráfica del juego
            GameWindow gameWindow = new GameWindow(gameMap, engine, commandManager);
            gameWindow.setVisible(true);
        });
    }

    private static List<Position> createPath() {
        List<Position> path = new ArrayList<>();
        for (int x = 0; x < 10; x++) {
            path.add(new Position(x, 5));
        }
        return path;
    }
}
