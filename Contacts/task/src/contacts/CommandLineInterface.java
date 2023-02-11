package contacts;

import contacts.commands.Commands;

import java.util.Scanner;

public class CommandLineInterface {

    public void run() {
        while (true) {

            printMenu();
            String input = getUserInput();
            interpretInput(input);

        }

    }

    public void printMenu(){
        System.out.print("Enter action (add, remove, edit, count, list, exit): ");
    }

    public String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    public void interpretInput(String input){
        boolean foundCommand = false;
        for (Commands c: Commands.values()) {
            if (c.strCommand.equals(input.toUpperCase())){
                c.command.execute();
                foundCommand= true;
            }
        }
        if(!foundCommand)
            System.out.println("Wrong Command!");

    }


}
