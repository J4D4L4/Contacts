package contacts.commands;

import static contacts.commands.Commands.CREATEPERSON;

public class AddCommand extends Command{
    protected AddCommand() {
        super("ADD");
    }

    @Override
    public void execute() {
        System.out.print("Enter the type (person, organization): ");
        String input = getUserInput().toUpperCase();
        for(Commands command: Commands.values()){
            if(command.strCommand.equals(input) && command.createCommand){
                command.command.execute();
            }
        }
    }
}
