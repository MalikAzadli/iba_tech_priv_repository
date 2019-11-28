package november.classNov05.dao.dao.dataManager;

import november.classNov05.dao.dao.DAO;
import november.classNov05.dao.dao.Person;
import november.classNov05.dao.dao.parser.Parser;
import november.classNov05.dao.dao.parser.PersonParser;

import java.io.*;

public class PersonDataManager implements DataManager{

    private File file;
    private DAO dao;
    private Parser parser;

    public PersonDataManager(String string, DAO dao) {
        this.file = new File(string);
        this.dao = dao;
        this.parser = new PersonParser();
    }

    public void loadData() throws FileNotFoundException {
        FileReader fr = new FileReader(file);
        // try with resources. java7
        try (
                BufferedReader br = new BufferedReader(fr)
        ) {
            br.lines().forEach(s -> dao.put((Person) parser.parse(s)));
        } catch (IOException e) {
            throw new IllegalArgumentException("IO Ex");
        }

    }

    public void saveData() throws IOException {
        FileWriter fw = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fw);
        dao.getAll().forEach(p -> {
            try {
                bufferedWriter.write(parser.toString(p)+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bufferedWriter.close();
    }
}
