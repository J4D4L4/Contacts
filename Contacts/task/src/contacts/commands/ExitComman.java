package contacts.commands;

class ExitCommand extends Command{



    ExitCommand(String inputCommand) {
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
