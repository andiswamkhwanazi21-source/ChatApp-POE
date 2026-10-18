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

    // 1. Generate a random 10-digit message ID
    private String generateMessageID() {
        Random rand = new Random();
        long id = 1000000000L + rand.nextLong(9000000000L);
        return String.valueOf(id);
    }

    // 2. checkMessageID(): ensures message ID is not more than 10 characters
    public boolean checkMessageID() {
        return messageID != null && messageID.length() <= 10;
    }

    // 3. checkRecipientCell(): max 13 chars and contains international code (e.g., +)
    public boolean checkRecipientCell() {
        return recipientCell != null && recipientCell.length() <= 13 && recipientCell.contains("+");
    }

    // 4. checkMessageLength(): ensures message is not more than 250 characters
    public boolean checkMessageLength() {
        return messageText != null && messageText.length() <= 250;
    }

    // 5. createMessageHash(): first two numbers of ID, colon, message number, colon, first and last words (All CAPS)
    public String createMessageHash() {
        if (messageID == null || messageID.length() < 2 || messageText == null || messageText.trim().isEmpty()) {
            return "";
        }
        String firstTwoID = messageID.substring(0, 2);
        String[] words = messageText.trim().split("\\s+");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        
        String hash = firstTwoID + ":" + (totalMessagesSent + 1) + ":" + firstWord + lastWord;
        return hash.toUpperCase();
    }

    // 6. sentMessage(): options to send, store, or disregard
    public String sentMessage(int choice) {
        switch (choice) {
            case 1:
                totalMessagesSent++;
                return "Message successfully sent.";
            case 2:
                return "Press 0 to delete the message.";
            case 3:
                return "Message successfully stored.";
            default:
                return "Invalid choice.";
        }
    }

    // 7. returnTotalMessages(): returns total number of messages sent
    public static int returnTotalMessages() {
        return totalMessagesSent;
    }

    // Getters for printing details
    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }
    public String getRecipientCell() { return recipientCell; }
    public String getMessageText() { return messageText; }
}    
