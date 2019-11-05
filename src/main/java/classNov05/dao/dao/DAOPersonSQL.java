package classNov05.dao.dao;

import java.util.List;

public class DAOPersonSQL implements DAO<Person> {

  @Override
  public void put(Person object) {
    throw new IllegalArgumentException("DAOPersonSQL:put:not yet");
  }

  @Override
  public Person get(int id) {
    throw new IllegalArgumentException("DAOPersonSQL:get:not yet");
  }

  @Override
  public void delete(int id) {
    throw new IllegalArgumentException("DAOPersonSQL:delete:not yet");
  }

  @Override
  public List<Person> getAll() {
    throw new IllegalArgumentException("DAOPersonSQL:getAll:not yet");
  }
}
