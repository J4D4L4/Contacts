package contacts;

import contacts.DataAccessObject;
import contacts.Person;
import org.apache.commons.lang3.SerializationUtils;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class PersonDAO implements DataAccessObject<Person> {
    //singelton
    static PersonDAO instance;
    private static List<Person> persons = new ArrayList<>();

    static String filename = "Person.data";

    public static PersonDAO getPersonDAOInstance() throws FileNotFoundException {
        if(instance == null) {

            instance = new PersonDAO();
            deSerialize();
        }
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
        serialize();
    }

    @Override
    public void update(Person person, String[] params) {
        person.setEdited(LocalDateTime.now());
        if(params[0] != "")
            person.setName(Objects.requireNonNull(
                    params[0], "Name cannot be null"));
        if(params[1] != "")
            person.setSurname(Objects.requireNonNull(
                    params[1], "Surname cannot be null"));
        if(params[2] != "")
            person.setBirthday(Objects.requireNonNull(
                    params[2], "Number cannot be null"));
        if(params[3] != "")
            person.setGender(Objects.requireNonNull(
                    params[3], "Surname cannot be null"));
        if(params[4] != "")
            person.setNumber(Objects.requireNonNull(
                    params[4], "Number cannot be null"));

        serialize();

        //persons.add(person);

    }

    @Override
    public void delete(Person person) {
        persons.remove(person);
        serialize();

    }

    public void listPersonRecords() throws FileNotFoundException {

        PersonDAO personDAO = PersonDAO.getPersonDAOInstance();
        List<Person> personList = personDAO.getAll();

        for ( int counter = 1; counter <= personList.size(); counter++){

            System.out.println(""+counter+". "+personList.get(counter-1));
        }

    }

    public void serialize(){

        try {
            System.out.println(new File(".").getAbsolutePath());
            FileOutputStream fileOut = new FileOutputStream(filename);
            Person personArray[] = persons.toArray(new Person[0]);
            fileOut.write(SerializationUtils.serialize(personArray));
            fileOut.close();
            System.out.println("Serialized data is saved in organization.data");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }



    public static void deSerialize() throws FileNotFoundException {



        try {
            FileInputStream fileIn = new FileInputStream(filename);
            Person personList[] = (Person[]) SerializationUtils.deserialize(fileIn.readAllBytes());
            List<Person> listAsOrg = new ArrayList<Person>(Arrays.asList(personList));
            persons = listAsOrg;
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        }


    }


}
