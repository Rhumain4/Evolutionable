package game.models;

public class Human extends Entity {
    private Skills skills;

    public Human(String name, int age, int healthPoints, Skills skills, Needs needs) {
        super(name, age, healthPoints, needs);
        this.skills = skills;
    }

    // Getters-Setters
    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

}