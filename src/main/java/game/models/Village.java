package game.models;

import java.util.ArrayList;
import java.util.List;

public class Village {
    private String name;
    private List<Family> families;
    private List<Building> buildings;

    // Constructor
    public Village(String name) {
        this.name = name;
        this.families = new ArrayList<>();
        this.buildings = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public List<Family> getFamilies() {
        return families;
    }

    public void setFamilies(List<Family> families) {
        this.families = families;
    }

    // Add a building to the village
    public void addBuilding(Building building) {
        buildings.add(building);
    }
}