package contacts.commands;

import contacts.PersonDAO;

public class ListCommand extends Command{

    PersonDAO personDAO = PersonDAO.getPersonDAOInstance();
    public ListCommand() {
        super("List Persons");
    }

    @Override
    public void execute() {
        personDAO.listPersonRecords();

    }

}
