package contacts;

public class OrganisationBuilder implements EntityBuilder{

    private String name;
    private String address;
    private String number;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setNumber(String number) {
        this.number = number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Organisation getResult() {
        return new Organisation(name, number, address);
    }
}
