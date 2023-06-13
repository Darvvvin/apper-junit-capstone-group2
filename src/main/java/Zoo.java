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


    public List<Transaction> getTransactionsByDate(Date date) {
        List<Transaction> filteredTransactions = new ArrayList<>();
        for(int i = 0; i < transactions.size(); i++){
            if(transactions.get(i).getDate() == date) {
                filteredTransactions.add(transactions.get(i));
            }
        }
        return filteredTransactions;
    }
}
