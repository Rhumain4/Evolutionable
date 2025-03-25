package game;

import game.models.Cell;
import game.models.World;
import game.services.TimeService;
import game.services.WorldGenerationService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Dimensions du monde
        int width = 100;
        int height = 100;
        long seed = 12345L; // Seed fixe pour résultats reproductibles

        // Service de génération du monde
        WorldGenerationService worldGenerationService = new WorldGenerationService(width, height, seed);

        // Génération des cellules du monde
        List<Cell> generatedCells = worldGenerationService.generateWorld();

        // Création des villages fictifs (ajoutez plus si nécessaire)
        TimeService timeService = new TimeService();
        World world = new World(List.of(), generatedCells, timeService);

        // Affichage en console d'une partie des résultats (par exemple, les 10 premières cellules)
        for (int i = 0; i < 100; i++) {
            Cell cell = generatedCells.get(i);
            System.out.println("Cell " + i + ": (" + cell.getX() + ", " + cell.getY() + ") - Biome: " + cell.getBiome());
        }

        System.out.println("Le monde a été généré avec succès !");
    }
}
