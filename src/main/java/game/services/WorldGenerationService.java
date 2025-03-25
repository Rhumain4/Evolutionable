package game.services;

import game.models.Cell;
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
     * Génère une liste de cellules représentant un monde en respectant les conditions des biomes.
     *
     * @return Liste des cellules générées.
     */
    public List<Cell> generateWorld() {
        List<Cell> cells = new ArrayList<>();
        Biome[][] biomeGrid = new Biome[width][height];

        // Liste de tous les biomes disponibles
        Biome[] biomes = Biome.values();

        // Génération des clusters de biomes
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (biomeGrid[x][y] == null) {
                    Biome chosenBiome = biomes[random.nextInt(biomes.length)];
                    generateBiomeCluster(biomeGrid, x, y, chosenBiome, 10); // Crée un cluster de 10+ cellules
                }
            }
        }

        // Convertir la grille de biomes en liste de cellules
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells.add(new Cell(x, y, biomeGrid[x][y], CellType.EMPTY));
            }
        }

        return cells;
    }

    /**
     * Génère un cluster de biomes connectés en utilisant un algorithme simple (DFS/Flood Fill).
     *
     * @param biomeGrid Grille de biomes.
     * @param startX    Coordonnée X de départ.
     * @param startY    Coordonnée Y de départ.
     * @param biome     Biome choisi pour le cluster.
     * @param minSize   Taille minimale du cluster.
     */
    private void generateBiomeCluster(Biome[][] biomeGrid, int startX, int startY, Biome biome, int minSize) {
        List<int[]> stack = new ArrayList<>();
        stack.add(new int[]{startX, startY});

        int clusterSize = 0;

        while (!stack.isEmpty() && clusterSize < minSize) {
            int[] cell = stack.remove(stack.size() - 1);
            int x = cell[0];
            int y = cell[1];

            // Vérifie si la cellule est dans les limites et non visitée
            if (x >= 0 && x < width && y >= 0 && y < height && biomeGrid[x][y] == null) {
                biomeGrid[x][y] = biome; // Assigne le biome à la cellule
                clusterSize++;

                // Ajoute les voisins à la pile pour continuer la propagation
                stack.add(new int[]{x + 1, y});
                stack.add(new int[]{x - 1, y});
                stack.add(new int[]{x, y + 1});
                stack.add(new int[]{x, y - 1});
            }
        }
    }
}