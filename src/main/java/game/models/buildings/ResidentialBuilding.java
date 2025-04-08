package game.models.buildings;

import game.models.Cell;
import game.models.enums.BuildingType;

public class ResidentialBuilding extends Building {
    public ResidentialBuilding(Cell centerPosition) {
        super("House", BuildingType.RESIDENTIAL, 1, centerPosition);
        centerPosition.setBuilding(this);
    }

}

