/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Main.LoopJuegoController;
import modelo.Modelo;
import Main.Singleton;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ansil
 */
public class MenuController{
    private Modelo modelo;

    public MenuController(Modelo modelo) {
        this.modelo = modelo;
    }

    public void mostrarVista() throws IOException {
        Singleton singleton = Singleton.getSingleton();
        mostrar(singleton.getStage());
    }
    public void mostrar(Stage stage) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }
    public void MenuButton() throws IOException{
        LoopJuegoController controlador = new LoopJuegoController(modelo);
        controlador.mostrarVista();
    }
}