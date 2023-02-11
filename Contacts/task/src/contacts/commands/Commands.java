package contacts.commands;


public enum Commands {

    CREATEPERSON("PERSON", new PersonCreationCommand(), true),
    CREATEORGANISATION("ORGANIZATION", new OrganisationCreationCommand(),true),
    EXIT("EXIT", new ExitCommand("Exit"), false),
    EDIT("EDIT", new EditCommand(), false),
    LIST("LIST", new ListCommand(), false),
    COUNT("COUNT", new CountCommand(), false),
    REMOVE("REMOVE", new RemoveCommand(), false),
    ADD("ADD", new AddCommand(), true),
    INFO("INFO", new InfoCommand(), false)


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