package movieBooking;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        UserRegister userService = new UserRegister();
        MovieService movieService = new MovieService();
        SeatRegister seatService = new SeatRegister();
        Payment paymentService = new Payment();
        Booking booking = new Booking();
        FoodService foodService = new FoodService();
        Scanner scanner = new Scanner(System.in);

        // User Registration
        System.out.println("\nRegister The Data :");
        System.out.println("--------------------------------------------\n");
        boolean registered = false;
        while (!registered) {
            System.out.println("Please Enter Your Name : ");
            String name = scanner.nextLine();
            System.out.println("Please Enter Your E-mail : ");
            String email = scanner.nextLine();
            System.out.println("Please Enter Your Password : ");
            String password = scanner.nextLine();

            registered = userService.registerUser(name, email, password);
            if (!registered) {
                System.out.println("Registration failed. Try again.");
            }
        }

        // User Login
        System.out.println("\nEnter the login details \n--------------------------------------------\n ");
        System.out.println("Enter email : ");
        String email = scanner.nextLine();
        System.out.println("Enter Password : ");
        String password = scanner.nextLine();
        if (!userService.loginUser(email, password)) {
            System.out.println("Login failed.");
            return;
        }

        // Display Movies
        System.out.println("\n ---------------------------------------------------------");
        System.out.println("|               WELCOME TO MOVIE BOOING PORTAL            |");
        System.out.println(" ---------------------------------------------------------\n");

        movieService.displayMovies();
        System.out.println("\nEnter the MOVIE NAME you want to book:");
        String movieTitle = scanner.nextLine();
        Movie movie = movieService.getMovieByTitle(movieTitle);
        if (movie == null) {
            System.out.println("Movie not found.");
            return;
        }

        // Showtimes
        System.out.println("Showtimes for " + movie.getTitle() + ": " + movie.getShowtimes());
        System.out.println("\nEnter the showtime you want:");
        String showtime = scanner.nextLine();

        // Seat Category Selection
        System.out.println("\nSelect a seating category (Balcony, Stalls, Dress Circle, Upper Circle, Boxes):");
        String category = scanner.nextLine();
        int seatPrice = seatService.getSeatPrice(category);
        if (seatPrice == 0) {
            System.out.println("Invalid category selected.");
            return;
        }

        // Number of Tickets
        System.out.println("\nEnter the number of tickets:");
        int numberOfTickets = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Seat Selection
        seatService.displaySeats();
        for (int i = 0; i < numberOfTickets; i++) {
            System.out.println("Select seat (row col) for ticket " + (i + 1) + ":");
            int row = scanner.nextInt() - 1;  // Adjusting for 0-based index
            int col = scanner.nextInt() - 1;  // Adjusting for 0-based index
            while (!seatService.selectSeats(row, col)) {
                System.out.println("Select another seat (row col):");
                row = scanner.nextInt() - 1;  // Adjusting for 0-based index
                col = scanner.nextInt() - 1;  // Adjusting for 0-based index
            }
        }

        // Order Food
        foodService.displayMenu();
        double foodPrice = foodService.orderFood();

        // Total Price Calculation
        double totalPrice = (movie.getTicketPrice() + seatPrice) * numberOfTickets + foodPrice;

        // Payment Process
        if (!paymentService.processPayment(totalPrice)) {
            System.out.println("Payment failed. Exiting...");
            return;
        }

        // Confirm Booking
        booking.confirmBooking(movie.getTitle(), showtime, totalPrice);

        scanner.close();
    }
}
