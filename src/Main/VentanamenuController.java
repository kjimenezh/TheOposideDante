
package Main;

import Database.GestionArchivo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author kjime
 */
public class VentanamenuController {
    private Modelo modelo;
    private Ventanamenu view;
    
    public VentanamenuController(Modelo modelo) {
        this.modelo = modelo;
        this.view = new Ventanamenu();
       
        view.getIniciar().setOnAction(new iniciarEvento()); 
        view.getPuntaje().setOnAction(new puntajeEvento());
    }
    
    public void mostrarVista(){
        Singleton singleton = Singleton.getSingleton();       
        view.mostrar(singleton.getStage());
    }
    
    class iniciarEvento implements EventHandler<ActionEvent>{
 
        @Override
        public void handle(ActionEvent e) {   
            LoopJuegoController controladorloop = new LoopJuegoController(modelo);

            try {
                controladorloop.mostrarVista();
            } catch (IOException ex) {
                Logger.getLogger(VentanamenuController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    class puntajeEvento implements EventHandler<ActionEvent>{
 
        @Override
        public void handle(ActionEvent e) {   
            PuntajeController controladorpuntaje = new PuntajeController(modelo);
            controladorpuntaje.mostrarVista();
        }
    }
}
