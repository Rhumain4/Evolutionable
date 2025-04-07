package game.models;

import game.services.EntityMovementService;
import game.services.TimeService;
import game.services.WorldGenerationService;
import game.utils.WorldDisplayer;

import java.util.ArrayList;
import java.util.List;

public class World implements TimeService.TimeChangeListener {
    private final TimeService timeService;
    private List<Village> villages;
    private List<Cell> cells;
    private String worldName;
    private int width;
    private int height;

    public World(String worldName, int width, int height, long seed) {
        this.villages = new ArrayList<>();
        this.worldName = worldName;
        this.width = width;
        this.height = height;

        // World generation
        WorldGenerationService generationService = new WorldGenerationService(width, height, seed, this);
        generationService.generateWorld();

        // TimeService
        this.timeService = new TimeService();

        // Listener de mouvement (en premier)
        EntityMovementService movementService = new EntityMovementService(this);
        this.timeService.addTimeChangeListener(movementService);

        // Listener principal d'affichage du monde (en second)
        this.timeService.addTimeChangeListener(this);
    }

    @Override
    public void onTimeChange(int currentDay, int currentHour, int currentMinute) {
        clearConsole();

        String formattedTime = String.format("%02d:%02d", currentHour, currentMinute);
        System.out.println("Jour : " + currentDay + ", " + formattedTime);
        System.out.println("État actuel du monde :");

        WorldDisplayer.displayGrid(cells, width, height);
    }

    private void clearConsole() {
        try {
            if (System.getProperty("os.name").startsWith("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Erreur lors du nettoyage de la console");
        }
    }

    public Cell getCellAt(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) return null;
        return cells.stream()
                .filter(cell -> cell.getX() == x && cell.getY() == y)
                .findFirst()
                .orElse(null);
    }

    public TimeService getTimeService() {
        return timeService;
    }

    public List<Village> getVillages() {
        return villages;
    }

    public void setVillages(List<Village> villages) {
        this.villages = villages;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }
}
