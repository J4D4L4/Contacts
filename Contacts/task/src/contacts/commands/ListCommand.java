package contacts.commands;

import contacts.OrganisationDAO;
import contacts.PersonDAO;

public class ListCommand extends Command{

    PersonDAO personDAO = PersonDAO.getPersonDAOInstance();
    OrganisationDAO organisationDAO = OrganisationDAO.getPersonDAOInstance();
    public ListCommand() {
        super("List Persons");
    }

    @Override
    public void execute() {
        personDAO.listPersonRecords();
        organisationDAO.listOrgas();

    }

}
