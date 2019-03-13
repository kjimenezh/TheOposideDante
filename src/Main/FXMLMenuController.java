/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author ansil
 */
public class FXMLMenuController implements Initializable {
    /*private Modelo modelo;
    
    public FXMLMenuController(Modelo modelo){
        this.modelo = modelo;
    }*/
    
    @FXML
    private void InicioButtonAction(ActionEvent event) throws IOException { //Cuando Inicio es oprimido
        System.out.println("Iniciando juego...");
        Modelo modelo = new Modelo();
        MenuController controller = new MenuController(modelo);
        controller.MenuButton();
    }
    @FXML
    private void PuntajeButtonAction(ActionEvent event) throws IOException{//Cuando Puntaje es oprimido
        System.out.println("Puntaje");
        Modelo modelo = new Modelo();
        MenuController controller = new MenuController(modelo);
        controller.PuntajeButton();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //NO TOCAR
    }    
    
}
