import java.util.Date;

public class Transaction {
    private Date date;
    private String userId;
    private int numOfTickets;

    public Transaction(Date date, String userId, int numOfTickets) {
        this.date = date;
        this.userId = userId;
        this.numOfTickets = numOfTickets;
    }
}
