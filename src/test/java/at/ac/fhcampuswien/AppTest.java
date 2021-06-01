package at.ac.fhcampuswien;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test // To check whether it has a correct length, between 8 and 25 characters.
    @DisplayName("Has password valid length.")
    public void testValidLength() {
        assertEquals(true, App.checkPassword.isValid("Abc1245!659csg"));
    }

    @Test // To check whether it is too short.
    @DisplayName("Too short password length.")
    public void testTooShort() {
        assertEquals(false, App.checkPassword.isValid("Abc1"));
    }

    @Test // To check whether it is too long.
    @DisplayName("Too long password length.")
    public void testTooLong() {
        assertEquals(false,App.checkPassword.isValid("Abc12!45@()?67%89#091!/2@def"));
    }

    @Test // To check whether is has any digit or not.
    @DisplayName("No digit in password.")
    public void testNoDigit() {
        assertEquals(true, App.checkPassword.isValid("CrazY125!%"));
    }

    @Test // To check whether the password include both small and big letters.
    @DisplayName("No small or big characters in password.")
    public void testSmallBigChar() {
        assertEquals(true,App.checkPassword.isValid("Abcdefghi"));
    }

    @Test // To ensure there are no other special characters except those requested.
    @DisplayName("No extra special symbols in password.")
    public void testNoExtraSpecial() {
        assertEquals(true, App.checkPassword.isValid("Abc123+=]"));
    }

    @Test // To check whether the password has consecutive numbers or not, such as "111"
    @DisplayName("No identical consecutive numbers in password.")
    public void testNoIdentical() {
        assertEquals(false, App.checkPassword.isValid("1111"));
    }

}