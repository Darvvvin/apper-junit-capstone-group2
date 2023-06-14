import org.junit.jupiter.api.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZooTest {
    private Zoo zoo;

    @BeforeEach
    void setup() {
        zoo = new Zoo();
    }

    @AfterEach
    void cleanup() {

    }

    @Test
    @DisplayName("Successful add and get of animal")
    void addAnimal(){
        Animal newAnimal = new Animal("Simba", "Lion", "Meat");
        zoo.addAnimal(newAnimal);

        Assertions.assertAll("Animal is created",
                () -> Assertions.assertEquals(1, zoo.getNumberOfAnimals()),
                () -> Assertions.assertEquals("Simba", zoo.getAnimal("Simba").getName()),
                () -> Assertions.assertEquals("Meat", zoo.getAnimal("Simba").getFood()),
                () -> Assertions.assertEquals("Lion", zoo.getAnimal("Simba").getType())
        );
    }

    @Test
    @DisplayName("Fail getting animal")
    void getAnimal_AnimalNotFound() {
        Animal newAnimal = new Animal("Simba", "Lion", "Meat");
        zoo.addAnimal(newAnimal);

        Assertions.assertThrows(AnimalNotFoundException.class,
                () -> zoo.getAnimal("Scar")
        );
    }

    @Test
    @DisplayName("Successful add and get of staff")
    void registerStaff() {
        Staff employee = new Staff("Mark", "Veterinarian");
        String staffId = zoo.registerStaff(employee);

        Assertions.assertAll("Animal is created",
                () -> Assertions.assertEquals(1, zoo.getNumberOfStaff()),
                () -> Assertions.assertEquals("Mark", zoo.getStaff(staffId).getName()),
                () -> Assertions.assertEquals("Veterinarian", zoo.getStaff(staffId).getRole())
        );
    }

    @Test
    @DisplayName("Fail getting animal")
    void getStaff_StaffNotFound() {
        Staff employee = new Staff("Mark", "Veterinarian");
        zoo.registerStaff(employee);

        Assertions.assertThrows(StaffNotFoundException.class,
                () -> zoo.getStaff("non-existing-id")
        );
    }

    @Test
    @DisplayName("Successful assigning animal to staff and retrieving animal")
    void assignAnimalToStaff() throws AnimalNotFoundException, StaffNotFoundException, AnimalAlreadyAssignedException, NoAnimalsAssignedException {
        Staff employee = new Staff("Mark", "Veterinarian");
        String staffId = zoo.registerStaff(employee);

        Animal newAnimal = new Animal("Simba", "Lion", "Meat");
        zoo.addAnimal(newAnimal);

        zoo.assignAnimalToStaff(newAnimal, zoo.getStaff(staffId));
        Assertions.assertEquals(newAnimal, zoo.retrieveAnimalFromStaff("Simba", zoo.getStaff(staffId)));
    }
    @Test
    @DisplayName("Fail getting Animal")
    void assignAnimalToStaff_AnimalNotFound() {
        Staff employee = new Staff("Mark", "Veterinarian");
        String staffId = zoo.registerStaff(employee);

        Animal newAnimal = new Animal("Simba", "Lion", "Meat");
        Animal notIncludedAnimal = new Animal("Scar", "Lion", "Meat");

        zoo.addAnimal(newAnimal);

        Assertions.assertThrows(NoAnimalsAssignedException.class, () -> zoo.retrieveAnimalFromStaff(notIncludedAnimal.getName(), zoo.getStaff(staffId)));
    }
    @Test
    @DisplayName("Fail getting Staff")
    void assignAnimalToStaff_StaffNotFound() {
        Staff employee = new Staff("Mark", "Veterinarian");
        zoo.registerStaff(employee);

        Animal newAnimal = new Animal("Simba", "Lion", "Meat");
        zoo.addAnimal(newAnimal);

        Assertions.assertThrows(StaffNotFoundException.class, () -> zoo.assignAnimalToStaff(newAnimal, zoo.getStaff("non-existing-staff")));
    }

    @Test
    @DisplayName("Animal is already assigned to Staff")
    void assignAnimalToStaff_AlreadyAssigned() throws StaffNotFoundException, AnimalNotFoundException, AnimalAlreadyAssignedException {
        Staff employee = new Staff("Mark", "Veterinarian");
        String staffId = zoo.registerStaff(employee);

        Animal newAnimal = new Animal("Simba", "Lion", "Meat");
        zoo.addAnimal(newAnimal);

        zoo.assignAnimalToStaff(newAnimal, zoo.getStaff(staffId));

        Assertions.assertThrows(AnimalAlreadyAssignedException.class, () -> zoo.assignAnimalToStaff(newAnimal, zoo.getStaff(staffId)));
    }

    @Test
    @DisplayName("Success registering and getting visitors")
    void registerVisitor() {
        Visitor visitor = new Visitor("Jacob");

        zoo.registerVisitor(visitor);

        Assertions.assertAll("Visitor is created",
                () -> Assertions.assertEquals(1, zoo.getNumberOfVisitors()),
                () -> Assertions.assertEquals("Jacob", zoo.getVisitor("Jacob").getName())
        );
    }
    @Test
    @DisplayName("Fail getting visitors")
    void getVisitor_VisitorNotFound() {
        Visitor visitor = new Visitor("Jacob");
        zoo.registerVisitor(visitor);

        Assertions.assertThrows(VisitorNotFoundException.class, () -> zoo.getVisitor("Mark"));
    }

    @Test
    @DisplayName("Successful buying of ticket")
    void buyTicketVisitor() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String schedule = new String(simpleDateFormat.format(date));
        double price = 100.0;
        int numTickets = 3;
        Visitor visitor = new Visitor("Mark");
        zoo.registerVisitor(visitor);

        Transaction transaction = zoo.buyTicketVisitor(price, schedule, visitor, numTickets);

        Assertions.assertAll("Successful buy ticket",
                () -> Assertions.assertEquals(1, zoo.getNumberOfTransactions()),
                () -> Assertions.assertEquals(numTickets, zoo.retrieveTicketsFromTransaction(transaction)),
                () -> Assertions.assertNotNull(transaction)
        );

    }
    @Test
    @DisplayName("Fail buying of ticket")
    void buyTicketVisitor_TransactionNotFound() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String schedule = new String(simpleDateFormat.format(date));
        double price = 100.0;
        int numTickets = 3;
        Visitor visitor = new Visitor("Mark");
        zoo.registerVisitor(visitor);
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(120.0, schedule));

        Transaction transaction = zoo.buyTicketVisitor(price, schedule, visitor, numTickets);
        Transaction missingTransaction = new Transaction(schedule, visitor, tickets);

        Assertions.assertThrows(TransactionNotFoundException.class, () -> zoo.retrieveTicketsFromTransaction(missingTransaction));
    }

    @Test
    void createTicket() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");

        double price = 100.0;

        Ticket newTicket = zoo.createTicket(price, dateFormat.format(date));

        Assertions.assertAll("Ticket is created",
                () -> Assertions.assertEquals(100.0, newTicket.getPrice()),
                () -> Assertions.assertEquals(dateFormat.format(date), newTicket.getSchedule()),
                () -> Assertions.assertNotNull(newTicket),
                () -> Assertions.assertNotNull(newTicket.getId()),
                () -> Assertions.assertFalse(newTicket.getId().isEmpty())
        );
    }

    @Test
    void getTransactionsByDate() {
    }
}
