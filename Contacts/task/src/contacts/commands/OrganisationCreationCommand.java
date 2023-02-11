package contacts.commands;

import contacts.*;

public class OrganisationCreationCommand extends Command{
    protected OrganisationCreationCommand() {
        super("Organisation");
    }


    @Override
    public void execute() {

        OrganisationDAO organisationDAO = OrganisationDAO.getPersonDAOInstance();
        String name = createOrgaNameFromInput();
        String address = createAddressFromInput();
        String number = createNumberFromInput();
        Organisation createdPerson = createOrganisation(name,number, address);
        organisationDAO.create(createdPerson);


    }

    public Organisation createOrganisation(String name, String number, String address) {
        OrganisationBuilder orgaBuilder = new OrganisationBuilder();
        orgaBuilder.setName(name);
        orgaBuilder.setNumber(number);
        orgaBuilder.setAddress(address);
        System.out.println("A record created!");
        return orgaBuilder.getResult();

    }


    public String createOrgaNameFromInput() {
        System.out.println("Enter the organization name:");
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

    public String createAddressFromInput() {
        System.out.println("Enter the address:");
        return getUserInput();

    }


}
