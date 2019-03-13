package Main;

import Database.GestionArchivo;
import javafx.application.Application;
import static javafx.application.Application.launch;
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
        
        GestionArchivo archivo = new GestionArchivo("datos.txt");
        //modeloen memoria
        Modelo modelo = new Modelo();
        modelo.setUsers(archivo.loadUsers());
        //invocar el controlador de la vista que quiero visualizar
        VentanamenuController controladormenu = new VentanamenuController(modelo);
        controladormenu.mostrarVista();
        System.out.println("ver");
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
