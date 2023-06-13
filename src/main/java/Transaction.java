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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getNumOfTickets() {
        return numOfTickets;
    }

    public void setNumOfTickets(int numOfTickets) {
        this.numOfTickets = numOfTickets;
    }
}
