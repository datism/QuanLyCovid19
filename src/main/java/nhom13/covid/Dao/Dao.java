package nhom13.covid.Dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    List<T> getAll();
    void update(T t);
    void delete(T t);
}
