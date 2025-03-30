package game.interfaces;

import game.models.Cell;
import game.models.Entity;
import game.models.World;
import game.models.enums.BuildingType;

public interface WorldServiceInterface {


    /**
     * Builds a new village at the specified cell in the world.
     *
     * @param world the world object where the village will be built.
     * @param cell  the cell where the village will be constructed.
     */
    void buildVillage(World world, Cell cell);

    /**
     * Destroys the village with the given name in the specified world.
     *
     * @param world       the world object where the village to be destroyed exists.
     * @param villageName the name of the village to be destroyed.
     */
    void destroyVillage(World world, String villageName);

    /**
     * Removes an existing road at the specified cell in the world.
     *
     * @param world the world object where the road will be removed.
     * @param cell  the cell where the road exists.
     */
    void destroyRoad(World world, Cell cell);

    /**
     * Builds a road at the specified cell in the world.
     *
     * @param world the world object where the road will be built.
     * @param cell  the cell where the road will be constructed.
     */
    void buildRoad(World world, Cell cell);

    /**
     * Constructs a building of the specified type at the given cell in the world.
     *
     * @param world        the world object where the building will be constructed.
     * @param cell         the cell where the building will be built.
     * @param buildingType the type of building to be constructed.
     */
    void buildBuilding(World world, Cell cell, BuildingType buildingType);

    /**
     * Destroys a building with the specified name in the world.
     *
     * @param world        the world object where the building exists.
     * @param buildingName the name of the building to be destroyed.
     */
    void destroyBuilding(World world, String buildingName);

    /**
     * Moves an entity from the starting cell to the target cell in the world.
     *
     * @param world      the world object where the movement will occur.
     * @param cellStart  the cell where the entity currently resides.
     * @param cellTarget the cell where the entity will move to.
     * @param entity     the entity to be moved.
     */
    void movementEntity(World world, Cell cellStart, Cell cellTarget, Entity entity);

}
