package TowerDefense;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameMap {

    private static final char EMPTY = '.';
    private static final char PATH = '*';
    private static final char TOWER = 'T';

    private int width;
    private int height;
    private char[][] mapGrid;
    private List<Tower> towers;
    private List<Position> path;

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.mapGrid = new char[height][width];
        this.towers = new ArrayList<>();
        this.path = new ArrayList<>();
        initializeMap();
    }

private void initializeMap() {
    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            mapGrid[y][x] = EMPTY;
        }
    }

    // Definir camino recto horizontal en la fila y = 3
    int caminoY = 3;
    for (int x = 0; x < width; x++) {
        Position p = new Position(x, caminoY);
        path.add(p);
        mapGrid[caminoY][x] = PATH;
    }
}

    public boolean placeTower(Tower tower) {
        int x = tower.getX();
        int y = tower.getY();

        if (!isValidPosition(x, y)) return false;

        if (mapGrid[y][x] != EMPTY) return false;

        towers.add(tower);
        mapGrid[y][x] = TOWER;
        return true;
    }

    public boolean removeTower(int x, int y) {
        Iterator<Tower> it = towers.iterator();
        while (it.hasNext()) {
            Tower tower = it.next();
            if (tower.getX() == x && tower.getY() == y) {
                it.remove();
                mapGrid[y][x] = EMPTY;
                return true;
            }
        }
        return false;
    }

    public Tower getTowerAt(int x, int y) {
        for (Tower t : towers) {
            if (t.getX() == x && t.getY() == y) {
                return t;
            }
        }
        return null;
    }

    public List<Tower> getTowers() {
        return towers;
    }

    public List<Position> getPath() {
        return path;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    
public void setPath(List<Position> newPath) {
    this.path = newPath;
    // Limpia y marca el camino
    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            if (mapGrid[y][x] != 'T') mapGrid[y][x] = EMPTY; // no borres torres
        }
    }
    for (Position p : newPath) {
        if (isValidPosition(p.getX(), p.getY())) {
            mapGrid[p.getY()][p.getX()] = PATH;
        }
    }
}

    
    public void printMap() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(mapGrid[y][x] + " ");
            }
            System.out.println();
        }
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public boolean hasTowerAt(int x, int y) {
        return mapGrid[y][x] == TOWER;
    }
    
    public void clearTowers() {
    for (Tower t : towers) {
        mapGrid[t.getY()][t.getX()] = EMPTY;
    }
    towers.clear();
}

}
