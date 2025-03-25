package game.models;

public class Needs {
    private int hunger;
    private int thirst;
    private int rest;

    // Constructor
    public Needs(int hunger, int thirst, int rest) {
        this.hunger = hunger;
        this.thirst = thirst;
        this.rest = rest;
    }

    // Getters and Setters
    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public int getRest() {
        return rest;
    }

    public void setRest(int rest) {
        this.rest = rest;
    }

    // Utility method to display current needs
    public void displayNeeds() {
        System.out.println("Needs:");
        System.out.println("Hunger: " + hunger);
        System.out.println("Thirst: " + thirst);
        System.out.println("Rest: " + rest);
    }
}

