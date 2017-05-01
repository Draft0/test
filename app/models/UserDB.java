package models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Draft on 01.05.2017.
 */
public class UserDB {

    private static Map<String, User> users = new HashMap<String, User>();

    public static void addUser(int id, String email, String password, Date date) {
        users.put(email, new User(id, email, password, date));
    }

    public static boolean isUser(String email) {
        return users.containsKey(email);
    }

    public static User getUser(String email) {
        return users.get((email == null) ? "" : email);
    }

    public static boolean isValid(String email, String password) {
        return ((email != null)
                &&
                (password != null)
                &&
                isUser(email)
                &&
                getUser(email).getPassword().equals(password));
    }
}
