package TowerDefense;

public class UpgradeTowerCommand implements Command {
    private Tower tower;

    public UpgradeTowerCommand(Tower tower) {
        this.tower = tower;
    }

    @Override
    public void execute() {
        tower.upgrade();
        System.out.println("Torre en (" + tower.getX() + ", " + tower.getY() + ") mejorada a nivel " + tower.getLevel());
    }

    @Override
    public void undo() {
        tower.downgrade();
        System.out.println("Torre en (" + tower.getX() + ", " + tower.getY() + ") revertida a nivel " + tower.getLevel());
    }
}
