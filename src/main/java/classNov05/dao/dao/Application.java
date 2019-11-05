package classNov05.dao.dao;

import java.io.*;
import java.util.List;
import java.util.Random;

public class Application {
  public static void main(String[] args) throws IOException {
    File file = new File("nameSurname");
    FileReader fr = new FileReader(file);
    BufferedReader br = new BufferedReader(fr);
    Random rand = new Random();


    DAO<Person> pps =
        new DAOPersonHashMap();
//        new DAOPersonArrayList();
//        new DAOPersonSQL();
    DAO<Pizza> pzs =
        new DAOPizzaHashMap();
//        new DAOPersonArrayList();
//        new DAOPizzaSQL();


    br.lines().map(s -> new Person(rand.nextInt(1000), s, rand.nextInt(80))).forEach(p -> pps.put(p));
    List<Person> all = pps.getAll();

    file = new File("savedData");
    FileWriter fw = new FileWriter(file);
    BufferedWriter bw = new BufferedWriter(fw);

    System.out.println(all);
    all.stream().forEach(p -> {
      try {
        bw.write(String.format("%d/%s/%d", p.getId(), p.getName(), p.getAge()));
        bw.newLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
    });


  }
}
