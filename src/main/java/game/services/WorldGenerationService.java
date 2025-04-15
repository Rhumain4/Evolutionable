package game.services;

import game.models.*;
import game.models.enums.Biome;
import game.models.enums.CellType;
import game.models.enums.Gender;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldGenerationService {
    private final World world;
    private final int width;
    private final int height;
    private final Random random;

    public WorldGenerationService(int width, int height, long seed, World world) {
        this.width = width;
        this.height = height;
        this.world = world;
        this.random = new Random(seed);
    }

    /**
     * Génère une liste de cellules représentant un monde en respectant les conditions des biomes, avec une disposition plus naturelle.
     */
    public void generateWorld() {
        List<Cell> cells = new ArrayList<>();

        // Grille de bruit pour assigner les biomes
        double[][] noiseGrid = generateNoiseMap(width, height);

        // Liste de tous les biomes disponibles
        Biome[] biomes = Biome.values();

        // Associer chaque cellule à un biome basé sur le bruit
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double value = noiseGrid[x][y]; // Récupérer la valeur de bruit pour cette cellule
                Biome biome = mapValueToBiome(value, biomes); // Mapper la valeur à un biome
                cells.add(new Cell(x, y, biome, CellType.EMPTY));
            }
        }

        world.setCells(cells);
        addCentralVillage(cells, world);
    }

    /**
     * Génère une carte de bruit (noise map) pour lisser les transitions entre biomes.
     *
     * @param width  Largeur de la carte.
     * @param height Hauteur de la carte.
     * @return Carte de bruit (tableau 2D).
     */
    private double[][] generateNoiseMap(int width, int height) {
        double[][] noiseGrid = new double[width][height];
        double persistence = 0.5; // Contrôle l'influence des couches de bruit

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // Générer un bruit pseudo-aléatoire basé sur les coordonnées
                double noise = random.nextDouble();
                noise += persistence * smoothNoise(); // Ajouter un effet lissé
                noiseGrid[x][y] = noise;
            }
        }

        return noiseGrid;
    }

    /**
     * Applique une fonction pour lisser les valeurs aléatoires selon les coordonnées.
     *
     * @return Valeur lissée.
     */
    private double smoothNoise() {
        // Exemple : Combine les valeurs voisines pour créer un effet "lissé"
        double corners = (random.nextDouble() + random.nextDouble()) / 8.0;
        double sides = (random.nextDouble() + random.nextDouble()) / 4.0;
        double center = random.nextDouble() / 2.0;
        return corners + sides + center;
    }

    /**
     * Mappe une valeur de bruit (0.0 à 1.0) à un biome disponible.
     *
     * @param value  Valeur de bruit à mapper.
     * @param biomes Liste des biomes disponibles.
     * @return Biome correspondant à la valeur donnée.
     */
    private Biome mapValueToBiome(double value, Biome[] biomes) {
        // Mappe la valeur continue à un intervalle des biomes
        int index = (int) (value * biomes.length);
        index = Math.min(index, biomes.length - 1); // Éviter les dépassements d'index
        return biomes[index];
    }

    private void addCentralVillage(List<Cell> cells, World world) {
        int centerX = width / 2;
        int centerY = height / 2;
        Cell centerCell = cells.stream()
                .filter(c -> c.getX() == centerX && c.getY() == centerY)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Map center cell not found"));

        Skills skills = new Skills(10, 10, 10, 10, 10, 10);
        Human testHumain = new Human("Rhumain", 25, 20, skills, new Needs(), centerCell, 100, 10, Gender.MALE, Gender.FEMALE);
        Family family = new Family(new ArrayList<>(List.of(testHumain)), "CAMACH", null);

        WorldService worldService = new WorldService();

        try {
            worldService.buildVillage(world, centerCell, "Town", List.of(family));
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur lors de la construction du village central : " + e.getMessage());
        }
    }

}