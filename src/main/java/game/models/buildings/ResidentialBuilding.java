package game.models.buildings;

import game.models.Building;
import game.models.enums.BuildingType;

public class ResidentialBuilding extends Building {
    public ResidentialBuilding() {
        super("House", BuildingType.RESIDENTIAL, 1);
    }
}

