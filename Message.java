/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.quickchat;

import java.util.Random;

/**
 *
 * @author Silungile
 */

public class Message {

   String messageID;
   String recipientCell;
   String messageText;
   String messageHash;

    private static int totalMessagesSent = 0;

    // Constructor
    public Message(String recipientCell, String messageText) {
        this.recipientCell = recipientCell;
        this.messageText = messageText;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }

    // Generate random 10-digit Message ID
    private String generateMessageID() {
        Random rand = new Random();

        long id =
                1000000000L +
                (long)(rand.nextDouble() * 9000000000L);

        return String.valueOf(id);
    }

    // Check ID length
    public boolean checkMessageID() {
        return messageID != null &&
               messageID.length() <= 10;
    }

    // Regex validation
    public boolean checkRecipientCell() {

        if(recipientCell == null){
            return false;
        }

        return recipientCell.matches("^\\+[0-9]{10,12}$");
    }

    // Validate message length
    public boolean checkMessageLength() {

        return messageText != null
                && messageText.length() <= 250;
    }

    // Create hash
    public String createMessageHash() {

        if (messageID == null ||
                messageText == null ||
                messageText.trim().isEmpty()) {

            return "";
        }

        String firstTwoID =
                messageID.substring(0, 2);

        String[] words =
                messageText.trim().split("\\s+");

        String firstWord = words[0];

        String lastWord =
                words[words.length - 1];

        String hash =
                firstTwoID + ":" +
                (totalMessagesSent + 1) +
                ":" +
                firstWord +
                lastWord;

        return hash.toUpperCase();
    }

    // Send / Store / Discard
    public String sentMessage(int choice) {

        switch(choice){

            case 1:
                totalMessagesSent++;
                return "Message successfully sent.";

            case 2:
                return "Message discarded.";

            case 3:
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    // Convert object to JSON
    public String toJSON() {

        return "{\n" +
                "\"messageID\":\"" + messageID + "\",\n" +
                "\"recipient\":\"" + recipientCell + "\",\n" +
                "\"message\":\"" + messageText + "\",\n" +
                "\"hash\":\"" + messageHash + "\"\n" +
                "}";
    }

    // Getters

    public String getMessageID() {
        return messageID;
    }

    public String getRecipientCell() {
        return recipientCell;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public static int returnTotalMessages() {
        return totalMessagesSent;
    }
}
