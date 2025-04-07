package game.models.buildings;

import game.models.Building;
import game.models.enums.BuildingType;

public class TownHallBuilding extends Building {
    public TownHallBuilding() {
        super("Town_Hall", BuildingType.TOWN_HALL, 2);
    }
}
