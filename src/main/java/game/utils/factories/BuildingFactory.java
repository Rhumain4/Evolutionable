package game.utils.factories;

import game.models.Cell;
import game.models.buildings.Building;
import game.models.buildings.ResidentialBuilding;
import game.models.buildings.SchoolBuilding;
import game.models.buildings.TempleBuilding;
import game.models.buildings.TownHallBuilding;
import game.models.enums.BuildingType;

public class BuildingFactory {

    private BuildingFactory() {
        throw new IllegalStateException("Utility class");
    }

    public static Building createBuilding(BuildingType type, Cell centerPosition) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null.");
        }

        return switch (type) {
            case RESIDENTIAL -> new ResidentialBuilding(centerPosition);
            case SCHOOL -> new SchoolBuilding(centerPosition);
            case TOWN_HALL -> new TownHallBuilding(centerPosition);
            case TEMPLE -> new TempleBuilding(centerPosition);
            default -> throw new IllegalArgumentException("Type unknown : " + type);
        };
    }
}