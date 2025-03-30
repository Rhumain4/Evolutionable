package game.services;

import game.interfaces.WorldServiceInterface;
import game.models.Cell;
import game.models.Entity;
import game.models.World;
import game.models.enums.BuildingType;

public class WorldService implements WorldServiceInterface {
    @Override
    public void buildVillage(World world, Cell cell) {

    }

    @Override
    public void destroyVillage(World world, String villageName) {

    }

    @Override
    public void destroyRoad(World world, Cell cell) {

    }

    @Override
    public void buildRoad(World world, Cell cell) {

    }

    @Override
    public void buildBuilding(World world, Cell cell, BuildingType buildingType) {

    }

    @Override
    public void destroyBuilding(World world, String buildingName) {

    }

    @Override
    public void movementEntity(World world, Cell cellStart, Cell cellTarget, Entity entity) {

    }
}
