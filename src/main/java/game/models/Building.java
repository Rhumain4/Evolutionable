package game.models;

import game.models.enums.BuildingType;

public class Building {
    private String name;
    private BuildingType buildingType;

    // Constructor
    public Building(BuildingType buildingType) {
        this.name = buildingType.toString();
        this.buildingType = buildingType;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BuildingType getbuildingType() {
        return buildingType;
    }

    public void setbuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }
}