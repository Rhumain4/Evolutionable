package game.models.buildings;

import game.models.Building;
import game.models.enums.BuildingType;

public class TempleBuilding extends Building {
    public TempleBuilding() {
        super("Temple", BuildingType.TEMPLE, 6);
    }
}

