package contacts.commands;

import contacts.Organisation;
import contacts.OrganisationDAO;
import contacts.Person;
import contacts.PersonDAO;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public abstract class Command {

    String inputString;
    PersonDAO personDAO = PersonDAO.getPersonDAOInstance();
    OrganisationDAO organisationDAO = OrganisationDAO.getPersonDAOInstance();
    List<Person> allPerson = personDAO.getAll();
    List<Organisation> allOrgs = organisationDAO.getAll();

    protected Command(String inputString) throws FileNotFoundException {
        this.inputString = inputString;

    }

    public String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
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

    public abstract void execute() throws FileNotFoundException;


}
