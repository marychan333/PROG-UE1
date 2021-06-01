package at.ac.fhcampuswien;

import java.util.regex.Pattern;
import java.util.regex.*;
import java.util.regex.Matcher;

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
            return Pattern.matches((".\\p{Digit}."), password);
        }

        private static boolean noExtraSpecial(String password) {
            return Pattern.matches(VALID_SPECIAL_STRING, password);
        }

        private static boolean containsSmallBig(String password) {
            return Pattern.matches(VALID_BIG_SMALL_CHAR, password);
        }

        private static boolean isIdentical(String password) {
            String regex = "\\b([0-90-90-9])\\1\\1+\\b";
            Pattern p = Pattern.compile(regex);

            if (password == null) {
                return false;
            }

            Matcher m = p.matcher(password);
            return m.matches();
        }

        public static boolean isValid(String password) {

            // valid length
            if (password.length() >= 8 && password.length() <= 25) {
                return true;
            }

            // no space is allowed
            if (password.contains(" ")) {
                return false;
            }

            // consecutive numbers combination is not possible
            String regex1 = "\\b([0-90-90-9])\\1\\1+\\b";
            if (password.contains(regex1)) {
                return false;
            }

            // should contains digits
            String pattern1 = "(?=.*d)";
            if (password.contains(pattern1)) {
                return true;
            }

            if (true) {
                int count = 0;
                for (int i = 0; i <= 9; i++) {
                    String str1 = Integer.toString(i);
                    if (password.contains(str1)) {
                        count = 1;
                    }
                }
                if (count == 0) {
                    return false;
                }
                if (!(password.contains("(") || password.contains(")") || password.contains("#") || password.contains("$") || password.contains("?") || password.contains("!") || password.contains("%") || password.contains("/") || password.contains("@"))) {
                    return false;
                }
                if (true) {
                    int count2 = 0;
                    for (int i = 65; i <= 90; i++) {
                        char c = (char) i;
                        String str1 = Character.toString(c);
                        if (password.contains(str1)) {
                            count2 = 1;
                        }
                    }
                    if (count2 == 0) {
                        return false;
                    }
                }
                if (true) {
                    int count3 = 0;
                    for (int i = 90; i <= 122; i++) {
                        char c = (char) i;
                        String str1 = Character.toString(c);

                        if (password.contains(str1)) {
                            count3 = 1;
                        }
                    }
                    if (count3 == 0) {
                        return false;
                    }
                }
                return false;
            }
            // if (password.length() < MIN_PW_LENGTH) return false;

            //int charCount = 0;
            //int numCount = 0;

            //for (int i = 0; i < password.length(); i++) {
            //    char ch = password.charAt(i);
            //    if (containsDigit(password)) numCount++;
            //    else if (containsSmallBig(password)) charCount++;
            //    else return false;
            //}
            //return (charCount >= 2 && numCount >= 2);

            return isValidLength(password) && containsDigit(password) && noExtraSpecial(password) && containsSmallBig(password) && isIdentical(password);

        }

        public static void main(String[] args) {

            // testing passwords with 2 examples below.
            String password1 = "CrazY125!%"; // valid password
            String password2 = "111dsa^"; // invalid password

            //if (password == null) {
            //    throw new IllegalArgumentException("password is null!");
            //}

            if(isValid(password1)) {
                System.out.println("Valid password!");
            } else {
                System.out.println("Invalid password!");
            }

            if(isValid(password2)) {
                System.out.println("Valid password!");
            } else {
                System.out.println("Invalid password!");
            }
        }
    }
}