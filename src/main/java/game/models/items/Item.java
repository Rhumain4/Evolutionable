package game.models.items;

import game.models.Inventory;

public abstract class Item {
    private final String name;
    private final int weight;
    private Inventory inventory;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
        this.inventory = null;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
