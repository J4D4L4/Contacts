package contacts.commands;

import contacts.ContactBuilder;
import contacts.InputValidator;
import contacts.Person;
import contacts.PersonDAO;

public class PersonCreationCommand extends Command {

    public PersonCreationCommand() {
        super("Create Person");
    }
    @Override
    public void execute() {

        PersonDAO personDAO = PersonDAO.getPersonDAOInstance();
        String name = createUserNameFromInput();
        String surname = createUserSurNameFromInput();
        String number = createNumberFromInput();
        Person createdPerson = createPerson(name,surname,number);
        personDAO.create(createdPerson);
        System.out.println("A Phone Book with a single record created!");


    }

    public Person createPerson(String name, String surname, String number) {
        ContactBuilder contactBuilder = new ContactBuilder();
        contactBuilder.setName(name);
        contactBuilder.setSurname(surname);
        contactBuilder.setNumber(number);
        System.out.println("A record created!");
        return contactBuilder.getResult();

    }
    public String createUserSurNameFromInput() {
        System.out.println("Enter the surname of the person:");
        return getUserInput();
    }

    public String createUserNameFromInput() {
        System.out.println("Enter the name of the person:");
        return  getUserInput();
    }

    public String createNumberFromInput() {
        System.out.println("Enter the number:");
        String number = getUserInput();
        if(InputValidator.validateNumber(number))
            return number;
        else {
            System.out.println("Wrong number format!");
            return "[no number]";
        }
    }

}
