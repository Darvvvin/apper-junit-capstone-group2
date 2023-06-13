import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Zoo {
    private List<Animal> animals;
    private List<Staff> staff;
    private List<Visitor> visitors;
    private List<Ticket> tickets;
    private List<Transaction> transactions;

    public Zoo(List<Animal> animals, List<Staff> staff, List<Visitor> visitors, List<Ticket> tickets, List<Transaction> transactions) {
        this.animals = animals;
        this.staff = staff;
        this.visitors = visitors;
        this.tickets = tickets;
        this.transactions = transactions;
    }

    public void addAnimal(Animal animal) throws AnimalNotFoundException {
        if (Objects.isNull(animal)) {
            throw new AnimalNotFoundException("Animal not found");
        } else {
            animals.add(animal);
        }
    }

    public void registerStaff(Staff staff) throws StaffNotFoundException {
        if (Objects.isNull(staff)) {
            throw new StaffNotFoundException("Staff not found");
        } else {
            this.staff.add(staff);
        }
    }

    public void registerVisitor(Visitor visitor) {

    }

    //derick
    public void assignAnimalToStaff(Animal animal, Staff staff) throws AnimalNotFoundException, StaffNotFoundException {
        // Check if the animal and staff exist
        if (!animals.contains(animal)) {
            throw new AnimalNotFoundException("Animal not found");
        }
        if (!staff.contains(staff)) {
            throw new StaffNotFoundException("Staff not found");
        }
        // Assign animal to staff
        staff.assignAnimal(animal);
    }

    public Ticket createTicket(double price, Date schedule, Visitor visitor) {
        return null;
    }

    public List<Transaction> getTransactionsByDate(Date date) {
        return null;
    }
}
