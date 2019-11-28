package november.classNov28.calc_with_history_db.auth;

public interface Auth {
  boolean check(String name, String passwd);
}
