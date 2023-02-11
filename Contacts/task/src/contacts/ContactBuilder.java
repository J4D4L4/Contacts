package contacts;

public class ContactBuilder implements PersonBuilder{
    private String name;
    private String surname;
    private String number;


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public void setNumber(String number) {
        this.number = number;
    }

    public Person getResult(){
        return new Person(name, surname, number);
    }
}
