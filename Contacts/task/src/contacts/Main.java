package contacts;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        PersonDAO personDAO = PersonDAO.getPersonDAOInstance();
        OrganisationDAO organisationDAO = OrganisationDAO.getPersonDAOInstance();

        if (args[0] != null){
            personDAO.filename = args[0]+"person.data";
            organisationDAO.filename = args[0]+"organisation.data";
        }

        CommandLineInterface cli = new CommandLineInterface();
        setUpTestData();
        cli.run();

    }

    public static void setUpTestData() throws FileNotFoundException {

        PersonDAO personDAO = PersonDAO.getPersonDAOInstance();
        OrganisationDAO organisationDAO = OrganisationDAO.getPersonDAOInstance();

        personDAO.create(new Person("asd", "asd", "asd", "M","13256"));
        organisationDAO.create(new Organisation("asasd","164654","asdasfd"));

    }
}
