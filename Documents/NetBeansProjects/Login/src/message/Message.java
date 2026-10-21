/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package message;

import java.util.Random;
/**
 *
 * @author Makalabate Rampedi
 */
public class Message {
    
    public static void main(String[] args) {
        System.out.println("QuickChat started");
    }
    
    
    private String messageID;
    private String recipientCell;
    private String messageText;
    private int messageIndex;

    private static int totalMessagesSent = 0;

    public Message(String recipientCell, String messageText) {
        this.messageID = generateMessageID();
        this.recipientCell = recipientCell;
        this.messageText = messageText;
        this.messageIndex = totalMessagesSent;
    }

    public Message(String messageID,
                   String recipientCell,
                   String messageText,
                   int messageIndex) {

        this.messageID = messageID;
        this.recipientCell = recipientCell;
        this.messageText = messageText;
        this.messageIndex = messageIndex;
    }

    private String generateMessageID() {

        Random random = new Random();

        long number =
                (long) (random.nextDouble() * 10000000000L);

        return String.format("%010d", number);
    }

    public boolean checkMessageID() {

        return messageID != null
                && messageID.length() == 10;
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

        int extraCharacters =
                messageText.length() - 250;

        return "Message exceeds 250 characters by "
                + extraCharacters
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
                totalMessagesSent++;
                return "Message successfully sent.";

            case 2:
                return "Press 0 to delete the message.";

            case 3:
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    public String getMessageID() {
        return messageID;
    }

    public String getRecipientCell() {
        return recipientCell;
    }

    public String getMessageText() {
        return messageText;
    }

    public static int returnTotalMessages() {
        return totalMessagesSent;
    }

    public static void resetTotalMessagesSent() {
        totalMessagesSent = 0;
    }
}
