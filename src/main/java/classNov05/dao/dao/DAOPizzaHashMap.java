package classNov05.dao.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAOPizzaHashMap implements DAO<Pizza> {

  private Map<Integer, Pizza> storage = new HashMap<>();

  @Override
  public void put(Pizza object) {
    throw new IllegalArgumentException("DAOPizzaHashMap:put:not yet");
  }

  @Override
  public Pizza get(int id) {
    throw new IllegalArgumentException("DAOPizzaHashMap:get:not yet");
  }

  @Override
  public void delete(int id) {
    throw new IllegalArgumentException("DAOPizzaHashMap:delete:not yet");
  }

  @Override
  public List<Pizza> getAll() {
    throw new IllegalArgumentException("DAOPizzaHashMap:getAll:not yet");
  }
}
