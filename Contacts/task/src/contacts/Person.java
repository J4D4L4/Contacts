package contacts;

public class Person {

    String name;
    String surname;

    public String getName() {
        return name;
    }





    String number;

    public Person(String name, String surname, String number) {

        this.name = name;
        this.surname = surname;
        this.number = number;
    }

    public String toString(){
        return name+" "+surname+", "+number;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
