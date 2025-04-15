package game.services;

import game.models.Cell;
import game.models.Entity;
import game.models.Human;
import game.models.World;
import game.models.enums.CellType;

import java.util.Collections;
import java.util.List;

public class EntityMovementService {
    private final World world;

    public EntityMovementService(World world) {
        this.world = world;
    }

    public void moveHumanHome(Human human) {
        Cell currentCell = human.getPosition();
        Cell homeCell = human.getFamily().getResidentialBuilding().getCenterPosition();

        if (homeCell == null || currentCell == homeCell) return;

        int dx = Integer.compare(homeCell.getX(), currentCell.getX());
        int dy = Integer.compare(homeCell.getY(), currentCell.getY());

        if (tryMoveTo(human, currentCell, currentCell.getX() + dx, currentCell.getY() + dy)) return;
        if (dx != 0 && tryMoveTo(human, currentCell, currentCell.getX() + dx, currentCell.getY())) return;
        if (dy != 0) tryMoveTo(human, currentCell, currentCell.getX(), currentCell.getY() + dy);
    }

    public void moveRandomly(Entity entity) {
        Cell currentCell = entity.getPosition();
        List<Cell> neighbours = world.getNeighbourCells(currentCell);
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

    private boolean tryMoveTo(Entity entity, Cell from, int x, int y) {
        Cell to = world.getCellAt(x, y);
        if (to != null && to.getCellType() != CellType.WATER) {
            from.getEntities().remove(entity);
            to.getEntities().add(entity);
            entity.setPosition(to);
            return true;
        }
        return false;
    }
}

