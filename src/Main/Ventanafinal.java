
package Main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author kjime
 */
public class Ventanafinal {
    private Scene scene;
    private BorderPane border;
    private GridPane grid;
    private Label nombreUser;
    private TextField nombreUserT;
    private Text mensaje;
    private Button registrar;
    private Button regresar;
    private Image image;
    
    public Ventanafinal(){
        border = new BorderPane();
        
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        image = new Image("Images/Nivel3.png");
        ImageView imageV = new ImageView();
        imageV.setImage(image);
        imageV.setFitHeight(520);
        imageV.setFitWidth(810);
        border.getChildren().add(imageV);
      
        
        nombreUser = new Label("Nombre SuperUsuario: ");
        nombreUserT = new TextField();
        grid.add(nombreUser, 0, 0);
        grid.add(nombreUserT, 0, 1);
        
        HBox hlayout = new HBox();  
        registrar = new Button("Registrar");
        regresar = new Button("Finalizar");
        hlayout.getChildren().add(registrar);
        hlayout.getChildren().add(regresar);
        grid.add(hlayout, 0, 2);
        
        mensaje = new Text();
        grid.add(mensaje, 0, 3);
        
        border.setCenter(grid);
        
        scene = new Scene(border,810,520);
                
    }
    
    public void mostrar(Stage stage) {
        stage.setTitle("Registrar Score");
        stage.setScene(scene);
        stage.show();
    }

    public TextField getNombreUserT() {
        return nombreUserT;
    }

    public Text getMensaje() {
        return mensaje;
    }

    public Button getRegistrar() {
        return registrar;
    }

    public Button getRegresar() {
        return regresar;
    }
  
}
