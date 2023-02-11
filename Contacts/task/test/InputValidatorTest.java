import contacts.InputValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputValidatorTest {
    java.util.logging.Logger logger =  java.util.logging.Logger.getLogger(this.getClass().getName());
    @Test
    public void validateNumberTest(){

        String [] numbers = {"+0 (123) 456-789-ABcd", "(123) 234 345-456"};
        List<String> goodNumbers = Arrays.asList(numbers);

        for (int goodNumberNr = 0; goodNumberNr < goodNumbers.size(); goodNumberNr++){

            logger.info(goodNumbers.get(goodNumberNr)+": "+InputValidator.validateNumber(goodNumbers.get(goodNumberNr)));
            Assertions.assertEquals(true, InputValidator.validateNumber(goodNumbers.get(goodNumberNr)));

        }



    }

    @Test
    public void validateBadNumberTest(){

        String [] numbers = {"+0(123)456-789-9999", "()()"};
        List<String> badNumbers = Arrays.asList(numbers);

        for (int badNumberNr = 0; badNumberNr < badNumbers.size(); badNumberNr++){

            logger.info(badNumbers.get(badNumberNr)+": "+InputValidator.validateNumber(badNumbers.get(badNumberNr)));
            Assertions.assertEquals(false, InputValidator.validateNumber(badNumbers.get(badNumberNr)));

        }



    }

}
