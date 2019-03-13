/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
}
