/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package login;
import java.util.Scanner;


/**
 *
 * @author Makalabate Rampedi
 */
public class Login {
        //Store registered credentials
    private static String registeredUsername;
    private static String registeredPassword;
    private static String firstName;
    private static String lastName;
    private static String cellphone;
    private static boolean Success;
    
    //Condtructor
public Login(String firstName, String lastName, String registeredUsername, String registeredPassword, String cellphone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registeredUsername = registeredUsername;
        this.registeredPassword = registeredPassword;
        this.cellphone = cellphone;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== Registration ===");
        
        System.out.print("Enter First Name:");
        firstName = input.nextLine();
        
        System.out.print("Enter Last Name:");
        lastName = input.nextLine();
        
        System.out.print("Enter Username:");
        registeredUsername = input.nextLine();
        
        System.out.print("Enter Password:");
        registeredPassword = input.nextLine();
        
        System.out.print("Enter South African Cellphone Number(+27):");
        cellphone = input.nextLine();
      
        
        
        //Registration feedback
        Login user = new Login(firstName, lastName, registeredPassword,registeredUsername,   cellphone);
        System.out.println(user.registerUser());
        
        
        //Login
        System.out.println("\n-- LOGIN ---");
        System.out.println("Enter Username: ");
        String loginUsername = input.nextLine();
      
        System.out.print("Enter Password: ");
        String loginPassword = input.nextLine();
        
       boolean Success = user.loginUser(loginUsername, loginPassword);
       System.out.println(user.returnLoginStatus(Success));
        
        
        input.close();
    }
    //Username Validation
    public boolean checkUsername(String username){
    
       return username.contains("_") && username.length() <= 5 ;
    
        
    }

    //Password Validation
    public boolean checkPasswordComplexity(String password){
       
        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*(),.?\\\":{}|<>].*");
        return password.length() >= 8 && hasUppercase && hasNumber && hasSpecialChar;
    }
    
    //Cellphone validation
    public  boolean checkCellPhoneNumber(String Cellphone){
        
            return Cellphone.matches("^\\+27\\d{9}$");
           
    }
    
    //Registration 
    public String registerUser(){
    if(!checkUsername(registeredUsername)){
        
    return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five character in length.";}
    
    else if(!checkPasswordComplexity(registeredPassword)){
 
        return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";}
    
    else if(!checkCellPhoneNumber(cellphone)){return "Cell phone number incorrectly formatted or does not contain international code.";}
    
    else{
         
          return " User registered successfully!";}
   
    }
    
    //Login 
    public  boolean loginUser(String Username, String Password){
    return Username.equals(registeredUsername) && Password.equals(registeredPassword);}
    
    
    //Login Status message
    public  String returnLoginStatus(boolean Success){
    if(Success){
    return "Welcome" + firstName + "" + lastName + ", it is great to see you again.";}
    else{ return "Username or password incorrect, please try again"; }}

    public boolean checkUsername() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
    
}
