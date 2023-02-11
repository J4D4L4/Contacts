import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import contacts.Person;
import contacts.PersonCreationCommand;
import contacts.PersonDAO;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class PersonCreationCommandTest {
    private PersonCreationCommand personCreationCommand;
    private PersonDAO personDAO;

    @Before
    public void setUp() {
        personCreationCommand = new PersonCreationCommand();
        personDAO = mock(PersonDAO.class);

    }


    @Test
    public void testCreatePerson() {
        String name = "John";
        String surname = "Doe";
        String number = "1234567890";

        Person person = personCreationCommand.createPerson(name, surname, number);

        assertEquals(person.getName(), name);
        assertEquals(person.getSurname(), surname);
        assertEquals(person.getNumber(), number);
    }

}
