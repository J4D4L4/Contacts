package contacts.commands;

import contacts.PersonDAO;

import java.io.FileNotFoundException;

public class CountCommand extends Command{


    protected CountCommand() throws FileNotFoundException {
        super("COUNT");
    }

    @Override

    public void execute() {
        int phoneBookSize = personDAO.getAll().size()+organisationDAO.getAll().size();
        System.out.printf("The Phone Book has %d records.%n", phoneBookSize);
    }
}
