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
    private static boolean loginSuccess;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter Username:");
        registeredUsername = input.nextLine();
        
        System.out.print("Enter Password:");
        registeredPassword = input.nextLine();
        
        System.out.print("Enter South African Cellphone Number:");
        cellphone = input.nextLine();
        
        System.out.print("Enter First Name:");
        firstName = input.nextLine();
        
        System.out.print("Enter Last Name:");
        lastName = input.nextLine();
        
        //Registration feedback
        System.out.print(registerUser());
        
        
        //Login
        System.out.println("\n-- LOGIN ---");
        System.out.println("Enter Username: ");
        String loginUsername = input.nextLine();
        
        System.out.print("Enter Password: ");
        String loginPassword = input.nextLine();
        
        boolean loginSuccess = loginUser(loginUsername, loginPassword);
        System.out.println(returnLoginStatus(loginSuccess));
        
        
        
        input.close();
    }
    //Username Validation
    public static boolean checkUsername(String username){
    
       return username.contains("_") && username.length() <= 5 ;
    
        
    }

    //Password Validation
    public static boolean checkPasswordComplexity(String password){
       
    boolean hasNum = false ,  hasCap = false, hasSpecial = false;
    
    for(int i = 0; i < password.length(); i++){
        char c = password.charAt(i);
    
  
        if(Character.isDigit(c)){
            hasNum =true;
        }
        else if (Character.isUpperCase(c)){
            hasCap = true;
        }
        else if(Character.isLowerCase(c)){
            hasSpecial = true;        
        }
    }
    
    return hasNum && hasCap && hasSpecial && password.length() >= 8;
   
    }
    
    //Cellphone validation
    public static boolean checkCellPhoneNumber(String Cellphone){
        
            return Cellphone.startsWith("+27") && Cellphone.length() == 12;
           
    }
    
    //Registration method
    public static String registerUser(){
    if(!checkUsername(registeredUsername)){
        
    return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five character in length.";}
    
    if(!checkPasswordComplexity(registeredPassword)){
        
        return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";}
    if(!checkCellPhoneNumber(cellphone)){return "Cell phone number incorrectly formatted or does not contain international code.";}
    
    return "User registered successfully.";
    }
    
    //Login method
    public static boolean loginUser(String Username, String Password){
    return Username.equals(registeredUsername) && Password.equals(registeredPassword);}
    
    
    //Login Status message
    public static String returnLoginStatus(boolean loginSucccess){
    if(loginSuccess){
    return "Welcome" + firstName + "" + lastName + ", it is great to see you again.";}
    else{ return "Username or password incorrect, please try again"; }}
        
    
}
