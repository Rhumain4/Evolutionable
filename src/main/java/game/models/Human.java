package game.models;

import game.models.enums.Diet;
import game.models.enums.Gender;

public class Human extends Entity {
    private Skills skills;
    private int morale;
    private Inventory inventory;
    private Family family;
    private Gender sexualPreference;

    public Human(String name, int age, int healthPoints, Skills skills, Needs needs, Cell position, int morale, int vision, Diet diet, Gender gender, Gender sexualPreference) {
        super(name, age, healthPoints, needs, position, vision, gender, diet);
        this.skills = skills;
        this.sexualPreference = sexualPreference;
        this.morale = morale;
        this.family = null;
        this.inventory = new Inventory(skills.getStrength() + skills.getEndurance());
    }

    // Getters-Setters

    public Gender getSexualPreference() {
        return sexualPreference;
    }

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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
}