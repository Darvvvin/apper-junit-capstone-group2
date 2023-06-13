public class Animal {
    private String name;
    private String type;
    private String food;

    Animal(String name, String type, String food) {
        this.name = name;
        this.type = type;
        this.food = food;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getFood() {
        return food;
    }
}
