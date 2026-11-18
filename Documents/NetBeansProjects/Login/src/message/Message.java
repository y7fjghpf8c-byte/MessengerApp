/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.util.Random;

/**
 * Message Class
 * Handles message processing.
 */
public class Message {
    

    private String messageID;
    private String recipientCell;
    private String messageText;
    private int messageNumber;

    private static int totalMessagesSent = 0;
    
    // ======================================
// PART 3 ARRAYS
// ======================================
 
// Messages that were sent
private static String[] sentMessages = new String[100];
 
// Messages that were stored
private static String[] storedMessages = new String[100];
 
// Messages that were disregarded
private static String[] disregardedMessages = new String[100];
 
// Message hashes
private static String[] messageHashes = new String[100];
 
// Message IDs
private static String[] messageIDs = new String[100];
 
// Recipients
private static String[] recipients = new String[100];
 
// Counters
private static int sentCount = 0;
private static int storedCount = 0;
private static int disregardedCount = 0;

    /**
     * Constructor
     */
    public Message(String recipientCell,
                   String messageText) {

        this.messageID = generateMessageID();
        this.recipientCell = recipientCell;
        this.messageText = messageText;
        this.messageNumber = totalMessagesSent;
    }

    /**
     * Constructor for testing
     */
    public Message(String messageID,
                   String recipientCell,
                   String messageText,
                   int messageNumber) {

        this.messageID = messageID;
        this.recipientCell = recipientCell;
        this.messageText = messageText;
        this.messageNumber = messageNumber;
    }

    /**
     * Generate random 10-digit ID
     */
    private String generateMessageID() {

        Random random = new Random();

        long number =
                (long)(random.nextDouble()
                        * 10000000000L);

        return String.format("%010d", number);
    }

    /**
     * Verify Message ID length
     */
    public boolean checkMessageID() {

        return messageID.length() == 10;
    }

    /**
     * Validate recipient cell
     */
    public String checkRecipientCell() {

        if (recipientCell.startsWith("+")
                && recipientCell.length() <= 12) {

            return "Cell phone number successfully captured.";
        }

        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }

    /**
     * Verify message length
     */
    public String checkMessageLength() {

        if (messageText.length() <= 250) {

            return "Message ready to send.";
        }

        int excess =
                messageText.length() - 250;

        return "Message exceeds 250 characters by "
                + excess
                + "; please reduce the size.";
    }

    /**
     * Creates Message Hash
     */
    public String createMessageHash() {

        String[] words =
                messageText.split(" ");

        String firstWord =
                words[0];

        String lastWord =
                words[words.length - 1];

        return (messageID.substring(0, 2)
                + ":"
                + messageNumber
                + ":"
                + firstWord
                + lastWord)
                .toUpperCase();
    }

    /**
     * Send, Store or Delete
     */
    public String SentMessage(int option) {

    switch(option) {

        case 1:

            // Save sent message information
            sentMessages[sentCount] = messageText;
            recipients[sentCount] = recipientCell;
            messageHashes[sentCount] = createMessageHash();
            messageIDs[sentCount] = messageID;

            sentCount++;
            totalMessagesSent++;

            return "Message successfully sent.";

        case 2:

            // Save disregarded message
            disregardedMessages[disregardCount] =
                    messageText;

            disregardCount++;

            return "Press 0 to delete the message.";

        case 3:

            // Save stored message information
            storedMessages[storedCount] = messageText;
            recipients[storedCount] = recipientCell;
            messageHashes[storedCount] = createMessageHash();
            messageIDs[storedCount] = messageID;

            storedCount++;

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
    
    /**
 * Displays all stored messages.
 */
public static void displayStoredMessages() {

    System.out.println("\n=== STORED MESSAGES ===");

    for(int i = 0; i < storedCount; i++) {

        System.out.println(
                "Recipient: "
                + recipients[i]);

        System.out.println(
                "Message: "
                + storedMessages[i]);

        System.out.println(
                "--------------------");
    }
}

/**
 * Finds the longest stored message.
 */
public static String getLongestM*ssage() {

    String longest = ""*

    for(int i = 0; i < storedCou*t; i++) {

        if(storedMessag*s[i] != null &&
           storedM*ssages[i].length() >
           lo*gest.length()) {

            long*st = storedMessages[i];
        }
*   }

    return longest;
}

/**
 * Searches for a message us*ng Message ID.
 */
public static S*ring searchMessageID(String id) {
*    for(int i = 0; i < storedCount* i++) {

        if(messageIDs[i] *= null &&
           messageIDs[i]*equals(id)) {

            return *Recipient: "
                    +*recipients[i]
                    * "\nMessage: "
                   *+ storedMessages[i];
        }
   *}

    return "Message ID not foun*.";
}

/**
 * Displays all *essages
 * for a specific recipien*.
 */
public static String searchR*cipient(String recipient) {

    S*ring result = "";

    for(int i =*0; i < storedCount; i++) {

      * if(recipients[i] != null &&
     *     recipients[i].equals(recipien*)) {

            result += stored*essages[i]
                    + "*n";
        }
    }

    return re*ult;
}

/**
 * Deletes a*message using
 * a message hash.
 */
public static String deleteByHas*(String hash) {

    for(int i = 0* i < storedCount; i++) {

        *f(messageHashes[i] != null &&
    *      messageHashes[i].equals(hash*) {

            String deletedMes*age =
                    storedMe*sages[i];

            storedMessa*es[i] = null;

            return *Message: \""
                    +*deletedMessage
                   *+ "\" successfully deleted.";
    *   }
    }

    return "Hash not f*und.";
}

/**
 * Displays a comp*ete report
 * of all stored messag*s.
 */
public static void displayR*port() {

    System.out.println(
*           "\n=== REPORT ===");

 *  for(int i = 0; i < storedCount; *++) {

        if(storedMessages[i] != null) {

            System.ou*.println(
                    "Mes*age Hash: "
                    + *essageHashes[i]);

            Sys*em.out.println(
                  * "Recipient: "
                   *+ recipients[i]);

            Sys*em.out.println(
                  * "Message: "
                    +*storedMessages[i]);

            S*stem.out.println(
                *   "--------------------");
      * }
    }
}
}