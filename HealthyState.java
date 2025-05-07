package TowerDefense;

import javax.swing.*;
import java.awt.*;

public class HealthyState implements CozyState {

    // Imagen cargada una sola vez como recurso estático
    private static final Image img = new ImageIcon(
        HealthyState.class.getResource("/TowerDefense/imgs/soldado1.png")
    ).getImage();

    // Constructor válido (ya no lanza excepción)
    public HealthyState() {
        // Puedes dejarlo vacío
    }

    @Override
    public void tick(Cozy cozy, GameMap map, GameContext context) {
        cozy.moveForward();
    }

    @Override
    public Image getImage(Cozy cozy) {
        return img;
    }
}
