
package qana;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testCheckUserName() {

        Login login = new Login();

        boolean result = login.checkUserName("ab_cd");

        assertTrue(result);
    }

    @Test
    public void testCheckPasswordComplexity() {

        Login login = new Login();

        boolean result =
                login.checkPasswordComplexity("Password1@");

        assertTrue(result);
    }

    @Test
    public void testCheckCellPhoneNumber() {

        Login login = new Login();

        boolean result =
                login.checkCellPhoneNumber("+27831234567");

        assertTrue(result);
    }

    @Test
    public void testLoginUser() {

        Login login = new Login();

        login.setUserDetails(
                "Ryan",
                "Naidoo",
                "ab_cd",
                "Password1@"
        );

        boolean result =
                login.loginUser("ab_cd", "Password1@");

        assertTrue(result);
    }

    @Test
    public void testCheckMessageLength() {

        Message message = new Message();

        String result =
                message.checkMessageLength(
                        "Hello this is a test message"
                );

        assertEquals(
                "Message ready to send.",
                result
        );
    }

    @Test
    public void testCheckRecipientCell() {

        Message message = new Message();

        String result =
                message.checkRecipientCell(
                        "+27831234567"
                );

        assertEquals(
                "Cell phone number successfully captured.",
                result
        );
    }

    @Test
    public void testCreateMessageHash() {

        Message message = new Message();

        message.setMessageData(
                1,
                "+27831234567",
                "Hello Mike"
        );

        String hash = message.createMessageHash();

        assertNotNull(hash);
    }

    @Test
    public void testSentMessage() {

        Message message = new Message();

        String result = message.sentMessage(1);

        assertEquals(
                "Message successfully sent.",
                result
        );
    }
}