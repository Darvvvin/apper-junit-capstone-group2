import java.util.UUID;
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

    public void addAnimal(Animal animal) throws AnimalIsNullException {
        if (Objects.isNull(animal)) {
            throw new AnimalIsNullException("Animal not found");
        } else {
            animals.add(animal);
        }
    }

    public void registerStaff(Staff staff) throws StaffIsNullException {
        if (Objects.isNull(staff)) {
            throw new StaffIsNullException("Staff not found");
        } else {
            this.staff.add(staff);
        }
    }

    // Visitor Methods
    public void registerVisitor(String visitorName) {
        String id = UUID.randomUUID().toString();
        visitors.add(new Visitor(id, visitorName));
    }

    public void buyTicketVisitor(double price, Date schedule, Visitor visitor, int numberOfTickets) {
        List<Ticket> customerTickets = new ArrayList<>();
        for(int i = 0; i < numberOfTickets; i++)
            customerTickets.add(createTicket(price, schedule));

        transactions.add(new Transaction(schedule, visitor, customerTickets));
    }

    public Ticket createTicket(double price, Date schedule) {
        return new Ticket(price, schedule);
    }

    public void assignAnimalToStaff(Animal animal, Staff staff) {

    }


    public List<Transaction> getTransactionsByDate(Date date) {
        return null;
    }
}
