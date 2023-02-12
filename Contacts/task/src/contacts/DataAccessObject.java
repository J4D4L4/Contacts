package contacts;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Optional;
public interface DataAccessObject<T> {

    Optional<T> get(long id);
    List<T> getAll();
    void create(T t);
    void update(T t, String[] params);
    void delete(T t);
    private void writeToFile (ObjectOutputStream out) throws IOException {
        out.writeObject(this);
        out.close();
    }

}
