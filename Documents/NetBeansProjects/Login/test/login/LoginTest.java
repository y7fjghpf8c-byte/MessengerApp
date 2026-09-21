/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ogin;

import login.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
        


/**
 *
 * @author Makalabate Rampedi
 */
public class LoginTest {
    

    
@Test
    public void testCheckUsernameTrue() {
        Login user = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99l", "+27838968976");
        assertTrue(user.checkUsername());
    }

    @Test
    public void testCheckUsernameFalse() {
        Login user = new Login("Kyle", "Smith", "kyle!!!!!!!", "Ch&&sec@ke99l", "+27838968976");
        assertFalse(user.checkUsername());
    }

    @Test
    public void testCheckPasswordComplexityTrue() {
        Login user = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99l", "+27838968976");
        assertTrue(user.checkPasswordComplexity("Ch&&sec@ke99l"));
    }

    @Test
    public void testCheckPasswordComplexityFalse() {
        Login user = new Login("Kyle", "Smith", "kyl_1", "password", "+27838968976");
        assertFalse(user.checkPasswordComplexity("password"));
    }

    @Test
    public void testCheckCellPhoneNumberTrue() {
        Login user = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99l", "+27838968976");
        assertTrue(user.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCheckCellPhoneNumberFalse() {
        Login user = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99l", "08966553");
        assertFalse(user.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testLoginUserTrue() {
        Login user = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99l", "+27838968976");
        assertTrue(user.loginUser("kyl_1", "Ch&&sec@ke99l"));
    }

    @Test
    public void testLoginUserFalse() {
        Login user = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99l", "+27838968976");
        assertFalse(user.loginUser("wrong", "password"));
    }
    
    @Test
    public void testRegisterUserSuccess() {
        Login user = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99l", "+27838968976");
        assertEquals("User registered successfully!", user.registerUser());
    }

    @Test
    public void testRegisterUserFailUsername() {
        Login user = new Login("Kyle", "Smith", "kyle!!!!!!!", "Ch&&sec@ke99l", "+27838968976");
        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.", user.registerUser());
    }

    @Test
    public void testRegisterUserFailPassword() {
        Login user = new Login("Kyle", "Smith", "kyl_1", "password", "+27838968976");
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", user.registerUser());
    }

    @Test
    public void testRegisterUserFailCellphone() {
        Login user = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99l", "08966553");
        assertEquals("Cell phone number incorrectly formatted or does not contain international code.", user.registerUser());
    }

    @Test
    public void testReturnLoginStatusSuccess() {
        Login user = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99l", "+27838968976");
        assertEquals("Welcome Kyle Smith, it is great to see you again.", user.returnLoginStatus(true));
    }

    @Test
    public void testReturnLoginStatusFail() {
        Login user = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99l", "+27838968976");
        assertEquals("Username or password incorrect, please try again.", user.returnLoginStatus(false));
    }


 
    
    
}
