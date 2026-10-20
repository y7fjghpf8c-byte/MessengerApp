/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Message;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Makalabate Rampedi
 */
public class MessageTest {
     @BeforeEach
    public void setUp() {
        Message.resetTotalMessagesSent();
    }

    @Test
    public void testCheckMessageLengthSuccess() {

        Message msg = new Message(
                "+27718693002",
                "Hi Mike, can you join us for dinner tonight?"
        );

        assertEquals(
                "Message ready to send.",
                msg.checkMessageLength()
        );
    }

    @Test
    public void testCheckMessageLengthFailure() {

        StringBuilder longText = new StringBuilder();

        for (int i = 0; i < 260; i++) {
            longText.append("a");
        }

        Message msg = new Message(
                "+27718693002",
                longText.toString()
        );

        assertEquals(
                "Message exceeds 250 characters by 10; please reduce the size.",
                msg.checkMessageLength()
        );
    }

    @Test
    public void testCheckRecipientCellSuccess() {

        Message msg = new Message(
                "+27718693002",
                "Hi Mike, can you join us for dinner tonight?"
        );

        assertEquals(
                "Cell phone number successfully captured.",
                msg.checkRecipientCell()
        );
    }

    @Test
    public void testCheckRecipientCellFailure() {

        Message msg = new Message(
                "08575975889",
                "Hi Keegan, did you receive the payment?"
        );

        assertEquals(
                "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
                msg.checkRecipientCell()
        );
    }

    @Test
    public void testCreateMessageHash() {

        Message msg = new Message(
                "0012345678",
                "+27718693002",
                "HI TONIGHT",
                0
        );

        assertEquals(
                "00:0:HITONIGHT",
                msg.createMessageHash()
        );
    }

    @Test
    public void testCheckMessageID() {

        Message msg = new Message(
                "+27718693002",
                "Test message"
        );

        assertTrue(msg.checkMessageID());
        assertEquals(10, msg.getMessageID().length());
    }

    @Test
    public void testSentMessageOptions() {

        Message msg = new Message(
                "+27718693002",
                "Test message"
        );

        assertEquals(
                "Message successfully sent.",
                msg.SentMessage(1)
        );

        assertEquals(
                "Press 0 to delete the message.",
                msg.SentMessage(2)
        );

        assertEquals(
                "Message successfully stored.",
                msg.SentMessage(3)
        );
    }
}
