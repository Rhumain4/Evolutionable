package game.services;

import game.models.Cell;
import game.models.Entity;
import game.models.World;
import game.models.enums.CellType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class EntityMovementService implements TimeService.TimeChangeListener {
    private final World world;
    private final Random random = new Random();

    public EntityMovementService(World world) {
        this.world = world;
    }

    @Override
    public void onTimeChange(int currentDay, int currentHour, int currentMinute) {
        for (Cell cell : world.getCells()) {
            List<Entity> entitiesToMove = new ArrayList<>(cell.getEntities());

            for (Entity entity : entitiesToMove) {
                if (random.nextDouble() < 0.33) {
                    moveEntityRandomly(entity, cell);
                }
            }
        }
    }

    private void moveEntityRandomly(Entity entity, Cell currentCell) {
        List<Cell> neighbours = getNeighbourCells(currentCell);
        Collections.shuffle(neighbours);

        for (Cell target : neighbours) {
            if (target.getCellType() != CellType.WATER) {
                currentCell.getEntities().remove(entity);
                target.getEntities().add(entity);
                entity.setPosition(target);
                break;
            }
        }
    }

    private List<Cell> getNeighbourCells(Cell cell) {
        int x = cell.getX();
        int y = cell.getY();

        List<Cell> neighbours = new ArrayList<>();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;
                Cell neighbour = world.getCellAt(x + dx, y + dy);
                if (neighbour != null) {
                    neighbours.add(neighbour);
                }
            }
        }

        return neighbours;
    }
}
