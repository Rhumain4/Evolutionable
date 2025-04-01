package game.services;

import game.models.*;
import game.models.enums.Biome;
import game.models.enums.CellType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldGenerationService {
    private final int width;
    private final int height;
    private final long seed;
    private final Random random;

    public WorldGenerationService(int width, int height, long seed) {
        this.width = width;
        this.height = height;
        this.seed = seed;
        this.random = new Random(seed); // Générateur pseudo-aléatoire basé sur la seed
    }

    /**
     * Ajoute un village au centre de la carte (de taille 4x4).
     */
    Skills skills = new Skills(10, 10, 10, 10, 10, 10);
    Needs needs = new Needs(10, 10, 10);
    Human testHumain = new Human("Rhumain", 25, 20, skills, needs, 100);
    Family family = new Family(new ArrayList<>(List.of(testHumain)), "CAMACH");
    Village village = new Village("Town", new ArrayList<>(List.of(family)));

    /**
     * Génère une liste de cellules représentant un monde en respectant les conditions des biomes, avec une disposition plus naturelle.
     *
     * @return Liste des cellules générées.
     */
    public List<Cell> generateWorld() {
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
        addCentralVillage(cells);
        return cells;
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
        double scale = 0.1; // Facteur d'échelle pour étaler les biomes
        double persistence = 0.5; // Contrôle l'influence des couches de bruit

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // Générer un bruit pseudo-aléatoire basé sur les coordonnées
                double noise = random.nextDouble();
                noise += persistence * smoothNoise(x * scale, y * scale); // Ajouter un effet lissé
                noiseGrid[x][y] = noise;
            }
        }

        return noiseGrid;
    }

    /**
     * Applique une fonction pour lisser les valeurs aléatoires selon les coordonnées.
     *
     * @param x Coordonnée X.
     * @param y Coordonnée Y.
     * @return Valeur lissée.
     */
    private double smoothNoise(double x, double y) {
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

    private void addCentralVillage(List<Cell> cells) {
        // Coordonnées du centre
        int centerX = width / 2;
        int centerY = height / 2;

        // Délimitations du village : 4x4 centré
        int villageSize = 4;
        int startX = centerX - villageSize / 2;
        int startY = centerY - villageSize / 2;

        for (Cell cell : cells) {
            if (cell.getX() >= startX && cell.getX() < startX + villageSize &&
                    cell.getY() >= startY && cell.getY() < startY + villageSize) {
                // Marquer ces cellules comme faisant partie du village
                cell.setVillage(village);
            }
        }
    }

}