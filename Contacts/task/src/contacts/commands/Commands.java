package contacts.commands;


import java.io.FileNotFoundException;

public enum Commands {

    CREATEPERSON("PERSON", new Object() {
        PersonCreationCommand evaluate() {
            try {
                return new PersonCreationCommand();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }.evaluate(), true),
    CREATEORGANISATION("ORGANIZATION", new Object() {
        OrganisationCreationCommand evaluate() {
            try {
                return new OrganisationCreationCommand();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }.evaluate(),true),
    EXIT("EXIT", new Object() {
        ExitCommand evaluate() {
            try {
                return new ExitCommand("Exit");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }.evaluate(), false),
    EDIT("EDIT", new Object() {
        EditCommand evaluate() {
            try {
                return new EditCommand();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }.evaluate(), false),
    LIST("LIST", new Object() {
        ListCommand evaluate() {
            try {
                return new ListCommand();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }.evaluate(), false),
    COUNT("COUNT", new Object() {
        CountCommand evaluate() {
            try {
                return new CountCommand();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }.evaluate(), false),
    REMOVE("REMOVE", new Object() {
        RemoveCommand evaluate() {
            try {
                return new RemoveCommand();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }.evaluate(), false),
    ADD("ADD", new Object() {
        AddCommand evaluate() {
            try {
                return new AddCommand();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }.evaluate(), true),
    INFO("INFO", new Object() {
        InfoCommand evaluate() {
            try {
                return new InfoCommand();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }.evaluate(), false),
    SEARCH("SEARCH", new Object() {
        SearchCommand evaluate() {
            try {
                return new SearchCommand();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }.evaluate(), false)



    ;

    public String strCommand;
    public Command command;
    public boolean createCommand;
    Commands(String strCommand, Command classCommand, boolean createCommand){
        this.strCommand =strCommand;
        this.command = classCommand;
        this.createCommand = createCommand;

    }


}