package at.ac.fhcampuswien;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test // To check whether it has a correct length, between 8 and 25 characters.
    public void testValidLength() {
        assertEquals(false, App.checkPassword.isValid("Abc1245!659csg"));
    }
    @Test // To check whether it is too short.
    public void testTooShort() {
        assertEquals(false, App.checkPassword.isValid("Abc1"));
    }
    @Test // To check whether it is too long.
    public void testTooLong() {
        assertEquals(false,App.checkPassword.isValid("Abc12!45@()?67%89#091!/2@def"));
    }
    @Test // To check whether is has any digit or not.
    public void testNoDigit() {
        assertEquals(false,App.checkPassword.isValid("Abcdefgh!"));
    }
    @Test // To check whether the password include both small and big letters.
    public void testSmallBigChar() {
        assertEquals(false,App.checkPassword.isValid("abcdefghi"));
    }

    @Test // To ensure there are no other special characters except those requested.
    public void testNoExtraSpecial() {
        assertEquals(false, App.checkPassword.isValid("Abc123+=]"));
    }

    @Test // To check whether the password has consecutive numbers or not, such as "111"
    public void testNoIdentical() {
        assertEquals(false, App.checkPassword.isValid("1111"));
    }
}