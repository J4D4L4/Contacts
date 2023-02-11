package contacts;

class ExitCommand extends Command{



    ExitCommand(String inputCommand) {
            super(inputCommand);
        }
        boolean exit() {
            return true;
        }

    @Override
    protected void execute() {
        System.out.println("Bye!");
        System.exit(0);
    }
}
