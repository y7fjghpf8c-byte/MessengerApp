/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import Login.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
        


/**
 *
 * @author Makalabate Rampedi
 */
public class LoginTest {

    // Username Correctly Formatted
    @Test
    public void testUserNameCorrectlyFormatted() {

        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976");

        assertTrue(login.checkUserName());
    }

    // Username Incorrectly Formatted
    @Test
    public void testUserNameIncorrectlyFormatted() {

        Login login = new Login(
                "Kyle",
                "Smith",
                "kyle!!!!!!!",
                "Ch&&sec@ke99!",
                "+27838968976");

        assertFalse(login.checkUserName());
    }

    // Password Meets Complexity
    @Test
    public void testPasswordMeetsComplexity() {

        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976");

        assertTrue(login.checkPasswordComplexity());
    }

    // Password Does Not Meet Complexity
    @Test
    public void testPasswordDoesNotMeetComplexity() {

        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "password",
                "+27838968976");

        assertFalse(login.checkPasswordComplexity());
    }

    // Cell Number Correct
    @Test
    public void testCellPhoneNumberCorrectlyFormatted() {

        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976");

        assertTrue(login.checkCellPhoneNumber());
    }

    // Cell Number Incorrect
    @Test
    public void testCellPhoneNumberIncorrectlyFormatted() {

        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "08966553");

        assertFalse(login.checkCellPhoneNumber());
    }

    // Login Successful
    @Test
    public void testLoginSuccessful() {

        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976");

        assertTrue(
                login.loginUser(
                        "kyl_1",
                        "Ch&&sec@ke99!")
        );
    }

    // Login Failed
    @Test
    public void testLoginFailed() {

        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976");

        assertFalse(
                login.loginUser(
                        "wrongUser",
                        "wrongPassword")
        );
    }

    // Registration Success
    @Test
    public void testRegisterUser() {

        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976");

        assertEquals(
                "User successfully registered.",
                login.registerUser());
    }

    // Successful Login Message
    @Test
    public void testReturnLoginStatusSuccess() {

        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976");

        assertEquals(
                "Welcome Kyle Smith, it is great to see you again.",
                login.returnLoginStatus(
                        "kyl_1",
                        "Ch&&sec@ke99!")
        );
    }

    // Failed Login Message
    @Test
    public void testReturnLoginStatusFailed() {

        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976");

        assertEquals(
                "Username or password incorrect, please try again.",
                login.returnLoginStatus(
                        "wrongUser",
                        "wrongPassword")
        );
    }
}