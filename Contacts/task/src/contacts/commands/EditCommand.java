package contacts.commands;

import contacts.PersonDAO;

public class EditCommand extends Command {

    PersonDAO personDAO = PersonDAO.getPersonDAOInstance();
    public EditCommand() {
        super("Edit Person");
    }

    @Override
    public void execute() {
        personDAO.listPersonRecords();

    }



}
