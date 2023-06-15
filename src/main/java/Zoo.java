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

    public Zoo() {
        this.animals = new ArrayList<>();
        this.staff = new ArrayList<>();
        this.visitors = new ArrayList<>();
        this.tickets = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    // Animal
    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public Animal getAnimal(String name) throws AnimalNotFoundException {
        for (Animal animal: animals) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        throw new AnimalNotFoundException(name + " is missing");
    }

    public int getNumberOfAnimals() {
        return animals.size();
    }
    // Animal

    // Staff
    public String registerStaff(Staff staff){
        this.staff.add(staff);
        return staff.getId();
    }

    public Staff getStaff(String id) throws StaffNotFoundException {
        for (Staff staff: staff) {
            if (staff.getId().equals(id)) {
                return staff;
            }
        }
        throw new StaffNotFoundException("Employee " + id + " is missing from employee directory");
    }

    public int getNumberOfStaff() {
        return staff.size();
    }

    public void assignAnimalToStaff(Animal animal, Staff staff) throws AnimalNotFoundException, StaffNotFoundException, AnimalAlreadyAssignedException {
        if (!Objects.isNull(getAnimal(animal.getName())) && !Objects.isNull(getStaff(staff.getId()))) {
            Staff employee = this.staff.get(this.staff.indexOf(staff));
            if (employee.getAssignedAnimals().contains(animal))
                throw new AnimalAlreadyAssignedException(animal.getName() + "is already assigned to " + staff.getName());
            employee.assignAnimal(animal);
        }
    }

    public Animal retrieveAnimalFromStaff(String animalName, Staff staff) throws NoAnimalsAssignedException, AnimalNotFoundException {
        boolean isAnimalAssigned = staff.getAssignedAnimals().stream()
                .anyMatch(animal -> animal.getName().equals(animalName));

        if (isAnimalAssigned) {
            return staff.getAssignedAnimals().stream()
                    .filter(animal -> animal.getName().equals(animalName))
                    .findFirst()
                    .orElseThrow(() -> new AnimalNotFoundException(animalName + " is missing"));
        } else {
            throw new NoAnimalsAssignedException(animalName + " is not assigned");
        }
    }
    // Staff

    // Visitors
    public void registerVisitor(Visitor visitor) {
        visitors.add(visitor);
    }

    public int getNumberOfVisitors() {
        return visitors.size();
    }

    public Visitor getVisitor(String name) throws VisitorNotFoundException {
        for (Visitor visitor: visitors) {
            if (visitor.getName().equals(name)) {
                return visitor;
            }
        }
        throw new VisitorNotFoundException (name + " was not found in the visitor list.");
    }

    public Transaction buyTicketVisitor(double price, String schedule, Visitor visitor, int numberOfTickets) {
        List<Ticket> customerTickets = new ArrayList<>();
        for(int i = 0; i < numberOfTickets; i++)
            customerTickets.add(createTicket(price, schedule));

        Transaction newTransaction = new Transaction(schedule, visitor, customerTickets);
        transactions.add(newTransaction);
        return newTransaction;
    }
    // Visitors

    // Tickets & Transactions
    public Ticket createTicket(double price, String schedule) {
        return new Ticket(price, schedule);
    }

    public int retrieveTicketsFromTransaction (Transaction transaction) throws TransactionNotFoundException{
        if (!transactions.contains(transaction)) {
            throw new TransactionNotFoundException("Transaction is missing");
        } else {
            return transaction.getNumberOfTickets();
        }
    }

    public int getNumberOfTransactions() {
        return transactions.size();
    }

    public List<Transaction> getTransactionsByDate(String date) {
        List<Transaction> filteredTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getDate().equals(date)) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    public Transaction getTransactionFromDate(String id, List<Transaction> transactions) throws TransactionNotFoundException {
        for (Transaction transaction: transactions) {
            if (transaction.getId().equals(id)) {
                return transaction;
            }
        }
        throw new TransactionNotFoundException("Transaction is not found");
    }
    // Tickets & Transactions
}
