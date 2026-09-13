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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter Username:");
        String Username = input.nextLine();
        
        System.out.print("Enter Password:");
        String Password = input.nextLine();
        
        System.out.print("Enter South African Cellphone Number:");
        String Cellphone = input.nextLine();
        
        //call checker method and print and print the message it returns
        System.out.print(checkUsername(Username));
        System.out.print(checkPasswordComplexity(Password));
        
        input.close();
    }
    
    public static String checkUsername(String Username){
    
       if( Username.contains("_") && Username.length() <= 5  ){
           return "Username successfully captured";}
       
     else{
           return "Username is not correctly formatted. please ensure that"
                  + " your username contains an underscore and is no more than five characters in length.";}
        
    }

    
    public static String checkPasswordComplexity(String Password){
       
    boolean HasNum = false , HasLow = false, HasCap = false, HasSpecial = false;
    
    for(int i = 0; i < (Password.length()); i++){
        char c = Password.charAt(i);
    
  
        if(Character.isDigit(c)){
            HasNum =true;
        }
        else if (Character.isUpperCase(c)){
            HasCap = true;
        }
        else if(Character.isLowerCase(c)){
        HasLow = true;        
        }
        else {HasSpecial = true;} //Anything not letter or digit
    }
 
        
        
        if(HasNum && HasCap && HasLow && HasSpecial && Password.length() >= 8){
             return "Password successfully captured";}
        else {
        return "Password is not correctly formatted;please ensure that the password contains at least eight characters,a captial letter , a number, and a special character";
             }
    }
        
    
}
