import java.util.UUID;

public class Visitor {
    private String id;
    private String name;

    public Visitor(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
