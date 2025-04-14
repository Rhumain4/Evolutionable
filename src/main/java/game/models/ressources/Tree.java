package game.models.ressources;

import game.models.items.Log;

public class Tree extends HarvestableResource {
    public Tree() {
        super("Tree", 5, new Log());
    }
}