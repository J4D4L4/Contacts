package contacts;

public class CommandLineInterface {

    public void run() {
        Command createPersonCommand = new PersonCreationCommand();
        createPersonCommand.execute();
    }


}
