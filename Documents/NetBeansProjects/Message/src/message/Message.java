/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package message;

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
    
    private static int  totalMessagesSent = 0;
//constructor
public Message(String checkRecipientCell, String messageText){
   this.messageID = generateRandomMessageID();
   this.recipientCell = recipientCell;
   this.messageText = messageText;
   this.messageIndex = totalMessageSent;
   this.messageHash = createMessageHash();
   totalMessageSent++;

}
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Generate random 10-digit ID
        private String generateRandomMessageID(){
        Random rand = new Random();
        long num = (long)(rand.nextDouble() * 1_000_000_0000L);
        return String.format("%010d", num);
        }
        
        //Check ID length
        public boolean checkMessageID(){
          return this.messageID != null && this.messageID.length() <= 10; }
        
        //Validate recipient cell
        public boolean checkRecipientCell(){
        if (recipientCell != null && recipientCell.startsWith("+") && recipientCell.length() <= 12)
        {return "Cell phone number successfully captured."; }
        
        else{ return "Cell phone number is incorrectly formatted or does not contain an international code."; }
        }
        
        //Validate message length 
        public String checkMessageLength(){
        if(messageText.length() <= 250){ return "Message ready to send.";}
        else{
        int overflow = messageText.length() -250;
        return "Message exceeds 250 characters by" + overflow + "; please reduce the size";}
        }
        // create hash
        public String createMessageHash(){
        String[] words = messageText.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        return (messageID.substring(0, 2) + ":" + messageIndex + ":" +  firstWord + lastWord).toUpperCase();}
        
        // Send / Store / Discard 
        public String sendMessages(String option){
               switch(option.toLowerCase()){
                   case "send": return"Message successfully sent";
                   case "store": return "Message successfully stored";
                   case "dicard": return "Press 0 to delete the message";
                   default: return "Invalid option";
               }
        }
        
        //Print details
        public String printMessage(){
        return "Message ID: " + messageID +
                "\nMessage Hash: " + messageHash +
                "\nRecipient: " + recipientCell +
                "\nMessage: " + messageText;
        }
        
        public static int returnTotalMessages(){
        return totalMessagesSent; }
    }
    
   
}
