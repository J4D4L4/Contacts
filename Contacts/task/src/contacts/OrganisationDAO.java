package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OrganisationDAO implements DataAccessObject<Organisation> {

    static OrganisationDAO instance;
    private List<Organisation> organisations = new ArrayList<>();

    public static OrganisationDAO getPersonDAOInstance() {
        if(instance == null)
            instance = new OrganisationDAO();
        return instance;
    }
    @Override
    public Optional get(long id) {
        return Optional.ofNullable(organisations.get((int) id));
    }

    @Override
    public List getAll() {
        return organisations;
    }

    @Override
    public void create(Organisation organisation) {
        organisations.add(organisation);
    }

    @Override
    public void update(Organisation organisation, String[] params) {

        if(params[0] != "")
            organisation.setName(Objects.requireNonNull(
                    params[0], "Name cannot be null"));
        if(params[1] != "")
            organisation.setAddress(Objects.requireNonNull(
                    params[1], "Surname cannot be null"));
        if(params[2] != "")
            organisation.setNumber(Objects.requireNonNull(
                    params[2], "Number cannot be null"));

    }

    @Override
    public void delete(Organisation organisation) {
        organisations.remove(organisation);
    }

    public void listOrgas(){
        for(Organisation org : organisations) {
            System.out.println(org.toString());

        }
    }

}
