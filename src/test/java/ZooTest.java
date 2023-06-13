import org.junit.jupiter.api.*;

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
    void registerVisitor() {
    }

    @Test
    void buyTicketVisitor() {
    }

    @Test
    void createTicket() {
    }

    @Test
    void getTransactionsByDate() {
    }
}
