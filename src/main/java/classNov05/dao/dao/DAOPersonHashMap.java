package classNov05.dao.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DAOPersonHashMap implements DAO<Person> {

    private Map<Integer, Person> storage = new HashMap<>();

    @Override
    public void put(Person object) {
        storage.put(object.getId(), object);
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
        return storage.keySet().stream()
                .map(k -> storage.get(k))
                .collect(Collectors.toList());
    }
}
