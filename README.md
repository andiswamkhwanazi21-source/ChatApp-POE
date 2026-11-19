# ChatApp-POE

## Student Information

- *Student Name:* Andiswa Masihle Mkhwanazi
- *Student Number:* ST10123717
- *Module:* Programming 1A
- *Qualification:* Bachelor of Information Technology in Business Systems
- *Institution:* Rosebank International University College
- *Project:* POE Part 1, Part 2 and Part 3

  # QuickChat Messaging Application

## Project Overview

QuickChat is a Java-based messaging application developed as part of a Programming of Event (PoE) project. The application allows users to send, store, discard, search, and manage text messages through a menu-driven console interface.

The project was developed in three phases, with each phase introducing additional functionality and complexity. The final system supports message validation, message storage, JSON data processing, reporting, searching, deletion, and automated testing using JUnit.


# Project Objectives

The objectives of this project were to:

- Develop a Java messaging application using Object-Oriented Programming principles.
- Create and validate user-generated messages.
- Generate unique message IDs and hashes.
- Store and manage messages effectively.
- Read and process message data from JSON files.
- Implement search and reporting functionality.
- Develop automated test cases using JUnit.
- Apply software development best practices using GitHub for version control.


# Part 1: User Registration and Login

## Overview

Part 1 focused on creating the authentication system for QuickChat. Users were required to register and log in before accessing the application.

## Objectives

- Implement user registration.
- Validate usernames according to requirements.
- Validate passwords for complexity.
- Authenticate users during login.
- Display login status messages.

## Features Implemented

### Username Validation

Usernames were validated to ensure:

- An underscore (_) is included.
- Character length requirements are met.

### Password Validation

Passwords had to contain:

- At least 8 characters.
- One uppercase letter.
- One number.
- One special character.

### User Registration

Users could register by entering:

- Username
- Password
- Personal details

### Login Functionality

The system verifies:

- Username correctness
- Password correctness

Successful users are granted access to QuickChat.



# Part 2: Message Creation and Processing

## Overview

Part 2 focused on adding messaging functionality to the application.

## Objectives

- Create messages.
- Validate recipient phone numbers.
- Validate message length.
- Generate unique message IDs.
- Generate message hashes.
- Allow message sending, storing, and discarding.

## Features Implemented

### Message ID Generation

Each message is assigned a unique random 10-digit message ID.

Example:

text
5487632910


### Recipient Validation

Supported formats:

text
+27834557896
0838884567


Validation is performed using Regular Expressions (Regex).

### Message Length Validation

Messages:

- Must not exceed 250 characters.
- Return validation errors when the limit is exceeded.

### Message Hash Generation

The hash is generated using:

- First two digits of the message ID.
- Message count.
- First word of the message.
- Last word of the message.

Example:

text
54:1:HELLOWORLD


### Message Actions

Users can:

1. Send Message
2. Discard Message
3. Store Message

The system tracks messages accordingly.


# Part 3: Advanced Message Management

## Overview

Part 3 extended the functionality of QuickChat by introducing JSON file processing, message searching, reporting, and deletion functionality.

## Objectives

- Read messages from JSON files.
- Store message data in arrays.
- Search for messages.
- Generate reports.
- Delete messages.
- Improve data persistence.

## Features Implemented

### JSON File Processing

The application reads stored messages from:

text
stored_messages.json


If the file is unavailable, default test data is automatically loaded.

### Message Storage Using ArrayLists

The following ArrayLists are used:

java
sentMessages
storedMessages
disregardedMessages
messageHashList
messageIDList
recipientList


### Feature A: Display Recipients and Messages

Displays all stored messages together with recipient numbers.

Example:

text
Recipient: +27834557896
Message: Did you get the cake?


### Feature B: Display Longest Message

Returns the longest stored message available.

Example:

text
Where are you? You are late! I have asked you to be on time.


### Feature C: Search by Message ID

Allows searching for a message using its unique message ID.

Example:

text
MID004


Output:

text
Recipient: 0838884567
Message: It is dinner time !


### Feature D: Search by Recipient

Displays all messages associated with a particular recipient.

Example:

text
+27838884567


Output:

text
Where are you? You are late! I have asked you to be on time.
Ok, I am leaving without you.


### Feature E: Delete by Message Hash

Allows messages to be removed using a specific hash value.

Example:

text
HASH5678


Output:

text
Message successfully deleted.


### Feature F: Display Full Report

