package game.models.buildings;

import game.models.Building;
import game.models.enums.BuildingType;

public class TownHallBuilding extends Building {
    public TownHallBuilding() {
        super("Mairie", BuildingType.TOWN_HALL, 5);
    }
}
