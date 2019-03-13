
package Main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Modelo;
import modelo.Usuario;

/**
 *
 * @author kjime
 */
public class VentanafinalController {
    private Modelo modelo;
    private Ventanafinal view;
    
    public VentanafinalController(Modelo modelo) {
      this.modelo = modelo;
      this.view = new Ventanafinal();
       
      view.getRegistrar().setOnAction(new adicionarEvento()); 
      view.getRegresar().setOnAction(new regresarEvento());
    }
    
    public void mostrarVista(){
        Singleton singleton = Singleton.getSingleton();       
        view.mostrar(singleton.getStage());
    }
    
    class regresarEvento implements EventHandler<ActionEvent>{
 
        @Override
        public void handle(ActionEvent e) {   
            MenuController controladormenu = new MenuController(modelo);
            try {
                controladormenu.mostrarVista();
            } catch (IOException ex) {
                Logger.getLogger(VentanafinalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class adicionarEvento implements EventHandler<ActionEvent>{
 
        @Override
        public void handle(ActionEvent e) {   
            view.getMensaje().setText("");
          
            String nombreUser = view.getNombreUserT().getText();
         
            view.getNombreUserT().setText("");
          
            if(nombreUser.isEmpty()){
                view.getMensaje().setText("Ingrese el nombre por favor :)");
            return;
            }
            
            Usuario user = new Usuario(nombreUser);
            boolean erg = modelo.getUsers().add(user);
          
            if(erg){
                view.getMensaje().setText("Información agregada :)");
            }else{
                view.getMensaje().setText("Ya existe la información");
            }
        }    
    }
}
