import java.util.Date;
import java.util.UUID;

public class Ticket {
    private String id;
    private double price;
    private Date schedule;

    public Ticket(double price, Date schedule) {
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

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getSchedule() {
        return schedule;
    }

    public void setSchedule(Date schedule) {
        this.schedule = schedule;
    }
}
