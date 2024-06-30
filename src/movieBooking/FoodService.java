package movieBooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodService {
    private List<FoodOrder> menu = new ArrayList<>();

    public FoodService() {
    	
        menu.add(new FoodOrder("POPCORN", 50.0));
        menu.add(new FoodOrder("WADAPAV", 15.0));
        menu.add(new FoodOrder("COLD DRINK", 30.0));
        menu.add(new FoodOrder("ICE CREAM", 35.0));
        menu.add(new FoodOrder("BURGER", 65.0));
        
    }

    public void displayMenu() {
        for (FoodOrder item : menu) {
            System.out.println("Item: " + item.getName() + ", Price: ₹" + item.getPrice());
        }
    }

    public double orderFood() {
        try (Scanner scanner = new Scanner(System.in)) {
            double totalPrice = 0.0;
            boolean ordering = true;

            while (ordering) {
                System.out.println("Enter food item name or 'done' to finish:");
                String itemName = scanner.nextLine();

                if (itemName.equalsIgnoreCase("done")) {
                    ordering = false;
                    break;
                }

                FoodOrder item = menu.stream().filter(i -> i.getName().equalsIgnoreCase(itemName)).findFirst().orElse(null);
                if (item == null) {
                    System.out.println("Item not found.");
                    continue;
                }

                System.out.println("Enter quantity for " + item.getName() + ":");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                totalPrice += item.getPrice() * quantity;
            }

            return totalPrice;
        }
    }
}
