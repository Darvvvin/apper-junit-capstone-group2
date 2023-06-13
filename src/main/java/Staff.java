import java.util.List;

public class Staff {
    private static String name;
    private String role;
    private List<Animal> assignedAnimals;

    public Staff(String name, String role, List<Animal> assignedAnimals) {
        this.name = name;
        this.role = role;
        this.assignedAnimals = assignedAnimals;
    }

    public static String getName() {
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

    public void assignAnimal(Animal animal) { //derick
        assignedAnimals.add(animal);
    }

    public boolean contains(Staff staff) { //derick
        return assignedAnimals.contains(staff);
    }
}
