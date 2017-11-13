/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.stage.Stage;

/**
 *
 * @author Obel
 */
public class PrettyWomanFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("StartScreenFXML.fxml"));

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Image icon = new Image(getClass().getResourceAsStream("Visuals/Icons/Icon.png"));
        stage.getIcons().add(icon);
        stage.setTitle("Pretty Woman - The Game");
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setMinHeight(600);
        stage.setMinWidth(800);
        stage.setHeight(600);
        stage.setWidth(800);
        stage.setResizable(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
