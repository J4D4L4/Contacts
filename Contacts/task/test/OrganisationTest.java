import contacts.Organisation;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class OrganisationTest {

    @Test
    public void testConstructor() {
        Organisation org = new Organisation("TestOrg", "123-456-7890", "1 Main St.");
        assertEquals("TestOrg", org.getName());
        assertEquals("123-456-7890", org.getNumber());
        assertEquals("1 Main St.", org.getAddress());
    }

    @Test
    public void testToString() {
        Organisation org = new Organisation("TestOrg", "123-456-7890", "1 Main St.");
        assertEquals("TestOrg", org.toString());
    }

    @Test
    public void testGetAddress() {
        Organisation org = new Organisation("TestOrg", "123-456-7890", "1 Main St.");
        assertEquals("1 Main St.", org.getAddress());
    }

    @Test
    public void testSetAddress() {
        Organisation org = new Organisation("TestOrg", "123-456-7890", "1 Main St.");
        org.setAddress("2 Main St.");
        assertEquals("2 Main St.", org.getAddress());
    }

    @Test
    public void testAppendString() {
        Organisation org = new Organisation("TestOrg", "123-456-7890", "1 Main St.");
        assertEquals("TestOrg 1 Main St. 123-456-7890", org.appendString());
    }
}
