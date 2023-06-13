import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Staff {
    private String id;
    private String name;
    private String role;
    private List<Animal> assignedAnimals;

    public Staff(String name, String role) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.role = role;
        this.assignedAnimals = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public String getRole() {
        return role;
    }

    public List<Animal> getAssignedAnimals() {
        return assignedAnimals;
    }

    public void assignAnimal(Animal animal) { //derick
        assignedAnimals.add(animal);
    }

}
