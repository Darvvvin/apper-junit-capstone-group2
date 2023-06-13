import java.util.Date;

public class Ticket {
    private double price;
    private Date schedule;
    private Visitor customer;

    public Ticket(double price, Date schedule, Visitor customer) {
        this.price = price;
        this.schedule = schedule;
        this.customer = customer;
    }
}
