package game.services;

import game.interfaces.WorldServiceInterface;
import game.models.*;
import game.models.enums.BuildingType;
import game.models.enums.CellType;
import game.models.factories.BuildingFactory;

import java.util.ArrayList;
import java.util.List;

public class WorldService implements WorldServiceInterface {

    @Override
    public void buildVillage(World world, Cell cell, String villageName, List<Family> family) {
        if (isVillageWithinDistance(cell, 10, world.getCells()))
            throw new IllegalArgumentException("There's already a village too close");

        if (getSquareCellTypes(cell, 3, world.getCells()).stream()
                .map(Cell::getCellType) // Transform Cells into CellType
                .anyMatch(type -> type == CellType.WATER || type == CellType.OCCUPIED || type == CellType.BUILDING)) {
            throw new IllegalArgumentException("The surrounding area contains restricted cell types (Water, Occupied, or Building).");
        }

        Village newVillage = new Village(villageName, family);
        cell.setVillage(newVillage);
        world.getVillages().add(newVillage);
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
    public void buildBuilding(World world, Village village, Cell cell, BuildingType buildingType) {
        if (getSquareCellTypes(cell, 3, world.getCells()).stream()
                .map(Cell::getCellType) // Transform Cells into CellType
                .anyMatch(type -> type == CellType.WATER || type == CellType.OCCUPIED || type == CellType.BUILDING)) {
            throw new IllegalArgumentException("The surrounding area contains restricted cell types (Water, Occupied, or Building).");
        }

        Building building = BuildingFactory.createBuilding(buildingType);

        if (areAllCellsInVillage(cell, building.getSize(), world.getCells(), village)) {
            throw new IllegalStateException("The cell does not belong to the village.");
        }

        cell.getVillage().addBuilding(building);
        setCellTypesInRange(cell, building.getSize(), world.getCells(), CellType.BUILDING);

    }

    @Override
    public void destroyBuilding(World world, String buildingName) {

    }

    @Override
    public void movementEntity(World world, Cell cellStart, Cell cellTarget, Entity entity) {

    }

    private boolean isVillageWithinDistance(Cell cell, int rangeTarget, List<Cell> allCells) {
        for (Cell other : allCells) {
            int range = Math.max(Math.abs(cell.getX() - other.getX()), Math.abs(cell.getY() - other.getY()));
            if (range <= rangeTarget && other.getVillage() != null) return true;
        }
        return false;
    }

    private boolean areAllCellsInVillage(Cell cell, int rangeTarget, List<Cell> allCells, Village village) {
        for (Cell other : allCells) {
            int range = Math.max(Math.abs(cell.getX() - other.getX()), Math.abs(cell.getY() - other.getY()));
            if (range <= rangeTarget) {
                if (other.getVillage() == null || !other.getVillage().equals(village)) return false;
            }
        }
        return true;
    }

    private void setCellTypesInRange(Cell cell, int rangeTarget, List<Cell> allCells, CellType newType) {
        for (Cell other : allCells) {
            int range = Math.max(Math.abs(cell.getX() - other.getX()), Math.abs(cell.getY() - other.getY()));
            if (range > 0 && range <= rangeTarget)
                other.setCellType(newType);
        }
    }

    private List<Cell> getSquareCellTypes(Cell cell, int rangeTarget, List<Cell> allCells) {
        List<Cell> surroundingCells = new ArrayList<>();
        for (Cell other : allCells) {
            int range = Math.max(Math.abs(cell.getX() - other.getX()), Math.abs(cell.getY() - other.getY()));
            if (range > 0 && range <= rangeTarget) surroundingCells.add(other);
        }
        return surroundingCells;
    }
}
