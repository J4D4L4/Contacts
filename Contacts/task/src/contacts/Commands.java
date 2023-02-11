package contacts;


public enum Commands {

    CREATEPERSON("create Person", new PersonCreationCommand()),
    EXIT("Exit", new ExitCommand("Exit")),

    ;

    String strCommand;
    Command command;
    Commands(String strCommand, Command classCommand){
        this.strCommand =strCommand;
        this.command = classCommand;

    }


}