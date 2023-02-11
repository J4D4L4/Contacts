package contacts;

import contacts.commands.Entity;

public class Person extends Entity {


    String surname;
    String birthday;
    String gender;



    public Person(String name, String surname, String birthday, String gender, String number) {
        super(name,number);

        this.surname = surname;
        this.birthday = birthday;
        this.gender = gender;

    }

    public String toString(){
        return super.getName() +" "+surname;
    }
    public void printLongDescription() {
        System.out.printf("Name: %s%n",super.getName());
        System.out.printf("Surname: %s%n",getSurname());
        System.out.printf("Birth date: %s%n",birthday);
        System.out.printf("Gender: %s%n", gender);
        System.out.printf("Number: %s%n",super.getNumber());
        System.out.printf("Time created: %s%n",super.getCreated().toString());
        System.out.printf("Time last edit: %s%n",super.getEdited().toString());
    }




    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
