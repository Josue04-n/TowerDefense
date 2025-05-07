package TowerDefense;

import javax.swing.*;
import java.awt.*;

public class CriticalState implements CozyState {

    private static final Image img = new ImageIcon(
        CriticalState.class.getResource("/TowerDefense/imgs/soldadoherido.png")
    ).getImage();

    public CriticalState() {
        // Constructor vacío válido
    }

    @Override
    public void tick(Cozy cozy, GameMap map, GameContext context) {
        cozy.moveForward();
        // No se necesita cambiar el estado aquí,
        // Cozy se actualiza solo según HP en getState()
    }

    @Override
    public Image getImage(Cozy cozy) {
        return img;
    }
}
