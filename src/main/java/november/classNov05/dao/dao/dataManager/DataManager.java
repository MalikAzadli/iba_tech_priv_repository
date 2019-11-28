package november.classNov05.dao.dao.dataManager;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface DataManager<Person> {

    void loadData() throws FileNotFoundException;
    void saveData() throws IOException;
}
