/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.util.Scanner;

/**
 * Main Application
 * Combines Part 1 and Part 2
 *
 * @author Makalabate Rampedi
 */
public class QuickChatApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // ======================
        // PART 1 REGISTRATION
        // ======================

        System.out.println("===== REGISTRATION =====");

        System.out.print("Enter First Name: ");
        String firstName = input.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = input.nextLine();

        System.out.print("Enter Username: ");
        String userName = input.nextLine();

        System.out.print("Enter Password: ");
        String password = input.nextLine();

        System.out.print("Enter Cell Number: ");
        String cellNumber = input.nextLine();

        // Create Login object
        Login user = new Login(
                firstName,
                lastName,
                userName,
                password,
                cellNumber);

        // Register user
        String registrationResult =
                user.registerUser();

        System.out.println("\n" + registrationResult);

        // Stop program if registration fails
        if (!registrationResult.equals(
                "User successfully registered.")) {

            input.close();
            return;
        }

        // ======================
        // LOGIN
        // ======================

        System.out.println("\n===== LOGIN =====");

        System.out.print("Username: ");
        String loginUser =
                input.nextLine();

        System.out.print("Password: ");
        String loginPass =
                input.nextLine();

        System.out.println(
                user.returnLoginStatus(
                        loginUser,
                        loginPass));

        // Stop if login fails
        if (!user.loginUser(
                loginUser,
                loginPass)) {

            input.close();
            return;
        }

        // ======================
        // PART 2 QUICKCHAT
        // ======================

        System.out.println("\nWelcome to QuickChat");

        System.out.print(
                "How many messages would you like to send? ");

        int totalMessages =
                Integer.parseInt(
                        input.nextLine());

        int messagesSent = 0;

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Send Message");
            System.out.println("2. Show Recently Sent Messages");
            System.out.println("3. Quit");

            System.out.print("Select Option: ");

            int option =
                    Integer.parseInt(
                            input.nextLine());

            switch (option) {

                case 1:

                    // Prevent sending more than specified
                    if (messagesSent >= totalMessages) {

                        System.out.println(
                                "Message limit reached.");

                        break;
                    }

                    System.out.print(
                            "Recipient Number: ");

                    String recipient =
                            input.nextLine();

                    System.out.print(
                            "Enter Message: ");

                    String text =
                            input.nextLine();

                    // Create new message
                    Message msg =
                            new Message(
                                    recipient,
                                    text);

                    // Validate recipient
                    System.out.println(
                            msg.checkRecipientCell());

                    // Validate length
                    System.out.println(
                            msg.checkMessageLength());

                    if (msg.checkMessageLength()
                            .equals(
                                    "Message ready to send.")) {

                        System.out.println("\n1. Send");
                        System.out.println("2. Disregard");
                        System.out.println("3. Store");

                        int action =
                                Integer.parseInt(
                                        input.nextLine());

                        System.out.println(
                                msg.SentMessage(action));

                        // Display message info if sent
                        if (action == 1) {

                            System.out.println(
                                    "\nMessage ID: "
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

                case 2:

                    System.out.println(
                            "Coming Soon.");

                    break;

                case 3:

                    System.out.println(
                            "Total Messages Sent: "
                            + Message.returnTotalMessages());

                    System.out.println(
                            "Thank you for using QuickChat.");

                    input.close();
                    System.exit(0);

                    break;

                default:

                    System.out.println(
                            "Invalid option.");
            }
        }
    }
}