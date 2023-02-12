import contacts.Organisation;
import contacts.OrganisationDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class OrganisationDAOTest {

    private OrganisationDAO organisationDAO = OrganisationDAO.getPersonDAOInstance();
    private Organisation organisation = new Organisation("1", "Test Organisation", "123 Test Street");;

    public OrganisationDAOTest() throws FileNotFoundException {
    }

    @Before
    public void setUp() throws Exception {
        organisationDAO = OrganisationDAO.getPersonDAOInstance();
        organisation = new Organisation("1", "Test Organisation", "123 Test Street");
    }

    @After
    public void tearDown() throws Exception {
        File file = new File(OrganisationDAO.filename);
        file.delete();
    }

    @Test
    public void getPersonDAOInstance() {
        assertNotNull(organisationDAO);
    }

    @Test
    public void testGet() {
        int sizeBefore = organisationDAO.getAll().size();
        organisationDAO.create(organisation);
        Optional<Organisation> retrievedOrganisation = organisationDAO.get(sizeBefore);
        assertTrue(retrievedOrganisation.isPresent());
        assertEquals(organisation.getName(), retrievedOrganisation.get().getName());
    }

    @Test
    public void testGetAll() {
        int sizeBefore = organisationDAO.getAll().size();
        organisationDAO.create(organisation);
        List<Organisation> retrievedOrganisations = organisationDAO.getAll();
        assertEquals(sizeBefore+1, retrievedOrganisations.size());
        assertEquals(organisation, retrievedOrganisations.get(sizeBefore));
    }

    @Test
    public void testCreate() {
        int sizeBefore = organisationDAO.getAll().size();
        organisationDAO.create(organisation);
        Optional<Organisation> retrievedOrganisation = organisationDAO.get(sizeBefore);
        assertTrue(retrievedOrganisation.isPresent());
        assertEquals(organisation, retrievedOrganisation.get());
    }

    @Test
    public void testUpdate() {
        int sizeBefore = organisationDAO.getAll().size();
        organisationDAO.create(organisation);
        organisation.setName("New Test Organisation");
        organisationDAO.update(organisation, new String[]{"New Test Organisation", "", ""});
        Optional<Organisation> retrievedOrganisation = organisationDAO.get(sizeBefore);
        assertTrue(retrievedOrganisation.isPresent());
        assertEquals("New Test Organisation", retrievedOrganisation.get().getName());
    }

    @Test
    public void testDelete() {
        int sizeBefore = organisationDAO.getAll().size();
        organisationDAO.create(organisation);
        organisationDAO.delete(organisation);
        Optional<Organisation> retrievedOrganisation = organisationDAO.get(sizeBefore);
        assertFalse(retrievedOrganisation.isPresent());
    }
}