package contacts;

public class Main {
    public static void main(String[] args) {

        CommandLineInterface cli = new CommandLineInterface();
        setUpTestData();
        cli.run();

    }

    public static void setUpTestData(){

        PersonDAO personDAO = PersonDAO.getPersonDAOInstance();
        OrganisationDAO organisationDAO = OrganisationDAO.getPersonDAOInstance();

        personDAO.create(new Person("asd", "asd", "asd", "M","13256"));
        organisationDAO.create(new Organisation("asasd","164654","asdasfd"));

    }
}
