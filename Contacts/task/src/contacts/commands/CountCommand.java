package contacts.commands;

import contacts.PersonDAO;

public class CountCommand extends Command{

    PersonDAO personDAO = PersonDAO.getPersonDAOInstance();

    protected CountCommand() {
        super("COUNT");
    }

    @Override

    public void execute() {
        System.out.printf("The Phone Book has %d records.%n", personDAO.getAll().size());
    }
}
