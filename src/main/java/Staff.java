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
}
