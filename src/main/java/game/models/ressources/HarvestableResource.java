package game.models.ressources;

import game.models.items.Item;

public abstract class HarvestableResource {
    private final String name;
    private final Item itemProduced;
    private int harvestTime;

    protected HarvestableResource(String name, int harvestTime, Item itemProduced) {
        this.name = name;
        this.harvestTime = harvestTime;
        this.itemProduced = itemProduced;
    }

    public String getName() {
        return name;
    }

    public int getHarvestTime() {
        return harvestTime;
    }

    public void setHarvestTime(int harvestTime) {
        this.harvestTime = harvestTime;
    }

    public Item getItemProduced() {
        return itemProduced;
    }
}