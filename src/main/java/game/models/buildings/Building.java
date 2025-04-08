package game.models.buildings;

import game.models.Cell;
import game.models.Family;
import game.models.enums.BuildingType;

public abstract class Building {
    private final String name;
    private final BuildingType type;
    private final int size;
    private int level;
    private Family family;
    private Cell centerPosition;

    // Constructor
    protected Building(String name, BuildingType type, int size, Cell centerPosition) {
        this.type = type;
        this.name = name;
        this.size = size;
        this.level = 1;
        this.centerPosition = centerPosition;
        this.family = null;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public BuildingType getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Cell getCenterPosition() {
        return centerPosition;
    }

    public void setCenterPosition(Cell centerPosition) {
        this.centerPosition = centerPosition;
    }
}