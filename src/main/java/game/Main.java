package game;

import game.models.Cell;
import game.models.enums.CellType;
import game.services.WorldGenerationService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Dimensions du monde
        int width = 50; // Taille de la grille
        int height = 50;
        long seed = 12345L; // Seed fixe pour des résultats reproductibles

        // Service de génération du monde
        WorldGenerationService worldGenerationService = new WorldGenerationService(width, height, seed);

        // Génération des cellules du monde
        List<Cell> generatedCells = worldGenerationService.generateWorld();

        // Afficher la grille avec les biomes et les villages
        displayGrid(generatedCells, width, height);
    }

    /**
     * Affiche une grille en console. Si une cellule contient un village, affiche "maison".
     *
     * @param cells  Liste des cellules générées.
     * @param width  Largeur de la grille.
     * @param height Hauteur de la grille.
     */
    public static void displayGrid(List<Cell> cells, int width, int height) {
        // Initialisation d'une grille avec les représentations des cellules
        String[][] grid = new String[width][height];

        // Remplir la grille avec la représentation des cellules en fonction du village ou du biome
        for (Cell cell : cells) {
            grid[cell.getX()][cell.getY()] = getCellRepresentation(cell);
        }

        // Afficher la grille en console
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(grid[x][y] + " ");
            }
            System.out.println(); // Saut de ligne après chaque rangée
        }
    }

    /**
     * Retourne l'emoji correspondant à la cellule. Si un village est présent, affiche "maison".
     *
     * @param cell La cellule dont on doit dériver la représentation.
     * @return String Emoji ou texte représentant la cellule.
     */
    private static String getCellRepresentation(Cell cell) {
        // Si la cellule contient un village, retourne "maison".
        if (cell.getVillage() != null) {
            return "\uD83C\uDFC1";
        }

        if (cell.getCellType() == CellType.BUILDING) {
            return "🏠";
        }

        // Sinon, mapper le biome à un emoji
        return switch (cell.getBiome()) {
            case PLAINS -> "🌾";  // Plaine
            case DESERT -> "🏜️"; // Désert
            case FOREST -> "🌲";  // Forêt
            case MOUNTAIN -> "⛰️"; // Montagne
            case SWAMP -> "🪵";  // Marais
            default -> "❓";      // Biome inconnu
        };
    }
}