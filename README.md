# ChatApp-POE

## Student Information

- *Student Name:* Andiswa Masihle Mkhwanazi
- *Student Number:* ST10123717
- *Module:* Programming 1A
- *Qualification:* Bachelor of Information Technology in Business Systems
- *Institution:* Rosebank International University College
- *Assignment:* POE Part 1 and Part 2

  

# Project Overview

ChatApp-POE is a Java-based console messaging application developed as part of the Programming 1A Portfolio of Evidence (POE).

The project was implemented in two phases:

### Part 1
Focused on:
- User registration
- Username validation
- Password validation
- User login
- Login verification

### Part 2
Expanded the project by introducing:
- Message creation
- Message validation
- Automated Message ID generation
- Message hashing
- Message storage
- Message tracking
- Message statistics
- QuickChat functionality
- Unit testing

The application simulates the basic functionality of a modern messaging platform while applying Object-Oriented Programming principles and software development best practices.


# Project Objectives

The main objectives of this project were:

- Apply Object-Oriented Programming concepts.
- Design reusable classes and methods.
- Implement secure user authentication.
- Validate user inputs using predefined rules.
- Generate and manage message data.
- Practice software testing through unit tests.
- Use GitHub for version control and project documentation.


# Features

## User Registration

The application allows users to:

- Create an account.
- Enter a username.
- Create a secure password.
- Verify registration requirements.

### Username Requirements

- Must contain an underscore (_)
- Must not exceed 5 characters

### Password Requirements

- Minimum length requirement
- At least one capital letter
- At least one special character
- At least one number


## User Login

Users can:

- Log into the application.
- Verify credentials.
- Receive login success and failure messages.


## QuickChat Functionality

The QuickChat component provides:

- Message creation
- Message management
- Message validation
- Message tracking
- Message storage

Users can:

- Send messages
- View sent messages
- View total messages sent
- Exit the application when desired


## Message Functionality

The Message class is responsible for:

- Creating messages
- Generating unique Message IDs
- Validating message length
- Generating Message Hashes
- Tracking recipients
- Storing message information

### Message Rules

- Messages may not exceed 250 characters.
- Recipients are validated before processing.
- Messages receive a unique identifier.
- Message hashes are generated automatically.


# Project Structure

text
ChatApp-POE
│
├── ChatAppPOE.java
├── Login.java
├── LoginTest.java
├── Message.java
├── MessageTest.java
├── QuickChat.java
├── README.md


### File Descriptions

#### ChatAppPOE.java
Main application entry point.

#### Login.java
Handles:
- Registration
- Username validation
- Password validation
- Login verification

#### LoginTest.java
Contains unit tests for:
- Username validation
- Password validation
- Login functionality

#### Message.java
Handles:
- Message creation
- Message validation
- Message hashing
- Message IDs

#### MessageTest.java
Provides test cases for:
- Message validation
- Message IDs
- Message hashing
- Message storage

#### QuickChat.java
Provides the QuickChat menu system and message processing functionality.


# Technologies Used

- Java
- Object-Oriented Programming (OOP)
- JUnit Testing
- NetBeans IDE
- GitHub


# Concepts Applied

The following programming concepts were applied:

- Classes and Objects
- Methods
- Constructors
- Arrays
- String Manipulation
- Encapsulation
- Validation Techniques
- Conditional Statements
- Loops
- Unit Testing
- Exception Handling


# Testing

Testing was performed to ensure all application functionality worked correctly.

## Login Testing

Tested:
- Valid usernames
- Invalid usernames
- Valid passwords
- Invalid passwords
- Login success scenarios
- Login failure scenarios

## Message Testing

Tested:
- Message length validation
- Recipient validation
- Hash generation
- Message ID creation
- Message storage functionality


# Challenges Experienced

## Part 1 Challenges

### Username Validation

One challenge was ensuring usernames correctly met the system requirements while providing meaningful feedback to the user.

### Password Complexity Checks

Implementing password validation required multiple conditions to be checked simultaneously while maintaining code readability.

### Login Verification

Ensuring user details entered during login matched previously registered user information required careful validation logic.


## Part 2 Challenges

### Message Hash Generation

Creating unique and meaningful message hashes required careful string manipulation and testing.

### Message ID Creation

Developing a reliable method of generating unique message identifiers presented challenges during implementation and validation.

### Message Length Validation

Ensuring messages remained within the required character limit while displaying accurate validation feedback required additional testing.

### Unit Testing

Creating effective test cases using JUnit helped identify logic errors early but required a deeper understanding of testing principles.

### Program Integration

Combining Part 1 functionality with Part 2 message features while maintaining program stability was one of the most significant challenges encountered.


# Lessons Learned

Through development of this project, I improved my understanding of:

- Java programming
- Object-Oriented Programming
- Problem solving
- Debugging
- Software testing
- Version control using GitHub
- Writing technical documentation


# Timeline of Completion

| Phase | Activity | Status |
|---------|---------|---------|
| Week 1 | Project planning and requirements analysis | Completed |
| Week 1 | Create Login class | Completed |
| Week 2 | Username and password validation | Completed |
| Week 2 | Login functionality implementation | Completed |
| Week 3 | Unit testing for login functionality | Completed |
| Week 4 | Design Message class | Completed |
| Week 4 | Message ID generation | Completed |
| Week 5 | Message validation implementation | Completed |
| Week 5 | Message hash generation | Completed |
| Week 6 | QuickChat implementation | Completed |
| Week 6 | Message testing and debugging | Completed |
| Week 7 | GitHub documentation and final submission preparation | Completed |


# Future Improvements

Possible future enhancements include:

- Graphical User Interface (GUI)
- Database integration
- Encrypted password storage
- User profiles
- Contact management
- Message history retrieval
- File sharing
- Voice notes
- Real-time communication
- Mobile application integration


# GitHub Repository

Repository Link:

https://github.com/andiswamkhwanazi21-source/ChatApp-POE


# Author

*Andiswa Masihle Mkhwanazi*

Bachelor of Information Technology in Business Systems

Rosebank International University College

Programming 1A Portfolio of Evidence
