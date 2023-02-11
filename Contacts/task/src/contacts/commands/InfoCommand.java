package contacts.commands;

import contacts.Organisation;
import contacts.OrganisationDAO;
import contacts.Person;
import contacts.PersonDAO;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

public class InfoCommand extends Command{
    PersonDAO personDAO = PersonDAO.getPersonDAOInstance();
    OrganisationDAO organisationDAO = OrganisationDAO.getPersonDAOInstance();
    List<Person> allPerson = personDAO.getAll();
    List<Organisation> allOrgs = organisationDAO.getAll();
    protected InfoCommand() throws FileNotFoundException {
        super("INFO");
    }

    @Override
    public void execute() {
        listAll();
        try {
            int idOfEntity = Integer.parseInt(getUserInput());
            printMoreInfo(idOfEntity);
        }
        catch (Exception e) {
            System.out.println("Wrong Input!");
        }

    }

    public void listAll() {
        int counter = 1;

        for(Person person : allPerson){
            System.out.println(counter+". "+person.toString());
            counter++;
        }
        for(Organisation organisation : allOrgs){
            System.out.println(counter+". "+organisation.toString());
            counter++;
        }
    }

    public void printMoreInfo(int id){
        if(id>allPerson.size()){
            allOrgs.get(id-1- allPerson.size()).printLongDescription();
        }
        else
            allPerson.get(id-1).printLongDescription();
    }

}
