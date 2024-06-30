package movieBooking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserRegister {
    private Map<String, UserManage> users = new HashMap<>();

    public boolean registerUser(String name, String email, String password) {
        int attempts = 0;
        while (attempts < 3) {
            if (users.containsKey(email)) {
                System.out.println("User already exists.");
                return false;
            } else if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                System.out.println("All fields are required.");
                attempts++;
                System.out.println("Attempts remaining: " + (3 - attempts));
                try (Scanner scanner = new Scanner(System.in)) {
                    System.out.println("Please Enter Your Name : ");
                    name = scanner.nextLine();
                    System.out.println("Please Enter Your E-mail : ");
                    email = scanner.nextLine();
                    System.out.println("Please Enter Your Password : ");
                    password = scanner.nextLine();
                }
            } else {
                users.put(email, new UserManage(name, email, password));
                System.out.println("Registration successful...");
                System.out.println("--------------------------------------------");
                return true;
            }
        }
        System.out.println("Registration failed due to too many invalid attempts.");
        return false;
    }

    public boolean loginUser(String email, String password) {
        if (!users.containsKey(email) || !users.get(email).getPassword().equals(password)) {
            System.out.println("Invalid email or password.");
            return false;
        }
        System.out.println("Login successful.");
        return true;
    }
}
