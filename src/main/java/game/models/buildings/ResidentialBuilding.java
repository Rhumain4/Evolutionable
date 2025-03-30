package game.models.buildings;

import game.models.Building;
import game.models.enums.BuildingType;

public class ResidentialBuilding extends Building {
    public ResidentialBuilding() {
        super("Maison", BuildingType.RESIDENTIAL, 3);
    }
}

