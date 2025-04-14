package game;

import game.models.World;

public class Main {
    public static void main(String[] args) {
        // Dimensions du monde
        int width = 10;
        int height = 10;
        long seed = 12344L;

        // Service de génération du monde
        new World("test", width, height, seed);
    }
}