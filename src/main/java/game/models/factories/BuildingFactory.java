package game.models.factories;

import game.models.buildings.Building;
import game.models.buildings.ResidentialBuilding;
import game.models.buildings.SchoolBuilding;
import game.models.buildings.TempleBuilding;
import game.models.buildings.TownHallBuilding;
import game.models.enums.BuildingType;

public class BuildingFactory {
    public static Building createBuilding(BuildingType type) {
        if (type == null) {
            throw new IllegalArgumentException("Le type de bâtiment ne peut pas être nul.");
        }

        switch (type) {
            case RESIDENTIAL:
                return new ResidentialBuilding();
            case SCHOOL:
                return new SchoolBuilding();
            case TOWN_HALL:
                return new TownHallBuilding();
            case TEMPLE:
                return new TempleBuilding();
            default:
                throw new IllegalArgumentException("Type de bâtiment inconnu : " + type);
        }
    }
}