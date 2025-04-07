package game.services;

import game.models.*;
import game.models.enums.Biome;
import game.models.enums.CellType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class WorldServiceTest {
    private World world;
    private Cell cell;
    private Entity entity;
    private Family family;

    @BeforeEach
    void setUp() {
        WorldService worldService = new WorldService();
        Cell cell1 = new Cell(0, 0, Biome.PLAINS, CellType.OCCUPIED);
        Cell cell2 = new Cell(0, 1, Biome.PLAINS, CellType.EMPTY);
        Needs needs = new Needs(100, 100, 100);
    }

    @Test
    void movementCellEntityTest_OK() {

    }
}
