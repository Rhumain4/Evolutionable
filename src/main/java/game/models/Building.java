package game.models;

import game.models.enums.BuildingType;

public abstract class Building {
    private String name;
    private BuildingType type;
    private int size;
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

    public void setType(BuildingType type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }
}