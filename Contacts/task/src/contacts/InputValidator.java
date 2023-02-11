package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    public static boolean validateNumber(String number) {
       String phoneRegRule = "^(\\+\\w{0,2}\\s)?\\(?\\w{3}\\)?[\\s.-]\\w{3}[\\s.-]\\w{3}[\\s.-]\\w{3,4}$";
        Pattern javaPattern = Pattern.compile(phoneRegRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(number);
        return (matcher.find());

    }

    public static boolean validateDate(String date) {
        String dateRule = "^\\s*(3[01]|[12][0-9]|0?[1-9])\\.(1[012]|0?[1-9])\\.((?:19|20)\\d{2})\\s*$";
        Pattern javaPattern = Pattern.compile(dateRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(date);
        return (matcher.find());
    }

    public static boolean validateGender(String gender){

        String genderRUle = "\\b(M|F)\\b";
        Pattern javaPattern = Pattern.compile(genderRUle, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(gender);
        return (matcher.find());

    }

}
