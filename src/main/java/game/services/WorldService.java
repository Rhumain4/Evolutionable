package game.services;

import game.interfaces.WorldServiceInterface;
import game.models.*;
import game.models.enums.BuildingType;
import game.models.enums.CellType;
import game.models.factories.BuildingFactory;

import java.util.List;
import java.util.stream.Collectors;

public class WorldService implements WorldServiceInterface {

    @Override
    public void buildVillage(World world, Cell cell, String villageName, List<Family> family) {
        if (world.getVillages().stream().anyMatch(v -> v.getName().equals(villageName)))
            throw new IllegalArgumentException("There's already a village with this name: " + villageName);

        if (isVillageWithinDistance(cell, 10, world.getCells()))
            throw new IllegalArgumentException("There's already a village too close");

        if (getSquareCellTypes(cell, 3, world.getCells()).stream()
                .map(Cell::getCellType) // Transform Cells into CellType
                .anyMatch(type -> type == CellType.WATER || type == CellType.OCCUPIED || type == CellType.BUILDING))
            throw new IllegalArgumentException("The surrounding area contains restricted cell types (Water, Occupied, or Building).");

        Village newVillage = new Village(villageName, family);
        cell.setVillage(newVillage);
        buildBuilding(world, newVillage, cell, BuildingType.RESIDENTIAL);
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
        Building building = BuildingFactory.createBuilding(buildingType);

        List<Cell> locationCells = getSquareCellTypes(cell, building.getSize(), world.getCells());

        boolean hasRestrictedType = locationCells.stream()
                .map(Cell::getCellType)
                .anyMatch(type -> type == CellType.WATER || type == CellType.OCCUPIED || type == CellType.BUILDING);

        if (hasRestrictedType) {
            throw new IllegalArgumentException("The surrounding area contains restricted cell types (Water, Occupied, or Building).");
        }

        if (areAllCellsInVillage(cell, building.getSize(), world.getCells(), village)) {
            throw new IllegalStateException("The cell does not belong to the village.");
        }

        cell.getVillage().addBuilding(building);
        setCellTypesInRange(cell, building.getSize(), world.getCells(), CellType.BUILDING);
        setCellVillage(cell, building.getSize() + 2, world.getCells(), village);
    }


    @Override
    public void destroyBuilding(World world, String buildingName) {

    }

    @Override
    public void movementEntity(World world, Cell cellStart, Cell cellTarget, Entity entity) {

    }

    private int calculateRange(Cell c1, Cell c2) {
        return Math.max(Math.abs(c1.getX() - c2.getX()), Math.abs(c1.getY() - c2.getY()));
    }

    private boolean isVillageWithinDistance(Cell cell, int rangeTarget, List<Cell> allCells) {
        return allCells.stream()
                .filter(other -> calculateRange(cell, other) <= rangeTarget)
                .anyMatch(other -> other.getVillage() != null);
    }

    private boolean areAllCellsInVillage(Cell cell, int rangeTarget, List<Cell> allCells, Village village) {
        return allCells.stream()
                .filter(other -> calculateRange(cell, other) <= rangeTarget)
                .allMatch(other -> village.equals(other.getVillage()));
    }

    private void setCellTypesInRange(Cell cell, int rangeTarget, List<Cell> allCells, CellType newType) {
        allCells.stream()
                .filter(other -> {
                    int range = calculateRange(cell, other);
                    return range > 0 && range <= rangeTarget;
                })
                .forEach(other -> other.setCellType(newType));
    }

    private void setCellVillage(Cell cell, int rangeTarget, List<Cell> allCells, Village village) {
        allCells.stream()
                .filter(other -> {
                    int range = calculateRange(cell, other);
                    return range > 0 && range <= rangeTarget;
                })
                .forEach(other -> other.setVillage(village));
    }

    private List<Cell> getSquareCellTypes(Cell cell, int rangeTarget, List<Cell> allCells) {
        return allCells.stream()
                .filter(other -> {
                    int range = calculateRange(cell, other);
                    return range > 0 && range <= rangeTarget;
                })
                .collect(Collectors.toList());
    }

}
