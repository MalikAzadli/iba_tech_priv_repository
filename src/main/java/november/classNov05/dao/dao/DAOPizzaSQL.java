package november.classNov05.dao.dao;

import java.util.List;

public class DAOPizzaSQL implements DAO<Pizza> {

  @Override
  public void put(Pizza object) {
    throw new IllegalArgumentException("DAOPizzaSQL:put:not yet");
  }

  @Override
  public Pizza get(int id) {
    throw new IllegalArgumentException("DAOPizzaSQL:get:not yet");
  }

  @Override
  public void delete(int id) {
    throw new IllegalArgumentException("DAOPizzaSQL:delete:not yet");
  }

  @Override
  public List<Pizza> getAll() {
    throw new IllegalArgumentException("DAOPizzaSQL:getAll:not yet");
  }
}
