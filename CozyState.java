package TowerDefense;

import java.awt.Image;

/**
 * Interfaz del patrón State para el personaje Cozy.
 * Cada implementación representa un estado de salud diferente
 * y puede devolver una imagen y comportamiento distintos.
 */
public interface CozyState {
    void tick(Cozy cozy, GameMap map, GameContext context);
    Image getImage(Cozy cozy);
}
