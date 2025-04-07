package game.models;

public class Human extends Entity {
    private Skills skills;
    private int morale;
    private Inventory inventory;

    public Human(String name, int age, int healthPoints, Skills skills, Needs needs, Cell position, int morale) {
        super(name, age, healthPoints, needs, position);
        this.skills = skills;
        this.morale = morale;
        this.inventory = new Inventory(skills.getStrength() + skills.getEndurance());
    }

    // Getters-Setters
    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public int getMorale() {
        return morale;
    }

    public void setMorale(int morale) {
        this.morale = morale;
    }

}