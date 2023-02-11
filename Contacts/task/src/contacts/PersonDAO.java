package contacts;

import contacts.DataAccessObject;
import contacts.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class PersonDAO implements DataAccessObject<Person> {
    //singelton
    static PersonDAO instance;
    private List<Person> persons = new ArrayList<>();

    public static PersonDAO getPersonDAOInstance() {
        if(instance == null)
            instance = new PersonDAO();
        return instance;
    }
    @Override
    public Optional get(long id) {
        return Optional.ofNullable(persons.get((int) id));
    }

    @Override
    public List getAll() {
        return persons;
    }

    @Override
    public void create(Person person) {
        persons.add(person);
    }

    @Override
    public void update(Person person, String[] params) {
        person.setName(Objects.requireNonNull(
                params[0], "Name cannot be null"));
        person.setSurname(Objects.requireNonNull(
                params[1], "Surname cannot be null"));
        person.setNumber(Objects.requireNonNull(
                params[2], "Number cannot be null"));

        persons.add(person);

    }

    @Override
    public void delete(Person person) {
        persons.remove(person);

    }

    public void listPersonRecords(){

        PersonDAO personDAO = PersonDAO.getPersonDAOInstance();
        List<Person> personList = personDAO.getAll();

        for ( int counter = 1; counter <= personList.size(); counter++){

            System.out.println(""+counter+". "+personList.get(counter-1));
        }

    }


}
