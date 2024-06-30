package movieBooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MovieService {
    private List<Movie> movies = new ArrayList<>();
    private Random random = new Random();

    public MovieService() {
        movies.add(new Movie("Mulshi Pattern", "Action", generateRandomShowtimes(), 100 + random.nextInt(101)));
        movies.add(new Movie("Sairat", "RomCom-Drama", generateRandomShowtimes(), 100 + random.nextInt(101)));
        movies.add(new Movie("Raundal", "Action", generateRandomShowtimes(), 100 + random.nextInt(101)));
        movies.add(new Movie("Naal", "Drama", generateRandomShowtimes(), 100 + random.nextInt(101)));
        movies.add(new Movie("Kaakan", "Rom-Drama", generateRandomShowtimes(), 100 + random.nextInt(101)));
        movies.add(new Movie("Timepass", "Com-Drama", generateRandomShowtimes(), 100 + random.nextInt(101)));
        movies.add(new Movie("Manjummel Boys", "Thriller-Drama", generateRandomShowtimes(), 100 + random.nextInt(101)));
        movies.add(new Movie("Sita Ramam", "Romance-Drama", generateRandomShowtimes(), 100 + random.nextInt(101)));
    }

    private List<String> generateRandomShowtimes() {
        List<String> showtimes = new ArrayList<>();
        int numShowtimes = 3 + random.nextInt(3); // Between 3 and 5 showtimes
        for (int i = 0; i < numShowtimes; i++) {
            int hour = 10 + random.nextInt(12);
            String period = hour < 12 ? "AM" : "PM";
            if (hour > 12) hour -= 12;
            showtimes.add(String.format("%02d:00 %s", hour, period));
        }
        return showtimes;
    }

    
    public void displayMovies() {
        System.out.printf("\n%-20s%-20s%-40s%-10s%n", "TITLE", "GENRE", "SHOWTIMES", "PRICE");
        System.out.println("--------------------------------------------------------------------------------------------");
        for (Movie movie : movies) {
            System.out.printf("%-20s%-20s%-40s%-10s%n", movie.getTitle(), movie.getGenre(), String.join(", ", movie.getShowtimes()), "₹" + movie.getTicketPrice());
            System.out.println("--------------------------------------------------------------------------------------------\n");

        }
    }
    public Movie getMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }
}
