
package Main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author kjime
 */
public class Ventanapuntaje {
   private Scene scene;
    
   private GridPane grid;
   private StackPane pane;
   private ListView<String> list;   

   private Button regresar;
   private Image image;
   
   public Ventanapuntaje(){
      grid = new GridPane();
      grid.setAlignment(Pos.CENTER);
      grid.setHgap(10);
      grid.setVgap(10);
      grid.setPadding(new Insets(15, 15, 15, 15));
      
      pane = new StackPane();
      list = new ListView<>();
      list.setMinWidth(200);
      grid.add(list, 0, 1);
      
      image = new Image("Images/Nivel2.png");
      ImageView imageV = new ImageView();
      imageV.setImage(image);
      imageV.setFitHeight(520);
      imageV.setFitWidth(810);
      pane.getChildren().add(imageV);
      
      //grid.add(imageV, 0, 5);
      
      regresar = new Button("Regresar");
      grid.add(regresar, 0, 2);
      pane.setAlignment(Pos.CENTER);
      pane.getChildren().add(grid);
      scene = new Scene(pane, 810, 520);
   }
   
   public void mostrar(Stage stage) {
      stage.setTitle("Scores");
      stage.setScene(scene);
      stage.show();
   }

    public ListView<String> getList() {
        return list;
    }

    public Button getRegresar() {
        return regresar;
    }

}
   