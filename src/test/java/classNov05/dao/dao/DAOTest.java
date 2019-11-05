package classNov05.dao.dao;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class DAOTest {

    private DAO<Person> daoPerson;
    private BufferedReader br;

    @Before
    public void before() throws FileNotFoundException {
        this.daoPerson = new DAOPersonArrayList();
        File file = new File("nameSurname");
        FileReader fr = new FileReader(file);
        this.br = new BufferedReader(fr);
    }

    @Test
    public void put() throws IOException {
        Person p = new Person(10, br.readLine(), 25);
        daoPerson.put(p);
        assertEquals(p ,daoPerson.get(10));
    }

    @Test
    public void get() throws IOException {
        Person p = new Person(10, br.readLine(), 25);
        daoPerson.put(p);
        assertEquals(p, daoPerson.get(10));
    }

    @Test
    public void delete() throws IOException {
        Person p = new Person(10, br.readLine(), 25);
        List<Person> people = new ArrayList<>();
        people.add(p);
        daoPerson.put(p);
        daoPerson.delete(1);
        people.remove(p);
        assertEquals(p, daoPerson.getAll());
    }

    @Test
    public void getAll() throws IOException {
        Person p1 = new Person(10, br.readLine(), 25);
        Person p2 = new Person(102, br.readLine(), 28);
        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);

        daoPerson.put(p1);
        daoPerson.put(p2);
        assertEquals(people, daoPerson.getAll());

    }
}