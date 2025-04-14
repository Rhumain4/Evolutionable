package game.models;

import game.models.buildings.Building;
import game.models.enums.Biome;
import game.models.enums.CellType;
import game.models.items.Log;
import game.models.ressources.Bush;
import game.models.ressources.HarvestableResource;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private int x;
    private int y;
    private Biome biome;
    private CellType cellType;
    private List<Entity> entities;
    private Building building;
    private Village village;
    private HarvestableResource resource;


    // Constructor
    public Cell(int x, int y, Biome biome, CellType cellType) {
        this.x = x;
        this.y = y;
        this.biome = biome;
        this.cellType = cellType;
        this.entities = new ArrayList<>();
        this.building = null;
        this.resource = new Bush();
    }

    // Getters and Setters
    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
        this.setCellType(CellType.BUILDING);
    }

    public HarvestableResource getResource() {
        return resource;
    }

    public void setResource(HarvestableResource resource) {
        this.resource = resource;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Biome getBiome() {
        return biome;
    }

    public void setBiome(Biome biome) {
        this.biome = biome;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }
}