package movieBooking;

public class FoodOrder {
    private String name;
    private double price;

    public FoodOrder(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}
