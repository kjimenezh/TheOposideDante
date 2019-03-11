/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import modelo.Modelo;
import Controllers.MenuController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author ansil
 */
public class FXMLMenuController implements Initializable {
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        System.out.println("Iniciando juego...");
        Modelo modelo = new Modelo();
        MenuController controller = new MenuController(modelo);
        controller.MenuButton();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
