package Presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.stage.Stage;
public class PrettyWomanFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("StartScreenFXML.fxml"));

        Parent root = FXMLLoader.load(getClass().getResource("Presentation/FXMLDocument.fxml"));
        Image icon = new Image(getClass().getResourceAsStream("Visuals/Icons/Icon.png"));
        stage.getIcons().add(icon);
        stage.setTitle("Pretty Woman - The Game");
        Scene scene = new Scene(root);

        
        stage.setMinHeight(600);
        stage.setMinWidth(800);
        stage.setHeight(600);
        stage.setWidth(800);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
