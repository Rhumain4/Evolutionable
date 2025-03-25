package game.models;

import game.services.TimeService;

import java.util.List;

public class World implements TimeService.TimeChangeListener {
    private final TimeService timeService;
    private List<Village> villages;
    private List<Cell> cells;

    public World(List<Village> villages, List<Cell> cells, TimeService timeService) {
        this.villages = villages;
        this.cells = cells;
        this.timeService = timeService;

        // Le monde s'abonne aux changements de temps
        this.timeService.addTimeChangeListener(this);
    }

    /**
     * Méthode appelée par le TimeService à chaque changement de temps.
     */
    @Override
    public void onTimeChange(int currentDay, int currentHour, int currentMinute) {
        // Formatage des heures et minutes en HH:mm
        String formattedTime = String.format("%02d:%02d", currentHour, currentMinute);
        System.out.println("Jour : " + currentDay + ", " + formattedTime);
    }


}