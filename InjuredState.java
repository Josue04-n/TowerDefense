package TowerDefense;

import javax.swing.*;
import java.awt.*;

public class InjuredState implements CozyState {

    // Carga la imagen adecuada una vez al iniciar la clase
    private static final Image img = new ImageIcon(
        InjuredState.class.getResource("/TowerDefense/imgs/soldadov2.png")
    ).getImage();

    // Constructor válido
    public InjuredState() {
        // vacío
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
