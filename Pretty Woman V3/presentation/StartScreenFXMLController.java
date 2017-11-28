package presentation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.*;
import java.util.Random;
import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class StartScreenFXMLController implements Initializable {

    @FXML
    private ImageView Background;

    private boolean bool;
    Image lightsOn = new Image(getClass().getResource("Visuals/Splashscreen 800x600.jpg").toExternalForm());
    Image lightsOff = new Image(getClass().getResource("Visuals/Splashscreen 800x600 Lightsoff.jpg").toExternalForm());
    @FXML
    private TextArea HelpText;
    @FXML
    private ImageView NewGameImg;
    @FXML
    private Label NewGameText;
    @FXML
    private Rectangle NewGameContainer;
    @FXML
    private Rectangle LoadGameContainer;
    @FXML
    private Label LoadGameText;
    @FXML
    private ImageView LoadGameImg;
    @FXML
    private Rectangle QuitGameContainer;
    @FXML
    private Label QuitGameText;
    @FXML
    private Rectangle HoverDarken;
    @FXML
    private GridPane HelpGrid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ChangeHoverState(0, true);
        HelpText.setWrapText(true);
        setHoverText("Welcome to Pretty Woman - The Game!" + "\n" + "HOW TO PLAY:" + "\n" + "to play, click on the images presented in game to do a certain thing in the game." + "\n" + "You should avoid letting your daughter go hungry for too long, and make sure not to spend too much money" + "\n" + "Your end goal is to find the richest man in the club, and end up with him in the private room... Who knows maybe he likes you.");
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
    private void setHoverText(String val){
        HelpText.setText(val);
    }

    public void ChangeHoverState(int val, boolean bool) {
        HelpGrid.setOpacity(val);
        HoverDarken.setOpacity(val);
        HoverDarken.setDisable(bool);

        HelpGrid.setDisable(bool);
        HelpText.setOpacity(val);
        HelpText.setDisable(bool);
    }

    private void lightSwitch(Image image) {
        Background.setImage(image);
    }

    @FXML
    private void HelpExited(MouseEvent event) {
        ChangeHoverState(0, true);
        System.out.println("Hover ended");
    }

    @FXML
    private void HelpHover(MouseEvent event) {
        System.out.println("Hover started");
        ChangeHoverState(1, true);
    }

    @FXML
    private void NewGame(MouseEvent event) {        
        System.out.println("New Game");

    }

    @FXML
    private void LoadGame(MouseEvent event) {
        System.out.println("Load Game");
    }

    @FXML
    private void QuitGame(MouseEvent event) {
        Platform.exit();
    }

}
