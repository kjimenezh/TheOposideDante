
package Main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author kjime
 */
public class Ventanamenu {
    private Scene scene;

    private GridPane grid;
    private StackPane pane; 

    private Button iniciar;
    private Button puntaje;
    private Image image;

    public Ventanamenu(){
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15, 15, 15, 15));

        pane = new StackPane();

        image = new Image("Images/inicio.png");
        ImageView imageV = new ImageView();
        imageV.setImage(image);
        imageV.setFitHeight(520);
        imageV.setFitWidth(810);
        pane.getChildren().add(imageV);

        //grid.add(imageV, 0, 5);

        iniciar = new Button("START");
        puntaje = new Button("Puntajes");
        grid.add(iniciar, 0, 0);
        grid.add(puntaje, 0, 4);
        
        
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().add(grid);
        scene = new Scene(pane, 810, 520);
    }

    public void mostrar(Stage stage) {
        stage.setTitle("The Oposide Dante");
        stage.setScene(scene);
        stage.show();
    }

    public Button getIniciar() {
        return iniciar;
    }

    public Button getPuntaje() {
        return puntaje;
    }

}

