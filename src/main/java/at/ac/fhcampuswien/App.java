package at.ac.fhcampuswien;
import java.util.regex.Pattern;

public class App {

    private final static int MIN_PW_LENGTH = 8;
    private final static int MAX_PW_LENGTH = 25;
    /**
     * REFERENCE: http://www.luv2code.com/category/test-driven-development/page/2/ || https://users.csc.calpoly.edu/~djanzen/courses/405W13/presentations/tdd.pdf
     */
    private final static String VALID_SPECIAL_STRING = "(?=.*[()#$?!%/@])";
    private final static String VALID_BIG_SMALL_CHAR = "((?=.*[A-Z])(?=.*[a-z]))";

    public static class checkPassword {

        private static boolean isValidLength(String password) {
            return password.length() >= MIN_PW_LENGTH && password.length() <= MAX_PW_LENGTH;
        }

        private static boolean containsDigit(String password) {
            return Pattern.matches((".*\\p{Digit}.*"), password);
        }

        private static boolean noExtraSpecial(String password) {
            return Pattern.matches(VALID_SPECIAL_STRING, password);
        }

        private static boolean containsSmallBig(String password) {
            return Pattern.matches(VALID_BIG_SMALL_CHAR, password);
        }


        public static boolean isValid(String password) {
            return isValidLength(password) && containsDigit(password) && noExtraSpecial(password) && containsSmallBig(password);
        }

    }
}