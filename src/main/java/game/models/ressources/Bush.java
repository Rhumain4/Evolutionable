package game.models.ressources;

import game.models.items.Twig;

public class Bush extends HarvestableResource {
    public Bush() {
        super("Bush", 2, new Twig());
    }
}
