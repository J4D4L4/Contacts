import static org.junit.jupiter.api.Assertions.*;

import contacts.InputValidator;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void testValidateNumber() {
        assertTrue(InputValidator.validateNumber("+1 (123) 123-123-1234"));
        assertTrue(InputValidator.validateNumber("+44 123 123 123 1234"));
        assertTrue(InputValidator.validateNumber("123 123 123 1234"));
        assertFalse(InputValidator.validateNumber("1231 23 1234"));
        assertFalse(InputValidator.validateNumber("123 123 123"));
    }

    @Test
    void testValidateDate() {
        assertTrue(InputValidator.validateDate("31.12.1999"));
        assertTrue(InputValidator.validateDate("1.1.2000"));
        assertTrue(InputValidator.validateDate("1.01.2000"));
        assertFalse(InputValidator.validateDate("31.13.1999"));
        assertFalse(InputValidator.validateDate("31.12.99"));
    }

    @Test
    void testValidateGender() {
        assertTrue(InputValidator.validateGender("M"));
        assertTrue(InputValidator.validateGender("F"));
        assertFalse(InputValidator.validateGender("Male"));
        assertFalse(InputValidator.validateGender("Female"));
    }

}
