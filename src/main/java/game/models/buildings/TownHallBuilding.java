package game.models.buildings;

import game.models.Cell;
import game.models.enums.BuildingType;

public class TownHallBuilding extends Building {
    public TownHallBuilding(Cell centerPosition) {
        super("Town_Hall", BuildingType.TOWN_HALL, 2, centerPosition);
        centerPosition.setBuilding(this);
    }
}
