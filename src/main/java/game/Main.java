package game;

import game.models.World;

public class Main {
    public static void main(String[] args) {
        // Dimensions du monde
        int width = 50;
        int height = 50;
        long seed = 12344L;

        // Service de génération du monde
        new World("test", width, height, seed);
    }
}