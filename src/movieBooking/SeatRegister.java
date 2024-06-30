package movieBooking;

import java.util.HashMap;
import java.util.Map;

public class SeatRegister {
    private static final int ROWS = 5;
    private static final int COLS = 10;
    private char[][] seats = new char[ROWS][COLS];
    private Map<String, Integer> seatPrices = new HashMap<>();

    public SeatRegister() {
        initializeSeats();
        seatPrices.put("Balcony", 250);
        seatPrices.put("Stalls", 150);
        seatPrices.put("Dress Circle", 300);
        seatPrices.put("Upper Circle", 500);
        seatPrices.put("Boxes", 100);
    }

    private void initializeSeats() {
        for (int i = 0; i < ROWS; ++i) {
            for (int j = 0; j < COLS; ++j) {
                seats[i][j] = 'A'; // 'A' for Available
            }
        }
    }

    public void displaySeats() {
        for (int i = 0; i < ROWS; ++i) {
            for (int j = 0; j < COLS; ++j) {
                System.out.print((i + 1) + "-" + (j + 1) + ":" + seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean selectSeats(int row, int col) {
        if (row >= ROWS || col >= COLS || seats[row][col] != 'A') {
            System.out.println("Seat not available.");
            return false;
        }
        seats[row][col] = 'B'; // 'B' for Booked
        System.out.println("Seat booked successfully.");
        return true;
    }

    public int getSeatPrice(String category) {
        return seatPrices.getOrDefault(category, 0);
    }
}
