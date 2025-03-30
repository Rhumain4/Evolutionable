package game.models.buildings;

import game.models.Building;
import game.models.enums.BuildingType;

public class SchoolBuilding extends Building {
    public SchoolBuilding() {
        super("École", BuildingType.SCHOOL, 5);
    }
}

