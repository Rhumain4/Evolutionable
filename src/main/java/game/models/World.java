package game.models;

import game.services.TimeService;
import game.services.WorldGenerationService;

import java.util.ArrayList;
import java.util.List;

public class World implements TimeService.TimeChangeListener {
    private final TimeService timeService;
    private List<Village> villages;
    private List<Cell> cells;
    private String worldName;
    private int width;

    public World(String worldName, int width, int height, long seed) {
        this.villages = new ArrayList<>();
        this.worldName = worldName;
        this.width = width;

        // Creation and beginning of TimeService
        this.timeService = new TimeService();
        // Subscribe to time changes
        this.timeService.addTimeChangeListener(this);

        // World generation
        WorldGenerationService generationService = new WorldGenerationService(width, height, seed, this);
        generationService.generateWorld();
    }

    @Override
    public void onTimeChange(int currentDay, int currentHour, int currentMinute) {
        String formattedTime = String.format("%02d:%02d", currentHour, currentMinute);
        System.out.println("Jour : " + currentDay + ", " + formattedTime);
    }

    public Cell getCell(int x, int y) {
        int index = y * width + x;
        if (index >= 0 && index < cells.size()) {
            return cells.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid cell coordinates: (" + x + ", " + y + ")");
        }
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
