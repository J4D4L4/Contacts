package contacts.commands;

import contacts.Person;
import contacts.PersonDAO;

public class RemoveCommand extends Command{

    PersonDAO personDAO = PersonDAO.getPersonDAOInstance();

    protected RemoveCommand() {
        super("Remove");
    }

    @Override
    public void execute() {

        personDAO.listPersonRecords();
        Person personToRemove = getPersonToRemove();
        removePerson(personToRemove);
    }

    public Person getPersonToRemove() {
        int idOfPerson;
        try {
            idOfPerson = Integer.parseInt(getUserInput());
        } catch (Exception e) {
            System.out.println("Wrong input");
            idOfPerson = -1;
        }
        if(idOfPerson != -1 && idOfPerson <= personDAO.getAll().size()) {
            return (Person) personDAO.getAll().get(idOfPerson-1);
        }
        else
            return null;


    }

    public void removePerson(Person person) {

        personDAO.delete(person);

    }
}
