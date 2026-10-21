/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Login;

/**
 * Registration and Login Class
 * Author: Makalabate Rampedi
 */
public class Login {

    // User information
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String cellPhoneNumber;

    /**
     * Constructor
     */
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
     * Username must contain "_"
     * and not exceed 5 characters
     */
    public boolean checkUserName() {

        return userName.contains("_")
                && userName.length() <= 5;
    }

    /**
     * Password Requirements:
     * 8 characters minimum
     * Capital letter
     * Number
     * Special character
     */
    public boolean checkPasswordComplexity() {

        boolean hasCapital =
                password.matches(".*[A-Z].*");

        boolean hasNumber =
                password.matches(".*\\d.*");

        boolean hasSpecial =
                password.matches(".*[!@#$%^&*()].*");

        boolean hasLength =
                password.length() >= 8;

        return hasCapital &&
               hasNumber &&
               hasSpecial &&
               hasLength;
    }

    /**
     * Validates SA number with
     * international code
     */
    public boolean checkCellPhoneNumber() {

        return cellPhoneNumber.matches("^\\+27\\d{9}$");
    }

    /**
     * Registration process
     */
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

    /**
     * Checks login details
     */
    public boolean loginUser(String enteredUsername,
                             String enteredPassword) {

        return userName.equals(enteredUsername)
                && password.equals(enteredPassword);
    }

    /**
     * Login feedback
     */
    public String returnLoginStatus(String enteredUsername,
                                    String enteredPassword) {

        if (loginUser(
                enteredUsername,
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