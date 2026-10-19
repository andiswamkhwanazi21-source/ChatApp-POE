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

        Message msg =
                new Message(
                        "+27718693002",
                        "Hi Mike, can you join us for dinner tonight?"
                );

        assertTrue(
                msg.checkMessageLength()
        );
    }

    @Test
    public void testCheckMessageLengthFail() {

        String longMessage =
                "A".repeat(260);
                        

        Message msg =
                new Message(
                        "+27718693002",
                        longMessage
                );

        assertFalse(
                msg.checkMessageLength()
        );
    }

    @Test
    public void testRecipientSuccess() {

        Message msg =
                new Message(
                        "+27718693002",
                        "Hello"
                );

        assertTrue(
                msg.checkRecipientCell()
        );
    }

    @Test
    public void testRecipientFailureNoPlus() {

        Message msg =
                new Message(
                        "27718693002",
                        "Hello"
                );

        assertFalse(
                msg.checkRecipientCell()
        );
    }

    @Test
    public void testRecipientFailureLetters() {

        Message msg =
                new Message(
                        "+27ABC12345",
                        "Hello"
                );

        assertFalse(
                msg.checkRecipientCell()
        );
    }

    @Test
    public void testMessageIDLength() {

        Message msg =
                new Message(
                        "+27718693002",
                        "Hello"
                );

        assertTrue(
                msg.checkMessageID()
        );
    }

    @Test
    public void testHashCreation() {

        Message msg =
                new Message(
                        "+27718693002",
                        "Hi Mike tonight"
                );

        String hash =
                msg.createMessageHash();

        assertNotNull(hash);

        assertTrue(
                hash.contains(":")
        );
    }

    @Test
    public void testHashEmptyMessage() {

        Message msg =
                new Message(
                        "+27718693002",
                        ""
                );

        assertEquals(
                "",
                msg.createMessageHash()
        );
    }

    @Test
    public void testSendMessage() {

        Message msg =
                new Message(
                        "+27718693002",
                        "Test"
                );

        assertEquals(
                "Message successfully sent.",
                msg.sentMessage(1)
        );
    }

    @Test
    public void testDiscardMessage() {

        Message msg =
                new Message(
                        "+27718693002",
                        "Test"
                );

        assertEquals(
                "Message discarded.",
                msg.sentMessage(2)
        );
    }

    @Test
    public void testStoreMessage() {

        Message msg =
                new Message(
                        "+27718693002",
                        "Test"
                );

        assertEquals(
                "Message successfully stored.",
                msg.sentMessage(3)
        );
    }

    @Test
    public void testMessageCounter() {

        Message msg =
                new Message(
                        "+27718693002",
                        "Counter Test"
                );

        int before =
                Message.returnTotalMessages();

        msg.sentMessage(1);

        int after =
                Message.returnTotalMessages();

        assertEquals(
                before + 1,
                after
        );
    }

    @Test
    public void testJSONCreation() {

        Message msg =
                new Message(
                        "+27718693002",
                        "Hello"
                );

        String json =
                msg.toJSON();

        assertTrue(
                json.contains("messageID")
        );

        assertTrue(
                json.contains("recipient")
        );
    }
}



