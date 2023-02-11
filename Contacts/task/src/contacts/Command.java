package contacts;

import java.util.Scanner;

public abstract class Command {

    String inputString;

    protected Command(String inputString){
        this.inputString = inputString;

    }

    public String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    protected abstract void execute();


}
