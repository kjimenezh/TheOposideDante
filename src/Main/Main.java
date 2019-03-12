package Main;

import modelo.Modelo;
import javafx.application.Application;
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
        System.out.println("ver");
    }
    public static void main(String[] args) {
        launch(args);
    }
}
