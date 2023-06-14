import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Transaction {
    private String id;
    private String date;
    private Visitor customer;
    private List<Ticket> tickets;

    public Transaction(String date, Visitor customer, List tickets) {
        this.id = UUID.randomUUID().toString();
        this.date = date;
        this.customer = customer;
        this.tickets = tickets;
    }

    public int getNumberOfTickets() {
        return tickets.size();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
