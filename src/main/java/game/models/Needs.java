package game.models;

public class Needs {
    private int hunger;
    private int thirst;
    private int rest;
    private int sleep;

    // Constructor
    public Needs() {
        this.hunger = 100;
        this.thirst = 100;
        this.rest = 100;
        this.sleep = 100;
    }

    public void decreaseHunger(int amount) {
        hunger = Math.max(0, hunger - amount);
    }

    public void decreaseThirst(int amount) {
        thirst = Math.max(0, thirst - amount);
    }

    public void decreaseRest(int amount) {
        rest = Math.max(0, rest - amount);
    }

    public void decreaseSleep(int amount) {
        sleep = Math.max(0, sleep - amount);
    }


    // Getters and Setters
    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getSleep() {
        return sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
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

