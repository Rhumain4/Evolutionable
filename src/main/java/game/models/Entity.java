package game.models;

public class Entity {
    protected String name;
    protected int age;
    protected int healthPoints;
    protected Needs needs;

    // Constructor
    public Entity(String name, int age, int healthPoints, Needs needs) {
        this.name = name;
        this.age = age;
        this.healthPoints = healthPoints;
        this.needs = needs;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int gethealthPoints() {
        return healthPoints;
    }

    public void sethealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Needs getNeeds() {
        return needs;
    }

    public void setNeeds(Needs needs) {
        this.needs = needs;
    }
}
