/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapppoe;

/**
 *
 * @author AndiswaST10123717
 */
import com.chatapppoe.auth.Login;
import java.util.Scanner;

public class ChatAppPOE {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        System.out.println("=== Welcome to ChatApp Registration ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter South African cell phone number (+27...): ");
        String cellNumber = scanner.nextLine();

        // Register user
        String registrationMessage = login.registerUser(username, password, cellNumber);
        System.out.println(registrationMessage);

        // Login process
        System.out.println("\n=== Login ===");
        System.out.print("Enter username: ");
        String loginUser = scanner.nextLine();

        System.out.print("Enter password: ");
        String loginPass = scanner.nextLine();

        boolean loginStatus = login.loginUser(loginUser, loginPass);
        System.out.println(login.returnLoginStatus(loginStatus));
    }
}


