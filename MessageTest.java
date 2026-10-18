/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package za.ac.quickchat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Silungile
 */




public class MessageTest {

    @Test
    public void testCheckMessageLengthSuccess() {
        Message msg = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertTrue(msg.checkMessageLength());
    }

    @Test
    public void testCheckRecipientCellSuccess() {
        Message msg = new Message("+27718693002", "Test message");
        assertTrue(msg.checkRecipientCell());
    }

    @Test
    public void testCheckRecipientCellFailure() {
        Message msg = new Message("08575975889", "Hi Keegan, did you receive the paymrnt?"); // Missing '+' international code
        assertFalse(msg.checkRecipientCell());
    }

    @Test
    public void testMessageHashCreation() {
        Message msg = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?");
        // Expected format based on test data: First two numbers of ID, colon, message count, colon, first and last words in caps
        String hash = msg.createMessageHash();
        assertNotNull(hash);
        assertTrue(hash.contains(":"));
        assertTrue(hash.endsWith("TONIGHT"));
    }

    @Test
    public void testSentMessageOptions() {
        Message msg = new Message("+27718693002", "Test");
        assertEquals("Message successfully sent.", msg.sentMessage(1));
        assertEquals("Press 0 to delete the message.", msg.sentMessage(2));
        assertEquals("Message successfully stored.", msg.sentMessage(3));
    }
}

    
    
