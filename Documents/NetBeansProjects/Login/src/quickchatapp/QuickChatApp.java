/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quickchatapp;

import java.util.Scanner;

/**
 *
 * @author Makalabate Rampedi
 */
public class QuickChatApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();
        
        if (!username.isEmpty() && !password.isEmpty()){
        System.out.println("Welcome to QuickChat.");}
        else{
        System.out.println("Login failed. Exiting...");
        return;}
        
        //Ask how many messages
        System.out.print("How many messages would you like to send? ");
        int numMessages = input.nextInt();
        input.nextLine();
        
        int sentCount = 0;
        
        //Menu loop
        
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1) Send Message");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    if (sentCount < numMessages) {
                        System.out.print("Enter recipient number: ");
                        String recipient = input.nextLine();
                        System.out.print("Enter your message: ");
                        String messageText = input.nextLine();

                        Message msg = new Message(recipient, messageText);

                        System.out.println(msg.checkRecipientCell());
                        System.out.println(msg.checkMessageLength());
                        System.out.println(msg.sendMessage("send"));
                        System.out.println(msg.printMessage());

                        sentCount++;
                    } else {
                        System.out.println("You have reached your message limit.");
                    }
                    break;

                case 2:
                    System.out.println("Coming Soon.");
                    break;

                case 3:
                    System.out.println("Exiting QuickChat. Goodbye!");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        
    }
    
}
