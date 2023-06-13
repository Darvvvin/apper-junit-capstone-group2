import java.util.List;

public class Staff {
    private String name;
    private String role;
    private List<Animal> assignedAnimals;

    public Staff(String name, String role, List<Animal> assignedAnimals) {
        this.name = name;
        this.role = role;
        this.assignedAnimals = assignedAnimals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Animal> getAssignedAnimals() {
        return assignedAnimals;
    }

    public void setAssignedAnimals(List<Animal> assignedAnimals) {
        this.assignedAnimals = assignedAnimals;
    }
}
