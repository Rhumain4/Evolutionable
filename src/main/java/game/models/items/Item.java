package game.models.items;

import game.models.Inventory;

public abstract class Item {
    private final String name;
    private final double weight;
    private Inventory inventory;

    protected Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
        this.inventory = null;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
