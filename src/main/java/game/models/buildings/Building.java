package game.models.buildings;

import game.models.enums.BuildingType;

public abstract class Building {
    private final String name;
    private final BuildingType type;
    private final int size;
    private int level;

    // Constructor
    public Building(String name, BuildingType type, int size) {
        this.type = type;
        this.name = name;
        this.size = size;
        this.level = 1;
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
}