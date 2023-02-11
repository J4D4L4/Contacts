package contacts.commands;

import java.io.FileNotFoundException;

class ExitCommand extends Command{



    ExitCommand(String inputCommand) throws FileNotFoundException {
            super(inputCommand);
        }
        boolean exit() {
            return true;
        }

    @Override
    public void execute() {
        System.out.println("Bye!");
        System.exit(0);
    }
}
