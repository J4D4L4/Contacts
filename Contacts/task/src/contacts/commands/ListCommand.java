package contacts.commands;

import contacts.OrganisationDAO;
import contacts.PersonDAO;

import java.io.FileNotFoundException;

public class ListCommand extends Command{

    PersonDAO personDAO = PersonDAO.getPersonDAOInstance();
    OrganisationDAO organisationDAO = OrganisationDAO.getPersonDAOInstance();
    public ListCommand() throws FileNotFoundException {
        super("List Persons");
    }

    @Override
    public void execute() throws FileNotFoundException {
        personDAO.listPersonRecords();
        organisationDAO.listOrgas();

    }

}
