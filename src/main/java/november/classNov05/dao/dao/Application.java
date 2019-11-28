package november.classNov05.dao.dao;

import november.classNov05.dao.dao.dataManager.DataManager;
import november.classNov05.dao.dao.dataManager.PersonDataManager;

import java.io.*;
import java.util.List;

public class Application {
  public static void main(String[] args) throws IOException {

    DAO<Person> pps =
//        new DAOPersonHashMap();
        new DAOPersonArrayList();
    DataManager dataManager = new PersonDataManager("savedData", pps);
    dataManager.loadData();

    pps.put(new Person(14, "James", 28));
    pps.put(new Person(97, "Malik", 22));
    pps.delete(3);
    pps.delete(1);

    Person person = pps.get(14);
    System.out.printf("Person with id 10: %s\n", person);

    List<Person> all = pps.getAll();
    System.out.println(all);

    dataManager.saveData();
  }
}
