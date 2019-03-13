
package Main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author kjime
 */
public class PuntajeController {
    private Modelo modelo;
    private Ventanapuntaje view;
    
    
    public PuntajeController(Modelo modelo) {
        this.modelo = modelo;
        this.view = new Ventanapuntaje();
       
        view.getRegresar().setOnAction(new regresarEventHandler());    
    }
    
    public void mostrarVista(){
        Singleton singleton = Singleton.getSingleton();
        
        int a = 1;
        for (String key : modelo.getUsers().keySet()) {
            
            view.getList().getItems().add(a + ": " + key + ", " + modelo.getUsers().get(key));
            a++;
        }      
     
        view.mostrar(singleton.getStage());
   }
    
    class regresarEventHandler implements EventHandler<ActionEvent>{
 
        @Override
        public void handle(ActionEvent e) {   
            // Regresar 
            VentanamenuController controladormenu = new VentanamenuController(modelo);
            controladormenu.mostrarVista();
        }   
    }
   
}
