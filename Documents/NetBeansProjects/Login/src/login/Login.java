/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Login;
import java.util.Scanner;


/**
 *
 * @author Makalabate Rampedi
 */

    
    //Condtructor
public class Login {

    private String userName;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    public Login(String firstName,
                 String lastName,
                 String userName,
                 String password,
                 String cellPhoneNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== Registration ===");
        
        System.out.print("Enter First Name:");
        String firstName = input.nextLine();
        
        System.out.print("Enter Last Name:");
        String lastName = input.nextLine();
        
        System.out.print("Enter Username:");
        String userName = input.nextLine();
        
        System.out.print("Enter Password:");
        String password = input.nextLine();
        
        System.out.print("Enter South African Cellphone Number(+27):");
        String cellPhoneNumber = input.nextLine();
      
          //Registration feedback
        Login user = new Login(
        firstName,
        lastName,
        userName,
        password,
        cellPhoneNumber);
        
          System.out.println(user.registerUser());

        if (!user.registerUser()
                .equals("User successfully registered.")) {
            input.close();
            return;
        }
        
        
        //Registration feedback
       
        
        
        //Login
        
        System.out.println("\n=== LOGIN ===");

        System.out.print("Enter Username: ");
        String loginUsername = input.nextLine();

        System.out.print("Enter Password: ");
        String loginPassword = input.nextLine();

        System.out.println(
                user.returnLoginStatus(
                        loginUsername,
                        loginPassword));

        input.close();
        
    }
    //Username Validation
   
    public boolean checkUserName() {

        return userName.contains("_")
                && userName.length() <= 5;
    }

    // Method 2
    public boolean checkPasswordComplexity() {

        boolean hasCapital =
                password.matches(".*[A-Z].*");

        boolean hasNumber =
                password.matches(".*\\d.*");

        boolean hasSpecial =
                password.matches(".*[!@#$%^&*()].*");

        boolean hasLength =
                password.length() >= 8;

        return hasCapital
                && hasNumber
                && hasSpecial
                && hasLength;
    }

    // Method 3
    public boolean checkCellPhoneNumber() {

        return cellPhoneNumber.matches("^\\+27\\d{9}$");
    }

    // Method 4
    public String registerUser() {

        if (!checkUserName()) {

            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity()) {

            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber()) {

            return "Cell phone number incorrectly formatted or does not contain an international code.";
        }

        return "User successfully registered.";
    }

    // Method 5
    public boolean loginUser(String enteredUserName,
                             String enteredPassword) {

        return userName.equals(enteredUserName)
                && password.equals(enteredPassword);
    }

    // Method 6
    public String returnLoginStatus(String enteredUserName,
                                    String enteredPassword) {

        if (loginUser(enteredUserName,
                enteredPassword)) {

            return "Welcome "
                    + firstName
                    + " "
                    + lastName
                    + ", it is great to see you again.";
        }

        return "Username or password incorrect, please try again.";
    }
    
 }

