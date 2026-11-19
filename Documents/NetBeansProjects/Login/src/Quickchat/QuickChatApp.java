/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Quickchat;

import java.util.Scanner;

/**
 * QuickChat Main Application
 * Combines Part 1 (Registration and Login)
 * and Part 2 (Messaging System)
 * part 3
 * Author: Makalabate Rampedi
 */
public class QuickChatApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // =========================================
        // PART 1 : USER REGISTRATION
        // =========================================

        System.out.println("===== REGISTRATION =====");
        
        // Capture user details
        System.out.print("Enter First Name: ");
        String firstName = input.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = input.nextLine();

        System.out.print("Enter Username: ");
        String userName = input.nextLine();

        System.out.print("Enter Password: ");
        String password = input.nextLine();

        System.out.print("Enter Cell Number (+27XXXXXXXXX): ");
        String cellNumber = input.nextLine();

        // Create Login object
        Login user = new Login(
                firstName,
                lastName,
                userName,
                password,
                cellNumber);

        // Register user
        String registrationResult = user.registerUser();

        System.out.println("\n" + registrationResult);

        // Stop execution if registration fails
        if (!registrationResult.equals(
                "User successfully registered.")) {

            input.close();
            return;
        }

        // =========================================
        // LOGIN SECTION
        // =========================================

        System.out.println("\n===== LOGIN =====");

        System.out.print("Username: ");
        String loginUser = input.nextLine();

        System.out.print("Password: ");
        String loginPass = input.nextLine();

        // Display login result
        System.out.println(
                user.returnLoginStatus(
                        loginUser,
                        loginPass));

        // Stop execution if login fails
        if (!user.loginUser(
                loginUser,
                loginPass)) {

            input.close();
            return;
        }

        // =========================================
        // PART 2 : QUICKCHAT
        // =========================================

        System.out.println("\nWelcome to QuickChat");

        // Required Part 3 Test Data

        new Message(
        "+27834557896",
        "Did you get the cake?")
        .SentMessage(1);

        new Message(
        "+27838884567",
        "Where are you? You are late! I have asked you to be on time.")
        .SentMessage(3);

        new Message(
        "+27834484567",
        "Yohoooo, I am at your gate.")
        .SentMessage(2);

        new Message(
        "0838884567",
        "It is dinner time!")
        .SentMessage(1);

        new Message(
        "+27838884567",
        "Ok, I am leaving without you.")
        .SentMessage(3);
        // Ask user how many messages they wish to send
        System.out.print(
                "How many messages would you like to send? ");

        String totalInput =
        input.nextLine();

        if(totalInput.isEmpty()) {

         System.out.println(
            "Please enter a valid number.");

    return;
    }

        int totalMessages =
          Integer.parseInt(totalInput);

        int messagesSent = 0;

        // Main menu loop
        while (true) {

            System.out.println("\n===== QUICKCHAT MENU =====");
            System.out.println("1. Send Message");
            System.out.println("2. Show Recently Sent Messages");
            System.out.println("3. Stored Messages");
            System.out.println("4. Quit");
            System.out.println("Select Option: ");
            
            
                String optionInput =
                        input.nextLine();

                if(optionInput.isEmpty()) {

                    System.out.println(
                            "Please enter a menu option.");

                    continue;
                }

                int option;

                try {

                    option =
                            Integer.parseInt(optionInput);

                } catch(NumberFormatException e) {

                    System.out.println(
                            "Invalid number entered.");

                    continue;
                }
            switch (option) {

                // =====================
                // SEND MESSAGE
                // =====================
                case 1:

                    // Check message limit
                    if (messagesSent >= totalMessages) {

                        System.out.println(
                                "Message limit reached.");

                        break;
                    }

                    // Recipient details
                    System.out.print(
                            "Recipient Number: ");

                    String recipient =
                            input.nextLine();

                    // Message body
                    System.out.print(
                            "Enter Message: ");

                    String text =
                            input.nextLine();

                    // Create Message Object
                    Message msg =
                            new Message(recipient, text);

                    // Display validation results
                    System.out.println(
                            msg.checkRecipientCell());

                    System.out.println(
                            msg.checkMessageLength());

                    // Continue only if message length is valid
                    if (msg.checkMessageLength()
                            .equals("Message ready to send.")) {

                        System.out.println("\nChoose Option:");
                        System.out.println("1. Send");
                        System.out.println("2. Disregard");
                        System.out.println("3. Store");

                        int action =
                                Integer.parseInt(
                                        input.nextLine());

                        // Execute selected action
                        System.out.println(
                                msg.SentMessage(action));

                        // Show message information if sent
                        if (action == 1) {

                            System.out.println(
                                    "\n===== MESSAGE DETAILS =====");

                            System.out.println(
                                    "Message ID: "
                                    + msg.getMessageID());

                            System.out.println(
                                    "Message Hash: "
                                    + msg.createMessageHash());

                            System.out.println(
                                    "Recipient: "
                                    + msg.getRecipientCell());

                            System.out.println(
                                    "Message: "
                                    + msg.getMessageText());

                            messagesSent++;
                        }
                    }

                    break;

                // =====================
                // COMING SOON OPTION
                // =====================
                case 2:

                    System.out.println(
                            "Coming Soon.");

                    break;

                // =====================
                // EXIT APPLICATION
                // =====================
                 case 3:

                System.out.println("\nSTORED MESSAGE MENU");

                System.out.println("a. Display Stored Messages");
                System.out.println("b. Display Longest Message");
                System.out.println("c. Search Message ID");
                System.out.println("d. Search Recipient");
                System.out.println("e. Delete Using Hash");
                System.out.println("f. Display Report");

                String choice =
                        input.nextLine();

                switch(choice.toLowerCase()) {

                    case "a":

                        Message.displayStoredMessages();
                        break;

                    case "b":

                        System.out.println(
                                Message.getLongestMessage());

                        break;

                    case "c":

                        System.out.print(
                                "Enter Message ID: ");

                        String id =
                                input.nextLine();

                        System.out.println(
                                Message.searchMessageID(id));

                        break;

                    case "d":

                        System.out.print("Enter Recipient: ");

                        String recipientSearch =
                                input.nextLine();

                        System.out.println(Message.searchRecipient(recipientSearch));

                        break;

                    case "e":

                        System.out.print(
                                "Enter Message Hash: ");

                        String hash =
                                input.nextLine();

                        System.out.println(
                                Message.deleteByHash(hash));

                        break;

                    case "f":

                        Message.displayReport();
                        break;

                    default:

                        System.out.println(
                                "Invalid selection.");
                }

                break;
                
                case 4:

                  System.out.println(
                          "Total Messages Sent: "
                    + Message.returnTotalMessages());

                  System.out.println(
                          "Thank you for using QuickChat.");

                          input.close();
                         System.exit(0);
                break;
            }
        }
    }
}