package game.models;

import game.models.buildings.ResidentialBuilding;

import java.util.List;

public class Family {
    private List<Human> members;
    private String name;
    private ResidentialBuilding residentialBuilding;

    public Family(List<Human> members, String name, ResidentialBuilding residentialBuilding) {
        this.members = members;
        this.name = name;
        this.residentialBuilding = residentialBuilding;
        for (Human human : members) {
            human.setFamily(this);
        }
    }

    public ResidentialBuilding getResidentialBuilding() {
        return residentialBuilding;
    }

    public void setResidentialBuilding(ResidentialBuilding residentialBuilding) {
        residentialBuilding.setFamily(this);
        this.residentialBuilding = residentialBuilding;
    }

    public List<Human> getMembers() {
        return members;
    }

    public void setMembers(List<Human> members) {
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalMembers() {
        return (members != null) ? members.size() : 0;
    }

}
