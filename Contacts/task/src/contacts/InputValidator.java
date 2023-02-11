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

}
