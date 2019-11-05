package classNov05.dao.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DAOPersonArrayList implements DAO<Person> {

    private List<Person> storage = new ArrayList<>();

    @Override
    public void put(Person object) {
        storage.add(object);
    }

    @Override
    public Person get(int id) {
        List<Person> person = storage.stream().filter(p -> p.getId() == id).collect(Collectors.toList());

        return person.get(0);
    }

    @Override
    public void delete(int id) {
        List<Person> person = storage.stream().filter(p -> p.getId() == id).collect(Collectors.toList());
        storage.remove(person.get(0));
    }

    @Override
    public List<Person> getAll() {
        return storage;
    }
}
