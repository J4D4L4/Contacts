package contacts.commands;


public enum Commands {

    CREATEPERSON("ADD", new PersonCreationCommand()),
    EXIT("EXIT", new ExitCommand("Exit")),
    EDIT("EDIT", new EditCommand()),
    LIST("LIST", new ListCommand()),
    COUNT("COUNT", new CountCommand()),
    REMOVE("REMOVE", new RemoveCommand())

    ;

    public String strCommand;
    public Command command;
    Commands(String strCommand, Command classCommand){
        this.strCommand =strCommand;
        this.command = classCommand;

    }


}