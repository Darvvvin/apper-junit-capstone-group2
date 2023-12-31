import java.util.Date;
import java.util.UUID;

public class Ticket {
    private String id;
    private double price;
    private String schedule;

    public Ticket(double price, String schedule) {
        this.id = UUID.randomUUID().toString();
        this.price = price;
        this.schedule = schedule;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getSchedule() {
        return schedule;
    }
}
