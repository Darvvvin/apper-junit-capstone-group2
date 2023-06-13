import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Transaction {
    private String id;
    private Date date;
    private Visitor customer;
    private List<Ticket> tickets;

    public Transaction(Date date, Visitor customer, List tickets) {
        this.id = UUID.randomUUID().toString();
        this.date = date;
        this.customer = customer;
        this.tickets = tickets;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Visitor getCustomer() {
        return customer;
    }

    public void setCustomer(Visitor customer) {
        this.customer = customer;
    }
}
