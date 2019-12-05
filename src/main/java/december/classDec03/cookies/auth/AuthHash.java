package december.classDec03.cookies.auth;

import december.classDec03.cookies.db_props.DbOperations;

import java.util.HashMap;
import java.util.Map;

public class AuthHash implements Auth {

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

