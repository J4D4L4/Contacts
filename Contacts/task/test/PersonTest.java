import static org.junit.Assert.assertEquals;

import contacts.Person;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {

    private Person person;
    private static final String NAME = "John";
    private static final String SURNAME = "Doe";
    private static final String BIRTHDAY = "01/01/2000";
    private static final String GENDER = "Male";
    private static final String NUMBER = "1234567890";

    @BeforeEach
    public void setUp() {
        person = new Person(NAME, SURNAME, BIRTHDAY, GENDER, NUMBER);
    }

    @Test
    public void testToString() {
        assertEquals(NAME + " " + SURNAME, person.toString());
    }

    @Test
    public void testGetSurname() {
        assertEquals(SURNAME, person.getSurname());
    }

    @Test
    public void testSetSurname() {
        final String newSurname = "Smith";
        person.setSurname(newSurname);
        assertEquals(newSurname, person.getSurname());
    }

    @Test
    public void testGetBirthday() {
        assertEquals(BIRTHDAY, person.getBirthday());
    }

    @Test
    public void testSetBirthday() {
        final String newBirthday = "02/02/2002";
        person.setBirthday(newBirthday);
        assertEquals(newBirthday, person.getBirthday());
    }

    @Test
    public void testGetGender() {
        assertEquals(GENDER, person.getGender());
    }

    @Test
    public void testSetGender() {
        final String newGender = "Female";
        person.setGender(newGender);
        assertEquals(newGender, person.getGender());
    }

    @Test
    public void testAppendString() {
        assertEquals(NAME + " " + SURNAME + " " + GENDER + " " + GENDER + " " + BIRTHDAY, person.appendString());
    }
}
