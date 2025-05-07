package TowerDefense;

import javax.swing.*;
import java.awt.*;

public class DeadState implements CozyState {
    private static final Image img = new ImageIcon(HealthyState.class.getResource("/TowerDefense/imgs/soldadoMuerto.png")).getImage();


    @Override
    public void tick(Cozy cozy, GameMap map, GameContext context) {
        // No hace nada
    }

    @Override
    public Image getImage(Cozy cozy) {
        return img;
    }
}
