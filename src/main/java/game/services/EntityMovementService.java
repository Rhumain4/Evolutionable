package game.services;

import game.models.*;
import game.models.enums.CellType;

import java.util.*;

public class EntityMovementService implements TimeService.TimeChangeListener {
    private final World world;
    private final TimeService timeService;
    private final Random random = new Random();
    private final ResourceHarvestService resourceHarvestService;

    public EntityMovementService(World world, TimeService timeService, ResourceHarvestService harvestService) {
        this.world = world;
        this.timeService = timeService;
        this.resourceHarvestService = harvestService;
    }

    @Override
    public void onTimeChange(int currentDay, int currentHour, int currentMinute) {
        Set<Human> movedHumans = new HashSet<>();
        boolean isNight = timeService.isNightTime();

        for (Cell cell : world.getCells()) {
            List<Entity> entitiesToAction = new ArrayList<>(cell.getEntities());

            for (Entity entity : entitiesToAction) {
                if (entity instanceof Human human && !movedHumans.contains(human)) {
                    if (isNight) {
                        moveHumanHome(human, cell);
                    } else if (random.nextDouble() < 0.33) {
                        moveEntityRandomly(human, cell);
                    }

                    // Tentative de récolte une fois sur deux
                    if (cell.getResource() != null && random.nextBoolean()) {
                        for (Entity ent : cell.getEntities()) {
                            if (ent instanceof Human) {
                                resourceHarvestService.doHarvest(human, cell);
                                cell.setResource(null);
                            }
                        }
                    }

                    movedHumans.add(human);
                } else if (!(entity instanceof Human) && random.nextDouble() < 0.33) {
                    moveEntityRandomly(entity, cell);
                }

                entity.updateNeeds(currentHour);

            }
        }
    }


    private void moveHumanHome(Human human, Cell currentCell) {
        Cell homeCell = human.getFamily().getResidentialBuilding().getCenterPosition();

        if (homeCell == null || currentCell == homeCell) {
            return; // Déjà à la maison ou maison inconnue
        }

        int currentX = currentCell.getX();
        int currentY = currentCell.getY();
        int targetX = homeCell.getX();
        int targetY = homeCell.getY();

        int dx = Integer.compare(targetX, currentX);
        int dy = Integer.compare(targetY, currentY);

        // Essaye d'abord diagonale
        if (tryMoveTo(human, currentCell, currentX + dx, currentY + dy)) return;

        // Sinon horizontal seulement
        if (dx != 0 && tryMoveTo(human, currentCell, currentX + dx, currentY)) return;

        // Sinon vertical seulement
        if (dy != 0) {
            tryMoveTo(human, currentCell, currentX, currentY + dy);
        }
    }

    private boolean tryMoveTo(Human human, Cell currentCell, int x, int y) {
        Cell nextCell = world.getCellAt(x, y);
        if (nextCell != null && nextCell.getCellType() != CellType.WATER) {
            currentCell.getEntities().remove(human);
            nextCell.getEntities().add(human);
            human.setPosition(nextCell);
            return true;
        }
        return false;
    }


    private void moveEntityRandomly(Entity entity, Cell currentCell) {
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
}
