/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Obel
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private GridPane menuBar;
    @FXML
    private Label coordinates;
    @FXML
    private TextArea textOutput;
    @FXML
    private GridPane IMGContainer;
    @FXML
    private AnchorPane ClickerPane;
    @FXML
    private GridPane textContainer;
    @FXML
    private AnchorPane StatusContainer;
    @FXML
    private Circle StatusCircle;
    @FXML
    private Label StatusLabel;
    @FXML
    private ImageView MapIMG;

    @FXML
    private Rectangle SettingsBackdrop;
    @FXML
    private Rectangle Quitcontainer;
    @FXML
    private Rectangle Savecontainer;
    @FXML
    private Label Quittext;
    @FXML
    private Label Loadtext;
    @FXML
    private Label Savetext;
    @FXML
    private ImageView Saveicon;
    @FXML
    private ImageView Loadicon;
    @FXML
    private Rectangle Loadcontainer;
    @FXML
    private Rectangle SettingsContainer;
    @FXML
    private ImageView SettingsQuit;
    @FXML
    private GridPane SettingsGrid;
    @FXML
    private GridPane HelpGrid;
    @FXML
    private AnchorPane HelpPane;
    @FXML
    private Rectangle HelpContainer;
    @FXML
    private TextArea HelpText;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ChangeSaveMenu(0, true);
        ChangeHelpState(0,true);

        SettingsBackdrop.setOpacity(0);
        SettingsBackdrop.setDisable(true);

        MapIMG.setOpacity(0);
        MapIMG.setDisable(true);

        SettingsGrid.setDisable(true);

    }
    public void setHelpText(String string){
        HelpText.setText(string);
    }

    @FXML
    private void PaneClicked(MouseEvent event) {
        System.out.println("You clicked the pane");
    }

    @FXML
    private void MouseMoved(MouseEvent event) {
        coordinates.setText("(" + event.getX() + "," + event.getY() + ")");
    }

    //@FXML
    /*private void ShowStatus(MouseEvent event) {
        if (StatusContainer.isDisable()) {
            StatusContainer.setOpacity(1);
            StatusContainer.setDisable(false);
            StatusLabel.setText("Enabled");
        } else {
            StatusContainer.setOpacity(0);
            StatusContainer.setDisable(true);
            StatusLabel.setText("Disabled");
        }

    }*/
    @FXML
    private void ShowInventory(MouseEvent event) {
        System.out.println("Inv clicked");
    }

    @FXML
    private void ShowMap(MouseEvent event) {
        if (MapIMG.isDisable()) {
            MapIMG.setDisable(false);
            MapIMG.setOpacity(1);
        } else {
            MapIMG.setDisable(true);
            MapIMG.setOpacity(0);
        }
    }

    @FXML
    private void ShowSettings(MouseEvent event) {
        if (Savetext.getOpacity() == 0) {
            ChangeHelpState(0,true);
            SettingsGrid.setDisable(false);
            System.out.println("Will open settings");
            ChangeSaveMenu(1, false);
            ChangeGameState(true);
        }
    }

    private void ChangeGameState(boolean bool) {
        ClickerPane.setDisable(bool);
        menuBar.setDisable(bool);
        textContainer.setDisable(bool);
    }
    private void ChangeHelpState(int value, boolean bool){
        HelpGrid.setOpacity(value);
        HelpContainer.setOpacity(value);
        HelpText.setOpacity(value);
        HelpPane.setOpacity(value);
        
        HelpGrid.setDisable(bool);
        HelpContainer.setDisable(bool);
        HelpText.setDisable(bool);
        HelpPane.setDisable(bool);
    }

    //Show save load quit menu:
    private void ChangeSaveMenu(int value, boolean bool) {
        SettingsBackdrop.setOpacity(value);
        //Set Opacity:
        Savetext.setOpacity(value);
        Saveicon.setOpacity(value);
        Savecontainer.setOpacity(value);

        Loadtext.setOpacity(value);
        Loadicon.setOpacity(value);
        Loadcontainer.setOpacity(value);

        Quittext.setOpacity(value);
        Quitcontainer.setOpacity(value);

        SettingsContainer.setOpacity(value);
        SettingsQuit.setOpacity(value);

        //Enable:
        Savetext.setDisable(bool);
        Saveicon.setDisable(bool);
        Savecontainer.setDisable(bool);

        Loadtext.setDisable(bool);
        Loadicon.setDisable(bool);
        Loadcontainer.setDisable(bool);

        Quittext.setDisable(bool);
        Quitcontainer.setDisable(bool);

        SettingsContainer.setDisable(bool);
        SettingsQuit.setDisable(bool);
        System.out.println("set to " + bool);

    }

    @FXML
    private void CloseSettings(MouseEvent event) {
        SettingsGrid.setDisable(true);
        ChangeSaveMenu(0, true);
        ChangeGameState(false);
        System.out.println("Closed");
    }

    @FXML
    private void QuitGame(MouseEvent event) {
        System.out.println("Quit");
        Platform.exit();
    }

    @FXML
    private void LoadGame(MouseEvent event) {
        System.out.println("Load");
    }

    @FXML
    private void SaveGame(MouseEvent event) {
        System.out.println("Save");
    }

    @FXML
    private void ShowStats(MouseEvent event) {
        System.out.println("Stats");
    }

    @FXML
    private void HelpClicked(MouseEvent event) {
        System.out.println("Help clicked");
    }

    @FXML
    private void HelpExited(MouseEvent event) {
        ChangeHelpState(0,true);
    }

    @FXML
    private void HelpHover(MouseEvent event) {
        ChangeHelpState(1,true);
    }

}
