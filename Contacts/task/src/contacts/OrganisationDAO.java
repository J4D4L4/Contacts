package contacts;

import org.apache.commons.lang3.SerializationUtils;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Arrays;
public class OrganisationDAO implements DataAccessObject<Organisation> {

    static OrganisationDAO instance;
    private static List<Organisation> organisations = new ArrayList<>();
    public static String filename = "Organisation.data";

    public static OrganisationDAO getPersonDAOInstance() throws FileNotFoundException {
        if(instance == null) {
            instance = new OrganisationDAO();
            deSerialize();
        }
        return instance;
    }
    @Override
    public Optional get(long id) {
        if(id< organisations.size()) {
            return Optional.ofNullable(organisations.get((int) id));
        }
        else return Optional.ofNullable(null);
    }

    @Override
    public List getAll() {
        return organisations;
    }

    @Override
    public void create(Organisation organisation) {

        organisations.add(organisation);
        serialize();
    }

    @Override
    public void update(Organisation organisation, String[] params) {
        organisation.setEdited(LocalDateTime.now());

        if(params[0] != "")
            organisation.setName(Objects.requireNonNull(
                    params[0], "Name cannot be null"));
        if(params[1] != "")
            organisation.setAddress(Objects.requireNonNull(
                    params[1], "Surname cannot be null"));
        if(params[2] != "")
            organisation.setNumber(Objects.requireNonNull(
                    params[2], "Number cannot be null"));
        serialize();

    }

    @Override
    public void delete(Organisation organisation) {
        organisations.remove(organisation);
        serialize();
    }

    public void listOrgas(){
        for(Organisation org : organisations) {
            System.out.println(org.toString());

        }
    }
    public void serialize(){

        try {
            System.out.println(new File(".").getAbsolutePath());
            FileOutputStream fileOut = new FileOutputStream(filename);
            Organisation organisationsArray[] = organisations.toArray(new Organisation[0]);
            fileOut.write(SerializationUtils.serialize(organisationsArray));
            fileOut.close();
            System.out.println("Serialized data is saved in organization.data");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }



    public static void deSerialize() throws FileNotFoundException {



        try {
            FileInputStream fileIn = new FileInputStream(filename);
            Organisation orgList[] = (Organisation[]) SerializationUtils.deserialize(fileIn.readAllBytes());
            List<Organisation> listAsOrg = new ArrayList<Organisation>(Arrays.asList(orgList));
            organisations = listAsOrg;
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        }


    }

}
