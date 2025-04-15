package game.services;

import game.models.*;
import game.models.enums.CellType;

import java.util.*;

public class EntityActionService implements TimeService.TimeChangeListener {
    private final World world;
    private final TimeService timeService;
    private final ResourceHarvestService resourceHarvestService;
    private final EntityMovementService entityMovementService;
    private final Random random = new Random();

    public EntityActionService(World world, TimeService timeService,
                               ResourceHarvestService resourceHarvestService,
                               EntityMovementService entityMovementService) {
        this.world = world;
        this.timeService = timeService;
        this.resourceHarvestService = resourceHarvestService;
        this.entityMovementService = entityMovementService;
    }

    @Override
    public void onTimeChange(int currentDay, int currentHour, int currentMinute) {
        Set<Human> movedHumans = new HashSet<>();
        boolean isNight = timeService.isNightTime();

        for (Cell cell : world.getCells()) {
            List<Entity> entitiesToAction = new ArrayList<>(cell.getEntities());

            for (Entity entity : entitiesToAction) {
                if (entity instanceof Human human && !movedHumans.contains(human)) {

                    //resources
                    if (isNight) {
                        entityMovementService.moveHumanHome(human);
                    } else if (random.nextDouble() < 0.33) {
                        entityMovementService.moveRandomly(human);
                    }

                    // Harvest
                    if (cell.getResource() != null && random.nextBoolean()) {
                        resourceHarvestService.doHarvest(human, cell);
                        cell.setResource(null);
                    }

                    movedHumans.add(human);
                } else if (!(entity instanceof Human) && random.nextDouble() < 0.33) {
                    entityMovementService.moveRandomly(entity);
                }

                //update needs
                entity.updateNeeds(currentHour);
            }
        }
    }
}


