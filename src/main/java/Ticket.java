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

    public Visitor getCustomer() {
        return customer;
    }

    public void setCustomer(Visitor customer) {
        this.customer = customer;
    }
}
