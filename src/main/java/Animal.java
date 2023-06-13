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

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