Generates a report containing:

- Message Hash
- Recipient Number
- Message Content

Example:

text
Hash: HASH1234
Recipient: +27834557896
Message: Did you get the cake?


# Project Structure

text
QuickChat
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── za
│   │   │       └── ac
│   │   │           └── quickchat
│   │   │               ├── Message.java
│   │   │               └── QuickChat.java
│   │   │
│   │   └── resources
│   │       └── stored_messages.json
│   │
│   └── test
│       └── java
│           └── za
│               └── ac
│                   └── quickchat
│                       └── MessageTest.java
│
├── README.md
└── pom.xml



# Classes Description

## Message.java

Responsible for:

- Message creation
- Message validation
- Message ID generation
- Message hash generation
- Message storage
- JSON file reading
- Searching functionality
- Reporting functionality
- Message deletion

## QuickChat.java

Responsible for:

- Displaying menus
- User interaction
- Application navigation
- Calling message methods

## MessageTest.java

Responsible for:

- Automated testing
- Verifying application functionality
- Ensuring expected outputs are generated


#Testing

The application is tested using *JUnit 5*.

## Test Cases

### testSentMessagesPopulated()

Verifies that sent messages are correctly stored.

### testDisplayLongestMessage()

Verifies the longest stored message is returned.

### testSearchByMessageID()

Verifies searching using a Message ID.

### testSearchByRecipient()

Verifies recipient-based searches.

### testDeleteMessageByHash()

Verifies message deletion functionality.

### testDisplayReport()

Verifies report generation.

## Expected Result

text
Tests Run: 6
Tests Passed: 6
Tests Failed: 0



# JSON Implementation

## Sample JSON Structure

json
[
  {
    "messageID": "MID001",
    "recipient": "+27834557896",
    "message": "Did you get the cake?",
    "flag": "Sent",
    "messageHash": "MI1:1:DIDCAKE"
  }
]


## Purpose of JSON

The JSON file is used to:

- Store message data.
- Simulate persistent storage.
- Load data into arrays.
- Support searching and reporting functionality.



# Challenges Experienced

## Part 1 Challenges

### Username Validation

*Challenge:*
Ensuring usernames met all required validation rules.

*Solution:*
Implemented validation checks before registration.

### Password Complexity Validation

*Challenge:*
Checking multiple password requirements simultaneously.

*Solution:*
Used conditional validation logic to verify all requirements.



## Part 2 Challenges

### Message Hash Generation

*Challenge:*
Creating unique and meaningful message hashes.

*Solution:*
Combined message ID values, message count, and message content.

### Recipient Validation

*Challenge:*
Supporting local and international phone number formats.

*Solution:*
Used Regular Expressions (Regex).

### Message Length Validation

*Challenge:*
Preventing oversized messages.

*Solution:*
Added character count validation before processing.



## Part 3 Challenges

### JSON File Processing

*Challenge:*
Reading JSON data without external libraries.

*Solution:*
Created a custom JSON parser using Java file handling techniques.

### ArrayList Synchronization

*Challenge:*
Keeping message data aligned across multiple ArrayLists.

*Solution:*
Ensured all additions and deletions occur at matching indexes.

### Message Deletion

*Challenge:*
Deleting records without breaking data consistency.

*Solution:*
Removed corresponding entries from all related ArrayLists.

### JUnit Testing

*Challenge:*
Testing methods with dynamic data.

*Solution:*
Inserted controlled test data before each test execution.



# Technologies Used

- Java
- NetBeans IDE
- JUnit 5
- JSON
- GitHub
- Object-Oriented Programming (OOP)



# Time of Completion

| Project Phase | Estimated Time |
|--------------|---------------|
| Part 1 | 8 Hours |
| Part 2 | 12 Hours |
| Part 3 | 15 Hours |
| Testing & Debugging | 6 Hours |
| Documentation | 3 Hours |

*Total Estimated Development Time: 44 Hours*


# GitHub Repository

Repository Link:

```text
https://github.com/andiswamkhwanazi21-source/ChatApp-POE.git 
```
# Conclusion

The QuickChat project successfully demonstrates the implementation of a Java-based messaging application developed over three progressive phases. The application incorporates authentication, messaging, data validation, JSON file processing, reporting, searching, deletion functionality, and automated testing.

Through this project, skills in Java programming, Object-Oriented Programming, file handling, data structures, software testing, debugging, and GitHub version control were strengthened while developing a practical messaging management solution.
