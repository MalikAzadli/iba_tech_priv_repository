package step_project_sketch;

import java.util.Optional;
import java.util.Set;

public interface DAO<T> {
    Set<T> findAll();
    Optional<T> findById(int id);
    boolean create(T t);
    boolean remove(int id);
    void load();
    void save();
}
