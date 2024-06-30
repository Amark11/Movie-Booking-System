package movieBooking;

public class UserManage {
    private String name;
    private String email;
    private String password;

    public UserManage() {}

    public UserManage(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}
