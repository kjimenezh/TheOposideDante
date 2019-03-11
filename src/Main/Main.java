package Main;

import Loop1.LoopJuego;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class Main extends Application{
/**
 *
* @author Estudiante
 */
    @Override
    public void start(Stage primaryStage) throws Exception {
        //registrar la variable en el singleton
        Singleton singleton = Singleton.getSingleton();
        singleton.setStage(primaryStage);
        //modeloen memoria
        Modelo modelo = new Modelo();
        //invocar el controlador de la vista que quiero visualizar
        MenuController ventanaMenu = new MenuController(modelo);
        ventanaMenu.mostrarVista();
    }
    public static void main(String[] args) {
        launch(args);
    }
}