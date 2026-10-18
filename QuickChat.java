/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.quickchat;

/**
 *
 * @author Silungile
 */

import java.util.Scanner;

public class QuickChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
              

        // Simulated Login Check (integrate your Part 1 login variables here)
        boolean isLoggedIn = true; 

        if (!isLoggedIn) {
            System.out.println("You must log in successfully to send messages.");
            return;
        }

        System.out.println("Welcome to QuickChat.");

        int choice;
        do {
            System.out.println("\n--- QuickChat Menu ---");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Choose an option: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("How many messages would you like to enter? ");
                    int numMessages = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < numMessages; i++) {
                        System.out.println("\n--- Message " + (i + 1) + " ---");
                        System.out.print("Enter recipient cell number (max 13 chars, include international code): ");
                        String recipient = scanner.nextLine();

                        System.out.print("Enter message (max 250 characters): ");
                        String text = scanner.nextLine();

                        Message msg = new Message(recipient, text);

                        // Validate recipient
                        if (!msg.checkRecipientCell()) {
    System.out.println("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.");
} else {
    System.out.println("Cell phone number successfully captured.");
}
         
                        // Validate message length
                        if (!msg.checkMessageLength()) {
    int excess = text.length() - 250;
    System.out.println("Message exceeds 250 characters by " + excess + "; please reduce the size.");
} else {
    System.out.println("Message ready to send.");
}

                        // Display action options
                        System.out.println("Choose action: 1) Send Message | 2) Discard Message | 3) Store Message");
                        int action = scanner.nextInt();
                        scanner.nextLine();

                        String result = msg.sentMessage(action);
                        System.out.println(result);

                        // Print full details if sent or stored
                        if (action == 1 || action == 3) {
                            System.out.println("\n--- Message Details ---");
                            System.out.println("Message ID: " + msg.getMessageID());
                            System.out.println("Message Hash: " + msg.getMessageHash());
                            System.out.println("Recipient: " + msg.getRecipientCell());
                            System.out.println("Message: " + msg.getMessageText());
                        }
                    }
                    System.out.println("\nTotal messages processed/sent: " + Message.returnTotalMessages());
                    break;

                case 2:
                    System.out.println("Coming Soon.");
                    break;

                case 3:
                    System.out.println("Exiting QuickChat.Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 3.");
            }
        } while (choice != 3);

        scanner.close();
    }
}   

