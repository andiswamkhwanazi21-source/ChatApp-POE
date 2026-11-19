/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.quickchat;

import java.util.Scanner;

public class QuickChat {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- QuickChat Menu ---");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Read JSON File into Arrays");
            System.out.println("4) Stored Messages Options");
            System.out.println("5) Quit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Enter recipient cell number: ");
                    String recipient = scanner.nextLine();
                    System.out.print("Enter message (max 250 chars): ");
                    String text = scanner.nextLine();

                    Message msg = new Message(recipient, text);
                    if (!msg.checkRecipientCell() || !msg.checkMessageLength()) {
                        System.out.println("Invalid message or recipient formatting.");
                        break;
                    }

                    System.out.println("1) Send | 2) Discard | 3) Store");
                    int action = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(msg.sentMessage(action));
                    break;

                case 3:
                    Message.readJsonFile("stored_messages.json");
                    break;

                case 4:
                    System.out.println("\n--- Stored Messages Sub-Menu ---");
                    System.out.println("a. Display sender and recipient of all stored messages");
                    System.out.println("b. Display the longest stored message");
                    System.out.println("c. Search for a message ID");
                    System.out.println("d. Search messages for a particular recipient");
                    System.out.println("e. Delete a message using message hash");
                    System.out.println("f. Display full details report");
                    System.out.print("Choose an option (a-f): ");
                    char subChoice = scanner.next().toLowerCase().charAt(0);
                    scanner.nextLine();

                    switch(subChoice) {
                        case 'a':
                            System.out.println(Message.displaySendersAndRecipients());
                            break;
                        case 'b':
                            System.out.println("Longest Message: " + Message.displayLongestMessage());
                            break;
                        case 'c':
                            System.out.print("Enter Message ID: ");
                            String id = scanner.nextLine();
                            System.out.println(Message.searchByMessageID(id));
                            break;
                        case 'd':
                            System.out.print("Enter Recipient Number: ");
                            String rec = scanner.nextLine();
                            System.out.println(Message.searchByRecipient(rec));
                            break;
                        case 'e':
                            System.out.print("Enter Message Hash to delete: ");
                            String hash = scanner.nextLine();
                            if (Message.deleteByHash(hash)) {
                                System.out.println("Message successfully deleted.");
                            } else {
                                System.out.println("Hash not found.");
                            }
                            break;
                        case 'f':
                            System.out.println(Message.displayReport());
                            break;
                        default:
                            System.out.println("Invalid option.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting QuickChat. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        } while(choice != 5);

        scanner.close();
    }
}
