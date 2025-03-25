package game.models;

public class Skills {
    private int intelligence;
    private int strength;
    private int dexterity;
    private int endurance;
    private int charisma;
    private int vision;

    // Constructeur
    public Skills(int intelligence, int strength, int dexterity, int endurance, int charisma, int vision) {
        this.intelligence = intelligence;
        this.strength = strength;
        this.dexterity = dexterity;
        this.endurance = endurance;
        this.charisma = charisma;
        this.vision = vision;
    }

    // Getters et Setters
    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getVision() {
        return vision;
    }

    public void setVision(int vision) {
        this.vision = vision;
    }
}
