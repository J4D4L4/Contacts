package contacts.commands;

import contacts.InputValidator;
import contacts.Person;
import contacts.PersonDAO;

public class EditCommand extends Command {

    PersonDAO personDAO = PersonDAO.getPersonDAOInstance();
    public EditCommand() {
        super("Edit Person");
    }

    @Override
    public void execute() {
        personDAO.listPersonRecords();
        Person personToEdit = getPersonToEdit();
        String updateParams[] = editPerson(personToEdit);
        personDAO.update(personToEdit, updateParams);
        System.out.println("The record updated!");
    }

    public Person getPersonToEdit() {
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

    public String[] editPerson(Person person) {

        System.out.print("Select a field (name, surname, number): ");
        String atributeToChange = getUserInput();
        String[] updateParams = {"","",""};
        switch (atributeToChange){

            case "name":
                System.out.println("Enter name: ");
                updateParams[0]=(getUserInput());
                break;
            case "surname":
                System.out.println("Enter surname: ");
                updateParams[1]=(getUserInput());
                break;
            case "number":
                System.out.println("Enter number: ");
                String number = getUserInput();
                if(!InputValidator.validateNumber(number)) {
                    System.out.println("Wrong number format!");
                    updateParams[2]=("[no number]");
                }
                else
                    updateParams[2]=(number);
                break;
            default:
                System.out.println("Wrong Input ");
                break;

        }
        return updateParams;
    }



}
