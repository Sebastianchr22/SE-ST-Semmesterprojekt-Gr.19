package presentation;

import acq.IGUI;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    
    private IGUI gui;

    Image lightsOn = new Image(getClass().getResource("../FXML/Visuals/Splashscreen 800x600.jpg").toExternalForm());
    Image lightsOff = new Image(getClass().getResource("../FXML/Visuals/Splashscreen 800x600 Lightsoff.jpg").toExternalForm());
    @FXML
    private TextArea HelpText;
    @FXML
    private Rectangle HoverDarken;
    @FXML
    private GridPane HelpGrid;

    /**
     * Initializes the controller class. While hiding the helpGrid, and getting an instance of the IGUI gui.
     * the text to be displayed on hover (help) is also set here and called to be set.
     * effect method is called to choose between which background image is to be set.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gui = PresentationFacade.getInstance();
        // TODO
        ChangeHoverState(0, true);
        HelpText.setWrapText(true);
        setHoverText("Welcome to Pretty Woman - The Game!" + "\n" + "HOW TO PLAY:" + "\n" + "to play, click on the images presented in game to do a certain thing in the game." + "\n" + "You should avoid letting your daughter go hungry for too long, and make sure not to spend too much money" + "\n" + "Your end goal is to find the richest man in the club, and end up with him in the private room... Who knows maybe he likes you.");
        effect();
    }

    /**
     * Will generate a random from 1- 100, if the random is larger than or equal to 50, the image will be lightsoff, else lightson.
     */
    private void effect() {
        Random rand = new Random();
        int num = rand.nextInt(100) + 1;
        if (num >= 50) {
            lightSwitch(lightsOff);
        } else {
            lightSwitch(lightsOn);
        }
    }
    
    /**
     * Will set the text in the helpGrid according to the given string.
     * @param val 
     */
    private void setHoverText(String val){
        HelpText.setText(val);
    }

    /**
     * This method changes the opacity and may disable everything in the helpGrid.
     * @param val opacity value, 0- 1.0
     * @param bool diabled true / false
     */
    public void ChangeHoverState(int val, boolean bool) {
        HelpGrid.setOpacity(val);
        HoverDarken.setOpacity(val);
        HoverDarken.setDisable(bool);

        HelpGrid.setDisable(bool);
        HelpText.setOpacity(val);
        HelpText.setDisable(bool);
    }

    /**
     * called to set an image as the background image, two options exist, lights off or on, this gives a new look to the menu each time it is loaded.
     * @param image takes an image to set as the background image
     */
    private void lightSwitch(Image image) {
        Background.setImage(image);
    }

    /**
     * Hides the help grid, when the icon is no longer hovered.
     * @param event given on mouse exit
     */
    @FXML
    private void HelpExited(MouseEvent event) {
        ChangeHoverState(0, true);
        System.out.println("Hover ended");
    }

    /**
     * this method is called when the user hovers over the help icon in the main menu. 
     * <p> This will call the ChangeHoverState, which will display the help text.
     * @param event given as it is called on mouse enter
     */
    @FXML
    private void HelpHover(MouseEvent event) {
        System.out.println("Hover started");
        ChangeHoverState(1, true);
    }

    /**
     * This method calls the newGame method on the logic layer, through the presentation facade on click.
     * @param event given, as the method is called on click
     */
    @FXML
    private void NewGame(MouseEvent event) {        
        System.out.println("New Game");
        gui.newGame(event);
    }

    /**
     * This method will call the load method on the data layer through the presentation facade.
     * @param event 
     */
    @FXML
    private void LoadGame(MouseEvent event) {
        System.out.println("Load Game");
        gui.loadGame(event);
    }

    /**
     * calls for the platform to exit on click.
     * @param event 
     */
    @FXML
    private void QuitGame(MouseEvent event) {
        Platform.exit();
    }

}
