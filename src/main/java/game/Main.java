package game;

import game.models.World;

public class Main {
    public static void main(String[] args) {
        // Dimensions du monde
        int width = 20;
        int height = 20;
        long seed = 12344L; // Seed fixe pour des résultats reproductibles

        // Service de génération du monde
        new World("test", width, height, seed);
    }
}