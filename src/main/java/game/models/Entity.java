package game.models;

import game.models.enums.Diet;
import game.models.enums.Gender;

import java.util.List;

public class Entity {
    protected String name;
    protected int age;
    protected int healthPoints;
    protected Needs needs;
    protected Cell position;
    protected int vision;
    protected Gender gender;
    protected Diet diet;
    protected List<Task> task;

    // Constructor
    public Entity(String name, int age, int healthPoints, Needs needs, Cell position, int vision, Gender gender) {
        this.name = name;
        this.age = age;
        this.healthPoints = healthPoints;
        this.needs = needs;
        this.position = position;
        this.vision = vision;
        this.gender = gender;
        position.getEntities().add(this);
    }

    public void updateNeeds(int currentHour) {
        // Exemple simple : décrément progressif
        this.needs.decreaseHunger(1);
        this.needs.decreaseThirst(2);
        this.needs.decreaseRest(1);

        // Simulation du besoin de sommeil la nuit
        if (currentHour >= 22 || currentHour <= 6) {
            this.needs.decreaseSleep(2);
        } else {
            this.needs.decreaseSleep(1);
        }
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVision() {
        return vision;
    }

    public void setVision(int vision) {
        this.vision = vision;
    }

    public Gender getSexe() {
        return gender;
    }

    public void setSexe(Gender gender) {
        this.gender = gender;
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
