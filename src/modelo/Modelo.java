/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import javafx.stage.Stage;

/**
 *
 * @author gasilva
 */
public class Modelo {
    private ArrayList<Usuario> users;
    
    public Modelo() {
        this.users = new ArrayList<>();
    }
    
    public boolean addUser(Usuario user){
        return this.users.add(user);
    }
    
    public ArrayList<Usuario> getUsers() {
        return users;
    }
}
