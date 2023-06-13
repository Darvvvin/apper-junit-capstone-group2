import java.util.UUID;
import java.util.Date;
import java.util.List;

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

    public void registerAnimal(Animal animal) {

    }

    public void registerStaff(Staff staff) {

    }

    // Visitor Methods
    public void registerVisitor(String visitorName) {
        String id = UUID.randomUUID().toString();
        visitors.add(new Visitor(id, visitorName));
    }

    public void buyTicketVisitor(double price, Date schedule, Visitor visitor, int numberOfTickets) {
        transactions.add(new Transaction(schedule, visitor.getId(), numberOfTickets));

        for(int i = 0; i < numberOfTickets; i++)
            tickets.add(createTicket(price, schedule, visitor));
    }

    public Ticket createTicket(double price, Date schedule, Visitor visitor) {
        return new Ticket(price, schedule, visitor);
    }

    public void assignAnimalToStaff(Animal animal, Staff staff) {

    }


    public List<Transaction> getTransactionsByDate(Date date) {
        return null;
    }
}
