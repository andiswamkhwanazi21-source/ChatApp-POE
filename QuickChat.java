/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.quickchat;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class QuickChat {

    // Stores sent and stored messages
    static ArrayList<Message> messages =
            new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        boolean isLoggedIn = true;

        if(!isLoggedIn){

            System.out.println(
                    "You must log in successfully to send messages."
            );

            return;
        }

        System.out.println("Welcome to QuickChat.");

        int choice;

        do{

            System.out.println();
            System.out.println("--- QuickChat Menu ---");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){

                case 1:

                    System.out.print(
                            "How many messages would you like to enter? "
                    );

                    int numMessages =
                            scanner.nextInt();

                    scanner.nextLine();

                    for(int i = 0;
                            i < numMessages;
                            i++){

                        System.out.println(
                                "\n--- Message "
                                        + (i + 1)
                                        + " ---"
                        );

                        System.out.print(
                                "Enter recipient cell number: "
                        );

                        String recipient =
                                scanner.nextLine();

                        System.out.print(
                                "Enter message (max 250 chars): "
                        );

                        String text =
                                scanner.nextLine();

                        Message msg =
                                new Message(
                                        recipient,
                                        text
                                );

                        if(!msg.checkRecipientCell()) {

                            System.out.println(
                                    "Cell phone number is incorrectly formatted."
                            );

                            continue;
                        }

                        System.out.println(
                                "Cell phone number successfully captured."
                        );

                        if(!msg.checkMessageLength()){

                            int excess =
                                    text.length() - 250;

                            System.out.println(
                                    "Message exceeds 250 characters by "
                                            +
                                            excess
                                            + "; please reduce the size." 
                            );

                            continue;
                        }

                        System.out.println(
                                "Message ready to send."
                        );

                        System.out.println(
                                "\n1) Send Message"
                        );

                        System.out.println(
                                "2) Discard Message"
                        );

                        System.out.println(
                                "3) Store Message"
                        );

                        System.out.print(
                                "Choose action: "
                        );

                        int action =
                                scanner.nextInt();

                        scanner.nextLine();

                        String result =
                                msg.sentMessage(
                                        action
                                );

                        System.out.println(result);

                        // Sent
                        if(action == 1){

                            messages.add(msg);

                            saveToJSON(msg);

                            displayDetails(msg);
                        }

                        // Stored
                        else if(action == 3){

                            messages.add(msg);

                            saveToJSON(msg);

                            displayDetails(msg);
                        }

                        // Discarded
                        else if(action == 2){

                            System.out.println(
                                    "Message deleted and not saved."
                            );
                        }
                    }

                    System.out.println(
                            "\nTotal messages sent: "
                            +
                            Message.returnTotalMessages()
                    );

                    break;

                case 2:

                    showMessages();

                    break;

                case 3:

                    System.out.println(
                            "Exiting QuickChat. Goodbye!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid option."
                    );
            }

        } while(choice != 3);

        scanner.close();
    }

    // Display details
    public static void displayDetails(
            Message msg){

        System.out.println(
                "\n--- Message Details ---"
        );

        System.out.println(
                "Message ID: "
                + msg.getMessageID()
        );

        System.out.println(
                "Message Hash: "
                + msg.getMessageHash()
        );

        System.out.println(
                "Recipient: "
                + msg.getRecipientCell()
        );

        System.out.println(
                "Message: "
                + msg.getMessageText()
        );
    }

    // Save to JSON
    public static void saveToJSON(
            Message msg){

        try{

            FileWriter writer =
                    new FileWriter(
                            "messages.json",
                            true
                    );

            writer.write(
                    msg.toJSON()
            );

            writer.write(
                    System.lineSeparator()
            );

            writer.close();

        }catch(IOException e){

            System.out.println(
                    "Error saving message."
            );
        }
    }

    // View messages
    public static void showMessages(){

        if(messages.isEmpty()){

            System.out.println(
                    "No messages available."
            );

            return;
        }

        for(Message msg : messages){

            System.out.println();
            System.out.println(
                    "Message ID: "
                    + msg.getMessageID()
            );

            System.out.println(
                    "Recipient: "
                    + msg.getRecipientCell()
            );

            System.out.println(
                    "Message: "
                    + msg.getMessageText()
            );

            System.out.println(
                    "Hash: "
                    + msg.getMessageHash()
            );

            System.out.println(
                    "----------------------"
            );
        }
    }
}
