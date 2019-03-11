/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Vistas.LoopJuego;
import modelo.Modelo;
import Main.Singleton;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author ansil
 */
public class LoopJuegoController {
    private Modelo modelo;

    public LoopJuegoController(Modelo modelo) {
        this.modelo = modelo;
    }
    public void mostrarVista() throws IOException {
        Singleton singleton = Singleton.getSingleton();
        mostrar(singleton.getStage());
    }
    public void mostrar(Stage stage) throws IOException{
        Pane layout  = new Pane();  
        Canvas canvas = new Canvas(810,520);
        layout.getChildren().add(canvas);
        Scene escena = new Scene(layout,796,520);
        
        GraphicsContext lapiz = canvas.getGraphicsContext2D();
        LoopJuego juego = new LoopJuego(escena, lapiz);
        juego.start();
        stage.setScene(escena);
        stage.setTitle("Juego");
        stage.show();
    }
}
