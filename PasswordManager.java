import java.util.ArrayList;
import java.util.Scanner;

class User {
    String username;
    String password;
    
    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

public class PasswordManager {
    private ArrayList<User> users = new ArrayList<>();
    
    public boolean isStrong(String password) {
        if (password.length() < 10) {
            return false;
        }
        
        boolean hasUpper = false;    // Uppercase letters (A-Z)
        boolean hasLower = false;    // Lowercase letters (a-z)
        boolean hasDigit = false;    // Numbers (0-9)
        boolean hasSpecial = false;  // Special characters
        
        String specialChars = "!@#$%^&*()-+=<>/";
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }
            if (Character.isLowerCase(c)) {
                hasLower = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (specialChars.contains(String.valueOf(c))) {
                hasSpecial = true;
            }
        }
        
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
    
    public void savePassword(String username, String password) {
        if (isStrong(password)) {
            users.add(new User(username, password));
            System.out.println("Password saved!");
        } else {
            System.out.println("Password is too weak! It must have:");
            System.out.println("- At least 10 characters");
            System.out.println("- At least one uppercase letter (A-Z)");
            System.out.println("- At least one lowercase letter (a-z)");
            System.out.println("- At least one number (0-9)");
            System.out.println("- At least one special character (!@#$%^&*)");
        }
    }
    
    public static void main(String[] args) {
        PasswordManager manager = new PasswordManager();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        manager.savePassword(username, password);
        
        scanner.close();
    }
}