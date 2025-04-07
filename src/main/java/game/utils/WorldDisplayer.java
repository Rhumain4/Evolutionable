package game.utils;

import game.models.Cell;
import game.models.enums.CellType;

import java.util.List;

public class WorldDisplayer {

    private WorldDisplayer() {
        throw new IllegalStateException("Utility class");
    }

    public static void displayGrid(List<Cell> cells, int width, int height) {
        String[][] grid = new String[width][height];

        for (Cell cell : cells) {
            grid[cell.getX()][cell.getY()] = getCellRepresentation(cell);
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                String value = grid[x][y];
                System.out.print((value != null ? value : "  ") + " ");
            }
            System.out.println();
        }
    }

    private static String getCellRepresentation(Cell cell) {
        if (!cell.getEntities().isEmpty()) {
            return "🧑";
        }

        if (cell.getCellType() == CellType.BUILDING) {
            return "🏠";
        }

        if (cell.getVillage() != null) {
            return "🏁";
        }

        return switch (cell.getBiome()) {
            case PLAINS -> "🌾";
            case DESERT -> "🏜️";
            case FOREST -> "🌲";
            case MOUNTAIN -> "⛰️";
            case SWAMP -> "🪵";
            default -> "❓";
        };
    }
}
