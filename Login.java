/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chatapppoe.auth;

import java.util.regex.Pattern;

public class Login {
    String registeredUsername;
    String registeredPassword;
    String registeredCellNumber; 
    
    // Check username format
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }
    // References for REGEX
// DevGex. 2025. Comprehensive Guide to Password Validation with Java Regular Expressions. Available at:https://devgex.com/en/article/00036728
    //geeksfoegeeks. 2025. Validate Phone Numbers ( with Country Code extension) using Regular Expression. Available: https://www.geeksforgeeks.org/dsa/validate-phone-numbers-with-country-code-extension-using-regular-expression/
    // https://www.geeksforgeeks.org/dsa/validate-phone-numbers-with-country-code-extension-using-regular-expression/
    
    // Check password complexity
    public boolean checkPasswordComplexity(String password) {
    boolean hasUppercase = password.matches(".*[A-Z].*");
    boolean hasDigit = password.matches(".*\\d.*");
    boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*"); // accepts any special character
    return password.length() >= 8 && hasUppercase && hasDigit && hasSpecial;
}

    // Check cell phone number format
    public boolean checkCellPhoneNumber(String cellNumber) {
        String regex = "^\\+27\\d{9}$"; // South African format
        return Pattern.matches(regex, cellNumber);
    }

    // Register user
    public String registerUser(String username, String password, String cellNumber) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cellNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code; please correct the number and try again.";
        }

        this.registeredUsername = username;
        this.registeredPassword = password;
        this.registeredCellNumber = cellNumber;
        return "Registration successful! Username, password, and cell number captured.";
    }

    // Login verification
    public boolean loginUser(String username, String password) {
        return username.equals(registeredUsername) && password.equals(registeredPassword);
    }

    // Return login status message
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + registeredUsername + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}

