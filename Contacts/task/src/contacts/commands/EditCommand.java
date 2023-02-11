package contacts.commands;

import contacts.*;

import java.util.List;

public class EditCommand extends Command {


    public EditCommand() {
        super("Edit Person");
    }

    @Override
    public void execute() {
        listAll();
        try {
            int idToEdit = Integer.parseInt(getUserInput());
            editEntity(idToEdit);
        }
        catch (Exception e){
            System.out.println("Wrong Input!");
        }

        System.out.println("The record updated!");
    }



    public void editEntity(int id){
        if(id>allPerson.size()){
            Organisation toChangeOrg = allOrgs.get(id-1- allPerson.size());
            organisationDAO.update(toChangeOrg,editOrganisation(toChangeOrg));
        }
        else {
            Person person = allPerson.get(id-1);
            personDAO.update(person,editPerson(person));
        }
    }

    public String[] editPerson(Person person) {

        System.out.print("(name, surname, birth, gender, number): ");
        String atributeToChange = getUserInput();
        String[] updateParams = {"","","","",""};
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
                updateParams[4]=getNumberWithValidation(number);
            case "birth":
                System.out.println("Enter birth date: ");
                String birthday = getUserInput();
                    updateParams[2]=getBirthdayWithValidation(birthday);
                break;
            case "gender":
                System.out.println("Enter gender: ");
                String gender = getUserInput();
                updateParams[3]=getGenderWithValidation(gender);
                break;
            default:
                System.out.println("Wrong Input ");
                break;

        }
        return updateParams;
    }

    public String[] editOrganisation(Organisation org) {

        System.out.print("Select a field (name, address, number): ");
        String atributeToChange = getUserInput();
        String[] updateParams = {"", "", ""};
        switch (atributeToChange) {
            case "name":
                System.out.println("Enter name: ");
                updateParams[0]=(getUserInput());
                break;
            case "address":
                System.out.println("Enter address: ");
                updateParams[1]=(getUserInput());
                break;
            case "number":
                System.out.println("Enter number: ");
                String number = getUserInput();
                updateParams[2]=getNumberWithValidation(number);
            default:
                System.out.println("Wrong Input ");
                break;

        }
        return updateParams;
    }

    public String getNumberWithValidation(String number) {
        if(!InputValidator.validateNumber(number)) {
            System.out.println("Wrong number format!");
            return ("[no number]");
        }
        else
            return number;

    }
    public String getBirthdayWithValidation(String birth) {
        if(!InputValidator.validateNumber(birth)) {
            System.out.println("Bad birth date!");
            return ("[no data]");
        }
        else
            return birth;

    }

    public String getGenderWithValidation(String gender) {
        if(!InputValidator.validateGender(gender)) {
            System.out.println("Bad birth date!");
            return ("[no data]");
        }
        else
            return gender;

    }





}
