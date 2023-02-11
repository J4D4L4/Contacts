package contacts.commands;

import contacts.Organisation;
import contacts.Person;
import contacts.PersonDAO;

public class RemoveCommand extends Command{

    PersonDAO personDAO = PersonDAO.getPersonDAOInstance();

    protected RemoveCommand() {
        super("Remove");
    }

    @Override
    public void execute() {

        listAll();
        try {
            int idOfToDelete = Integer.parseInt(getUserInput());
            removeEntity(idOfToDelete);
        }
        catch (Exception e){

            System.out.println("Wrong input");

        }
    }

    public void removeEntity(int id){
        if(id>allPerson.size()){
            Organisation toRemoveEntity = allOrgs.get(id-1- allPerson.size());
            organisationDAO.delete(toRemoveEntity);
        }
        else {
            Person person = allPerson.get(id-1);
            personDAO.delete(person);
        }
    }


}
