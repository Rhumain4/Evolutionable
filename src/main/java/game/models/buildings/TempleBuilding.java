package game.models.buildings;

import game.models.Cell;
import game.models.enums.BuildingType;

public class TempleBuilding extends Building {
    public TempleBuilding(Cell centerPosition) {
        super("Temple", BuildingType.TEMPLE, 3, centerPosition);
        centerPosition.setBuilding(this);
    }
}

