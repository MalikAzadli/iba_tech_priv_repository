package november.classNov05.dao.dao;

import java.util.function.Supplier;

public class DeepRabbitHole {

  void process(Supplier<Person> supplier) {
    Person person = supplier.get();
  }
}
