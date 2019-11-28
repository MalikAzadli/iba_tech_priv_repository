package november.classNov28.calc_with_history_db.auth;

import november.classNov28.calc_with_history_db.db_props.DbOperations;
import november.classNov28.database.DbOperation;

import java.util.HashMap;
import java.util.Map;

public class AuthHash implements Auth {

  private final Map<String, String> db = new HashMap<String, String>(){{
    put("user", "123");
    put("admin", "234");
    put("manager", "345");
  }};

  @Override
  public boolean check(String name, String passwd) {
    try{
      return DbOperations.isValidUser(name, passwd);
    } catch (Exception e){
      System.out.println(e.getMessage());
    }
    return false;
  }
}

