import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import contacts.Person;
import contacts.PersonDAO;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class PersonDAOTest {

    private static final String FILENAME = "PersonTest.data";
    private PersonDAO personDAO = PersonDAO.getPersonDAOInstance();

    public PersonDAOTest() throws FileNotFoundException {
    }

    @Before
    public void setUp() throws Exception {
        PersonDAO.filename = FILENAME;
        personDAO = PersonDAO.getPersonDAOInstance();
        personDAO.persons.clear();
    }

    @After
    public void tearDown() {
        File file = new File(FILENAME);
        file.delete();
    }

    @Test
    public void testGetPersonDAOInstance() throws Exception {
        assertTrue(personDAO == PersonDAO.getPersonDAOInstance());
    }

    @Test
    public void testGet() {
        Person person = new Person("John", "Doe", "2000-01-01", "M", "1234567890");
        personDAO.create(person);

        Optional<Person> result = personDAO.get(0l);
        assertTrue(result.isPresent());
        assertEquals(person.getName(), result.get().getName());
    }


    @Test
    public void testGetAll() {
        int sizeBefore = personDAO.getAll().size();
        Person person1 = new Person("John", "Doe", "2000-01-01", "M", "1234567890");
        Person person2 = new Person("Jane", "Doe", "2000-01-01", "F", "1234567890");
        personDAO.create(person1);
        personDAO.create(person2);

        List<Person> result = personDAO.getAll();
        assertEquals(sizeBefore+2, result.size());
        assertEquals(person1.getName(), result.get(sizeBefore).getName());
        assertEquals(person2.getName(), result.get(sizeBefore+1).getName());
    }

    @Test
    public void testCreate() {
        int sizeBefore = personDAO.getAll().size();
        Person person = new Person("John", "Doe", "2000-01-01", "M", "1234567890");
        personDAO.create(person);

        List<Person> result = personDAO.getAll();
        assertEquals(sizeBefore+1, result.size());
        assertEquals(person, result.get(sizeBefore));
    }

    @Test
    public void testUpdate() {
        Person person = new Person("John", "Doe", "2000-01-01", "M", "1234567890");
    }
}