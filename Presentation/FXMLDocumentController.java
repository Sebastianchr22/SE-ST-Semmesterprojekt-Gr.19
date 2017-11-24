package Presentation;

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

public class FXMLDocumentController implements Initializable{

    private Label label;
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
    private ImageView MapIMG;

    @FXML
    private Rectangle SettingsBackdrop;
    @FXML
    private GridPane SettingsGrid;
    @FXML
    private GridPane HelpGrid;
    @FXML
    private TextArea HelpText;
    @FXML
    private ImageView RoomIMGContainer;
    @FXML
    private GridPane MenuGrid;
    @FXML
    private GridPane SaveGrid;
    @FXML
    private ImageView ScoreIcon;
    @FXML
    private Rectangle ScoreContainer;
    @FXML
    private GridPane ScoreGrid;
    @FXML
    private ImageView BackIcon;
    @FXML
    private AnchorPane HelpPane;
    @FXML
    private Rectangle HelpContainer;
    @FXML
    private Rectangle SettingsContainer;
    @FXML
    private ImageView SettingsQuit;
    @FXML
    private Rectangle Quitcontainer;
    @FXML
    private Rectangle Loadcontainer;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        RoomIMGContainer.setFitHeight(ClickerPane.getPrefHeight());
        RoomIMGContainer.setFitWidth(ClickerPane.getPrefWidth());
        RoomIMGContainer.setPreserveRatio(true);

        ChangeSaveMenu(0, true);
        ChangeHelpState(0, true);

        SettingsBackdrop.setOpacity(0);
        SettingsBackdrop.setDisable(true);

        MapIMG.setOpacity(0);
        MapIMG.setDisable(true);

        MenuGrid.setDisable(false);
        SettingsGrid.setDisable(true);

        ScoreGrid.setDisable(true);
        ScoreGrid.setOpacity(0);

        BackIcon.setOpacity(0);
        BackIcon.setDisable(true);

    }

    public void setHelpText(String string) {
        HelpText.setText(string);
    }

    @FXML
    private void PaneClicked(MouseEvent event) {
        Point Table = new Point(279, 237);
        ClickableField Keys = new ClickableField(Table, 100, 250);
        if (Keys.hit(event)) {
            //Call method for specific command:
            System.out.println("KEYS");
        }

        Point Door = new Point(640, 10);
        ClickableField door = new ClickableField(Door, 310, 130);
        if (door.hit(event)) {
            //Call method for specific command:
            System.out.println("WORK");
        }
    }

    @FXML
    private void MouseMoved(MouseEvent event) {
        coordinates.setText("(" + event.getX() + "," + event.getY() + ")");
    }

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
        System.out.println("Show settings");
        MenuGrid.setDisable(false);
        SettingsGrid.setDisable(false);
        ChangeSaveMenu(1, false);
        ChangeGameState(true);
    }

    private void ChangeGameState(boolean bool) {
        ClickerPane.setDisable(bool);
        textContainer.setDisable(bool);
    }

    private void ChangeHelpState(int value, boolean bool) {
        HelpGrid.setOpacity(value);
        HelpGrid.setDisable(bool);
    }

    //Show save load quit menu:
    private void ChangeSaveMenu(int value, boolean bool) {
        SettingsBackdrop.setOpacity(value);
        SettingsGrid.setDisable(bool);
        SettingsGrid.setOpacity(value);

    }

    @FXML
    private void CloseSettings(MouseEvent event) {
        SettingsGrid.setDisable(true);
        MenuGrid.setDisable(false);
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
        System.out.println("Help!");
        ChangeHelpState(0, true);
    }

    @FXML
    private void HelpHover(MouseEvent event) {
        ChangeHelpState(1, true);
        HelpText.setText("HELP!");
    }

    @FXML
    private void ShowScore(MouseEvent event) {
        SaveGrid.setDisable(true);
        SaveGrid.setOpacity(0);

        ScoreGrid.setDisable(false);
        BackIcon.setDisable(false);
        BackIcon.setOpacity(1);
        SettingsQuit.setOpacity(0);
        SettingsQuit.setDisable(true);

    }

    @FXML
    private void CloseScore(MouseEvent event) {
        ScoreGrid.setDisable(true);
        ScoreGrid.setOpacity(0);

        SaveGrid.setDisable(false);
        SaveGrid.setOpacity(1);
        BackIcon.setDisable(true);
        BackIcon.setOpacity(0);

        SettingsQuit.setOpacity(1);
        SettingsQuit.setDisable(false);
    }

}
