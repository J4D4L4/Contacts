import static org.junit.Assert.*;

import contacts.Person;
import org.junit.Test;

public class PersonTest {
    @Test
    public void testGetName() {
        Person person = new Person("John", "Doe", "123-456-7890");
        assertEquals("John", person.getName());
    }

    @Test
    public void testSetName() {
        Person person = new Person("John", "Doe", "123-456-7890");
        person.setName("Jane");
        assertEquals("Jane", person.getName());
    }

    @Test
    public void testGetSurname() {
        Person person = new Person("John", "Doe", "123-456-7890");
        assertEquals("Doe", person.getSurname());
    }

    @Test
    public void testSetSurname() {
        Person person = new Person("John", "Doe", "123-456-7890");
        person.setSurname("Smith");
        assertEquals("Smith", person.getSurname());
    }

    @Test
    public void testGetNumber() {
        Person person = new Person("John", "Doe", "123-456-7890");
        assertEquals("123-456-7890", person.getNumber());
    }

    @Test
    public void testSetNumber() {
        Person person = new Person("John", "Doe", "123-456-7890");
        person.setNumber("098-765-4321");
        assertEquals("098-765-4321", person.getNumber());
    }
}