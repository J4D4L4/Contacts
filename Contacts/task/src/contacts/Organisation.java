package contacts;

import java.io.Serializable;

public class Organisation extends Entity  implements Serializable {

    public String address;
    private static final long serialVersionUID = 1l;
    protected Organisation(String name, String number, String address) {
        super(name, number);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
    public String toString(){
        return super.getName();

    }

    public void printLongDescription() {
        System.out.printf("Organization name: %s%n",super.getName());
        System.out.printf("Address: %s%n",address);
        System.out.printf("Number: %s%n",super.getNumber());
        System.out.printf("Time created: %s%n",super.getCreated().toString());
        System.out.printf("Time last edit: %s%n",super.getEdited().toString());
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String appendString() {
        return getName()+" "+getAddress()+" "+getNumber();
    }
}
