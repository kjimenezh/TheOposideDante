/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import modelo.Modelo;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
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
        String songName = "running.mp3";
        String pathToMp3 = System.getProperty("user.dir") + "/" + songName;
        BasicPlayer player = new BasicPlayer();
        try {
            player.open(new URL("file:///" + pathToMp3));
            for (int i = 0; i < 3; i++) {
                player.play();
            }
        } catch (BasicPlayerException | MalformedURLException e) {
            e.printStackTrace();
        }
        Pane layout  = new Pane();  
        Canvas canvas = new Canvas(810,520);
        layout.getChildren().add(canvas);
        Scene escena = new Scene(layout,796,520);
        
        GraphicsContext lapiz = canvas.getGraphicsContext2D();
        LoopJuego juego = new LoopJuego(escena, lapiz, this.modelo);
        juego.start();
        stage.setScene(escena);
        stage.setTitle("The Oposide Dante");
        stage.getIcons().add(new Image("Images/icon.png"));
        stage.show();
    }
}
