package Main;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gasilva
 */
public class Modelo {
    private Map<String,String> users = null;
    
    public Modelo() {
        this.users = new HashMap<>();
    }
    
    public boolean addUser(String name, String score){
        return this.users.put(name, score) == null;
    }
    
    public Map<String,String> getUsers() {
        return users;
    }

    public void setUsers(Map<String, String> users) {
        this.users = users;
    }

}
