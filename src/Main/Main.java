package Main;

import Loop1.LoopJuego;
import javafx.application.Application;
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
        Pane layout  = new Pane();  
        Canvas canvas = new Canvas(810,520);
        layout.getChildren().add(canvas);
        Scene escena = new Scene(layout,796,520);
        
        GraphicsContext lapiz = canvas.getGraphicsContext2D();
        LoopJuego juego = new LoopJuego(escena, lapiz);
        juego.start();
        
        primaryStage.setScene(escena);
        primaryStage.setTitle("Ejemplo Escenario Interactivo");
        primaryStage.show();
        
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}