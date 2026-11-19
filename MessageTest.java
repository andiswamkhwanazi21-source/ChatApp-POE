/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package za.ac.quickchat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testSentMessagesPopulated() {
        Message.sentMessages.clear();
        Message.sentMessages.add("Did you get the cake?");
        Message.sentMessages.add("It is dinner time !");
        
        assertTrue(Message.sentMessages.contains("Did you get the cake?"));
        assertTrue(Message.sentMessages.contains("It is dinner time !"));
    }

    @Test
    public void testDisplayLongestMessage() {
        Message.storedMessages.clear();
        Message.storedMessages.add("Short msg");
        Message.storedMessages.add("Where are you? You are late! I have asked you to be on time.");
        
        String longest = Message.displayLongestMessage();
        assertEquals("Where are you? You are late! I have asked you to be on time.", longest);
    }

    @Test
    public void testSearchByMessageID() {
        Message.messageIDList.clear();
        Message.recipientList.clear();
        Message.sentMessages.clear();
        
        Message.messageIDList.add("MID004");
        Message.recipientList.add("0838884567");
        Message.sentMessages.add("It is dinner time !");
        
        String result = Message.searchByMessageID("MID004");
        assertTrue(result.contains("0838884567"));
    }

    @Test
    public void testSearchByRecipient() {
        Message.recipientList.clear();
        Message.storedMessages.clear();
        
        Message.recipientList.add("+27838884567");
        Message.recipientList.add("+27838884567");
        Message.storedMessages.add("Where are you? You are late! I have asked you to be on time.");
        Message.storedMessages.add("Ok, I am leaving without you.");
        
        String result = Message.searchByRecipient("+27838884567");
        assertTrue(result.contains("Where are you? You are late!"));
        assertTrue(result.contains("Ok, I am leaving without you."));
    }

    @Test
    public void testDeleteMessageByHash() {
        Message.messageHashList.clear();
        Message.storedMessages.clear();
        
        Message.messageHashList.add("HASH5678");
        Message.storedMessages.add("Where are you? You are late! I have asked you to be on time.");
        
        boolean deleted = Message.deleteByHash("HASH5678");
        assertTrue(deleted);
        assertEquals(0, Message.messageHashList.size());
    }

    @Test
    public void testDisplayReport() {
        Message.messageHashList.clear();
        Message.recipientList.clear();
        Message.storedMessages.clear();
        
        Message.messageHashList.add("HASH1234");
        Message.recipientList.add("+27834557896");
        Message.storedMessages.add("Did you get the cake?");
        
        String report = Message.displayReport();
        assertTrue(report.contains("HASH1234"));
        assertTrue(report.contains("+27834557896"));
        assertTrue(report.contains("Did you get the cake?"));
    }
}
