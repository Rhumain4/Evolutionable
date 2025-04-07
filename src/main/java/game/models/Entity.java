package game.models;

public class Entity {
    protected String name;
    protected int age;
    protected int healthPoints;
    protected Needs needs;
    protected Cell position;

    // Constructor
    public Entity(String name, int age, int healthPoints, Needs needs, Cell position) {
        this.name = name;
        this.age = age;
        this.healthPoints = healthPoints;
        this.needs = needs;
        this.position = position;
        position.getEntities().add(this);
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

    public Cell getPosition() {
        return position;
    }

    public void setPosition(Cell position) {
        this.position = position;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}
