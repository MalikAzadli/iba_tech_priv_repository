package classNov05.dao.dao.parser;

import classNov05.dao.dao.Person;

public class PersonParser implements Parser<Person> {
    @Override
    public Person parse(String string) {
        String[] splitter = string.split("/");
        int id = Integer.parseInt(splitter[0]);
        String name = splitter[1];
        int age = Integer.parseInt(splitter[2]);

        return new Person(id,name,age);
    }

    @Override
    public String toString(Person person) {
        return String.format("%d/%s/%d", person.getId(), person.getName(), person.getAge());
    }
}
