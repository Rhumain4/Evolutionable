package game.models.buildings;

import game.models.Cell;
import game.models.enums.BuildingType;

public class SchoolBuilding extends Building {
    public SchoolBuilding(Cell centerPosition) {
        super("École", BuildingType.SCHOOL, 2, centerPosition);
        centerPosition.setBuilding(this);
    }
}

