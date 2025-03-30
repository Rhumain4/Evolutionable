package game.models;

import java.util.Date;

public class Save {
    private String saveName;
    private World world;
    private Date saveDate;

    public Save(String saveName, World world) {
        this.saveName = saveName;
        this.world = world;
        this.saveDate = new Date(System.currentTimeMillis());
    }
}
