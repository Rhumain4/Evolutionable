package game.models;

import java.util.List;

public class Family {
    private List<Human> members;
    private String name;

    public Family(List<Human> members, String name) {
        this.members = members;
        this.name = name;
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
