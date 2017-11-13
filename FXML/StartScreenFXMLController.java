/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.*;
import java.util.Random;

/**
 * FXML Controller class
 *
 * @author Sebas
 */
public class StartScreenFXMLController implements Initializable {

    @FXML
    private ImageView Background;
    @FXML
    private Label TextPrompt;

    private boolean bool;
    Image lightsOn = new Image(getClass().getResource("Visuals/Splashscreen 800x600.jpg").toExternalForm());
    Image lightsOff = new Image(getClass().getResource("Visuals/Splashscreen 800x600 Lightsoff.jpg").toExternalForm());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        effect();
    }

    private void effect() {
        Random rand = new Random();
        int num = rand.nextInt(100) + 1;
        if (num >= 50) {
            lightSwitch(lightsOff);
        } else {
            lightSwitch(lightsOn);
        }
    }

    private void lightSwitch(Image image) {
        Background.setImage(image);
    }

    @FXML
    private void StartClicked(MouseEvent event) {
        bool = true;

    }

}
