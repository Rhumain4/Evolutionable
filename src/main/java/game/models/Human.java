package game.models;

public class Human extends Entity {
    private Skills skills;
    private Family family;

    public Human(String name, int age, int healthPoints, Skills skills, Needs needs, Family family) {
        super(name, age, healthPoints, needs);
        this.skills = skills;
        this.family = family;
    }

    // Getters-Setters
    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

}