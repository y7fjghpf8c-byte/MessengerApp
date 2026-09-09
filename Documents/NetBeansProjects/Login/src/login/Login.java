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
        input.close();
    }
    
    public static boolean checkUsername(String Username){
    
       If( Username.contains("_") && Username.length() <= 5  ){
    System.out.print("Username successfully captured");}
       
     else{System.out.print("Username is not correctly formatted please ensure that your" +
          "username contains an underscore and is no more than five characters in length.");}
        return true;
    }
    
    public static boolean PasswordComplexity(){
    
    }
    
    
}
