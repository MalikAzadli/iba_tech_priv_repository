package classNov05.dao.dao;

import java.util.ArrayList;
import java.util.List;

public class DAOPersonArrayList implements DAO<Person> {

    private List<Person> storage = new ArrayList<>();

    @Override
    public void put(Person object) {
        storage.add(object);
    }

    @Override
    public Person get(int id) {
        return storage.get(id);
    }

    @Override
    public void delete(int id) {
        storage.remove(get(id));
    }

    @Override
    public List<Person> getAll() {
        return storage;
    }
}
