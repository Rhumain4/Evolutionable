package game.interfaces;

import game.models.*;
import game.models.buildings.Building;
import game.models.enums.BuildingType;

import java.util.List;

public interface WorldServiceInterface {


    /**
     * Builds a new village at the specified cell in the world.
     *
     * @param world       the world object where the village will be built.
     * @param cell        the cell where the village will be constructed.
     * @param villageName the name of the village to be created.
     * @param family      the list of families that will inhabit the new village.
     */
    void buildVillage(World world, Cell cell, String villageName, List<Family> family);

    /**
     * Destroys the village with the given name in the specified world.
     *
     * @param world       the world object where the village to be destroyed exists.
     * @param village     the village to be destroyed.
     */
    void destroyVillage(World world, Village village);

    /**
     * Constructs a building of the specified type at the given cell in the world.
     *
     * @param world        the world object where the building will be constructed.
     * @param village      the village object where the building will be constructed.
     * @param cell         the cell where the building will be built.
     * @param buildingType the type of building to be constructed.
     */

    void buildBuilding(World world, Village village, Cell cell, BuildingType buildingType, Family family);

    /**
     * Destroys a building with the specified name in the world.
     *
     * @param world              the world object where the building exists.
     * @param buildingToDestroy  the building to be destroyed.
     */
    void destroyBuilding(World world, Village village, Building buildingToDestroy);

    /**
     * Moves an entity from the starting cell to the target cell in the world.
     *
     * @param world      the world object where the movement will occur.
     * @param cellStart  the cell where the entity currently resides.
     * @param cellTarget the cell where the entity will move to.
     * @param entity     the entity to be moved.
     */
    void movementCellEntity(World world, Cell cellStart, Cell cellTarget, Entity entity);
}
