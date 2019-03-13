
package Main;

import Database.GestionArchivo;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author kjime
 */
public class VentanafinalController {
    private Modelo modelo;
    private Ventanafinal view;
    private String score;
    
    public VentanafinalController(Modelo modelo) {
      this.modelo = modelo;
      this.view = new Ventanafinal();
       
      view.getRegistrar().setOnAction(new adicionarEvento()); 
      view.getRegresar().setOnAction(new regresarEvento());
    }

    public void setScore(String score) {
        this.score = score;
    }
    
    public void mostrarVista(){
        Singleton singleton = Singleton.getSingleton();       
        view.mostrar(singleton.getStage());
    }
    
    class regresarEvento implements EventHandler<ActionEvent>{
 
        @Override
        public void handle(ActionEvent e) {   
            VentanamenuController controladormenu = new VentanamenuController(modelo);
            controladormenu.mostrarVista();
        }
    }
    
    class adicionarEvento implements EventHandler<ActionEvent>{
 
        @Override
        public void handle(ActionEvent e) { 
            view.getMensaje().setText("");
            GestionArchivo archivo = new GestionArchivo("datos.txt");
          
            String nombreUser = view.getNombreUserT().getText();
         
            view.getNombreUserT().setText("");
          
            if(nombreUser.isEmpty()){
                view.getMensaje().setText("Ingrese el nombre por favor :)");
            return;
            }
            
            String erg = null;
            erg = modelo.getUsers().put(nombreUser, score);
            
            if(erg==null){
                view.getMensaje().setText("Información agregada :)");
                try {
                    if(archivo.saveUsers(modelo.getUsers())){
                        System.out.println("Información guardada en archivo");
                    }else{
                        System.out.println("No se guardo la informacion");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(VentanafinalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                view.getMensaje().setText("Ya existe la información");
            }
        }    
    }
}
