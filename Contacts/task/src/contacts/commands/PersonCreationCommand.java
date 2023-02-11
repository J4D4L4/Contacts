package contacts.commands;

import contacts.PersonBuilder;
import contacts.InputValidator;
import contacts.Person;
import contacts.PersonBuilder;
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
        String birthday = createBirthdayFromInput();
        String gender = createGenderFromInput();
        String number = createNumberFromInput();
        Person createdPerson = createPerson(name,surname,birthday,gender,number);
        personDAO.create(createdPerson);


    }

    public Person createPerson(String name, String surname, String birthday, String gender, String number) {
        PersonBuilder contactBuilder = new PersonBuilder();
        contactBuilder.setName(name);
        contactBuilder.setSurname(surname);
        contactBuilder.setBirthday(birthday);
        contactBuilder.setGender(gender);
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

    public String createBirthdayFromInput() {
        System.out.println("Enter the birth date:");
        String birthday = getUserInput();
        if (InputValidator.validateDate(birthday))
            return birthday;
        else {
            System.out.println("Bad birth date!");
            return "[no data]";
        }
    }

        public String createGenderFromInput() {
            System.out.println("Enter the gender (M, F):");
            String gender = getUserInput();
            if(InputValidator.validateGender(gender))
                return gender;
            else {
                System.out.println("Bad gender!");
                return "[no data]";
            }
    }

}
