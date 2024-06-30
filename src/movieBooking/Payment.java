package movieBooking;

public class Payment {
    public boolean processPayment(double amount) {
        // Randomly simulate success or failure
        if (Math.random() > 0.1) {
            System.out.println("Processing payment of ₹" + amount);
            return true; // Assume payment is successful
        } else {
            System.out.println("Payment failed. Please try again.");
            return false; // Payment failed
        }
    }
}
