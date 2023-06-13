import java.util.Date;

public class Ticket {
    private double price;
    private Date schedule;

    public Ticket(double price, Date schedule) {
        this.price = price;
        this.schedule = schedule;
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
