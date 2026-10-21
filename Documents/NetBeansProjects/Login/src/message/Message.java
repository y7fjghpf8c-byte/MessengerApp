/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Message;

import java.util.Random;

/**
 *
 * @author Makalabate Rampedi
 */


public class Message {

    private String messageID;
    private String recipientCell;
    private String messageText;
    private String messageHash;
    private int messageIndex;

    private static int totalMessagesSent = 0;

    // Constructor used by most tests
    public Message(String recipientCell, String messageText) {
        this.messageID = generateRandomMessageID();
        this.recipientCell = recipientCell;
        this.messageText = messageText;
        this.messageIndex = totalMessagesSent;
        this.messageHash = createMessageHash();
        totalMessagesSent++;
    }

    // Constructor used by hash test
    public Message(String messageID,
                   String recipientCell,
                   String messageText,
                   int messageIndex) {

        this.messageID = messageID;
        this.recipientCell = recipientCell;
        this.messageText = messageText;
        this.messageIndex = messageIndex;
        this.messageHash = createMessageHash();
    }

    private String generateRandomMessageID() {
        Random rand = new Random();
        long num = (long) (rand.nextDouble() * 10000000000L);
        return String.format("%010d", num);
    }

    public boolean checkMessageID() {
        return messageID != null && messageID.length() == 10;
    }

    public String getMessageID() {
        return messageID;
    }

    public String checkRecipientCell() {
        if (recipientCell != null
                && recipientCell.startsWith("+")
                && recipientCell.length() <= 12) {

            return "Cell phone number successfully captured.";
        }

        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }

    public String checkMessageLength() {

        if (messageText.length() <= 250) {
            return "Message ready to send.";
        }

        int overflow = messageText.length() - 250;

        return "Message exceeds 250 characters by "
                + overflow
                + "; please reduce the size.";
    }

    public String createMessageHash() {

        String[] words = messageText.split(" ");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        return (messageID.substring(0, 2)
                + ":"
                + messageIndex
                + ":"
                + firstWord
                + lastWord).toUpperCase();
    }

    public String SentMessage(int option) {

        switch (option) {

            case 1:
                return "Message successfully sent.";

            case 2:
                return "Press 0 to delete the message.";

            case 3:
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    public String printMessage() {
        return "Message ID: " + messageID
                + "\nMessage Hash: " + messageHash
                + "\nRecipient: " + recipientCell
                + "\nMessage: " + messageText;
    }

    public static int returnTotalMessages() {
        return totalMessagesSent;
    }

    public static void resetTotalMessagesSent() {
        totalMessagesSent = 0;
    }

   

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
    
}
   

