package movieBooking;

import java.util.List;

public class Movie {
    private String title;
    private String genre;
    private List<String> showtimes;
    private double ticketPrice;

    public Movie(String title, String genre, List<String> showtimes, double ticketPrice) {
        this.title = title;
        this.genre = genre;
        this.showtimes = showtimes;
        this.ticketPrice = ticketPrice;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public List<String> getShowtimes() { return showtimes; }
    public double getTicketPrice() { return ticketPrice; }
}
