package game.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class TimeService {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final List<TimeChangeListener> listeners = new ArrayList<>();
    private int currentDay = 0;       // Compteur pour les jours
    private int currentHour = 0;     // Compteur pour les heures (0-23)
    private int currentMinute = 0;   // Compteur pour les minutes (0-59)

    public TimeService() {
        start();
    }

    /**
     * Démarre la progression simulée du temps (1 seconde = 1 minute).
     */
    private void start() {
        scheduler.scheduleAtFixedRate(this::incrementMinute, 0, 1, TimeUnit.SECONDS);
    }

    /**
     * Arrête le service de gestion du temps.
     */
    public void stop() {
        scheduler.shutdown();
    }

    /**
     * Incrémente les minutes simulées et gère les transitions vers les heures et jours.
     */
    private void incrementMinute() {
        currentMinute++;
        if (currentMinute == 60) {
            currentMinute = 0;
            incrementHour();
        }

        notifyTimeChange(); // Notifie les changements de minute
    }

    /**
     * Incrémente les heures simulées et gère la transition vers les jours.
     */
    private void incrementHour() {
        currentHour++;
        if (currentHour == 24) {
            currentHour = 0;
            incrementDay();
        }
    }

    /**
     * Incrémente le compteur de jours simulés.
     */
    private void incrementDay() {
        currentDay++;
    }

    /**
     * Ajoute un listener pour réagir aux changements de temps.
     */
    public void addTimeChangeListener(TimeChangeListener listener) {
        listeners.add(listener);
    }

    /**
     * Supprime un listener.
     */
    public void removeTimeChangeListener(TimeChangeListener listener) {
        listeners.remove(listener);
    }

    /**
     * Notifie tous les listeners des changements de temps.
     */
    private void notifyTimeChange() {
        for (TimeChangeListener listener : listeners) {
            listener.onTimeChange(currentDay, currentHour, currentMinute);
        }
    }

    // Getters pour accéder au temps actuel
    public int getCurrentDay() {
        return currentDay;
    }

    public int getCurrentHour() {
        return currentHour;
    }

    public int getCurrentMinute() {
        return currentMinute;
    }

    /**
     * Interface pour les listeners réagissant aux changements de temps.
     */
    public interface TimeChangeListener {
        void onTimeChange(int currentDay, int currentHour, int currentMinute);
    }
}
