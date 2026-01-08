import java.util.Scanner;
import java.security.MessageDigest;

public class Login_Secure {
    // Method to hash password using SHA-256
    public static String hashPassword(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Taking input from console
            System.out.print("Enter Username: ");
            String user_name = sc.nextLine();
            System.out.print("Enter Password: ");
            String password = sc.nextLine();
            // Hashing input password
            String inputPasswordHash = hashPassword(password);
            //username and password set
            String storedUsername = "admin";
            String storedPasswordHash = hashPassword("admin123");
            // Authentication check of user
            if (user_name.equals(storedUsername) && inputPasswordHash.equals(storedPasswordHash)) 
            {
                System.out.println("Login Successful");//if user enter correct username and password

            } else {
                System.out.println("Invalid Username or Password");//if user enter wrong info
            }
        } catch (Exception e) {
            System.out.println("An error occurred. Please try again.");
        }
        sc.close();
    }
}
