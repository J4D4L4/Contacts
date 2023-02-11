package contacts;

public class PersonBuilder implements EntityBuilder{
    private String name;
    private String surname;
    private String number;
    private String birthday;
    private String gender;


    @Override
    public void setName(String name) {
        this.name = name;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public void setNumber(String number) {
        this.number = number;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public Person getResult(){
        return new Person(name, surname, birthday,gender,number);
    }
}
