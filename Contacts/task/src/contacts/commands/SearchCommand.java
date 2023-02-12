package contacts.commands;

import contacts.Entity;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchCommand extends Command{
    protected SearchCommand() throws FileNotFoundException {
        super("SEARCH");
    }

    @Override
    public void execute() throws FileNotFoundException {
        System.out.print("Enter search query: ");
        String searchQuery = getUserInput();
        List<Entity> searchResults = getSearchMatches(searchQuery);
        printSearchResults(searchResults);

    }

    public List<Entity> getAllEntities() {

        List<Entity> allEntities = (List<Entity>) Stream.concat(personDAO.getAll().stream(), organisationDAO.getAll().stream()).collect(Collectors.toList());
        return allEntities;

    }

    public List<Entity> getSearchMatches(String search) {
        List<Entity> allEntities = getAllEntities();
        List<Entity> searchResults = allEntities.stream().filter(entity -> entity.appendString().contains(search)).collect(Collectors.toList());
        return searchResults;
    }

    public void printSearchResults(List<Entity> searchResults) {
        int counter =1;
        for (Entity entity : searchResults){
            System.out.print(counter+". ");
            entity.printEntity();
            counter++;
        }
    }


}
