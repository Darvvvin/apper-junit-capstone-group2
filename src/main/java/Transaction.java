import java.util.Date;
import java.util.UUID;

public class Transaction {
    private String id;
    private Date date;
    private Visitor customer;
    private int numOfTickets;

    public Transaction(Date date, Visitor customer, int numOfTickets) {
        this.id = UUID.randomUUID().toString();
        this.date = date;
        this.customer = customer;
        this.numOfTickets = numOfTickets;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumOfTickets() {
        return numOfTickets;
    }

    public void setNumOfTickets(int numOfTickets) {
        this.numOfTickets = numOfTickets;
    }

    public Visitor getCustomer() {
        return customer;
    }

    public void setCustomer(Visitor customer) {
        this.customer = customer;
    }
}
