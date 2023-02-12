package contacts.commands;

import java.time.LocalDateTime;

public class Entity {

    String name;
    String number;
    LocalDateTime created;
    LocalDateTime edited;

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getEdited() {
        return edited;
    }

    public void setEdited(LocalDateTime edited) {
        this.edited = edited;
    }

    protected Entity(String name, String number) {

        this.name = name;
        this.number = number;
        this.created = LocalDateTime.now();
        this.edited = LocalDateTime.now();


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}
