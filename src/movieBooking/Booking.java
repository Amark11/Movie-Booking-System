package movieBooking;

public class Booking {
    public void confirmBooking(String movie, String showtime, double totalPrice) {
        System.out.println("Booking confirmed for " + movie + " at " + showtime + ". Total Price: ₹" + totalPrice);
        
        System.out.println("_________________________________________________________________________________________");
        System.out.println("\n                        Thank You For Visiting :)\n");
        System.out.println("_________________________________________________________________________________________");
    }
}
