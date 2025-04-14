package game.services;

import game.models.Cell;
import game.models.Human;
import game.models.items.Item;
import game.models.ressources.HarvestableResource;

public class ResourceHarvestService {

    public void doHarvest(Human human, Cell cell) {
        HarvestableResource resource = cell.getResource();
        int strength = human.getSkills().getStrength();
        Item item = resource.getItemProduced();

        if (human.getInventory().getWeight() + item.getWeight() <= human.getInventory().getMaxWeight()) {
            resource.setHarvestTime(resource.getHarvestTime() - strength);
            if (resource.getHarvestTime() <= 0) {
                human.getInventory().addItem(item);
                System.out.println("✅ " + resource.getName() + " a été récolté par " + human.getName());
                System.out.println("Inventaire de " + human.getName() + " : " + human.getInventory());
            }

            cell.setResource(null);
        } else {
            System.out.println("❌ Récolte échouée : inventaire plein pour " + human.getName());
        }


        System.out.println(human.getName() + " récolte " + resource.getName() + " (force: " + strength + ", resistance restant : " + resource.getHarvestTime() + ")");
    }
}