package presentation;

import acq.IGUI;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import logic.Manager;

public class FXMLDocumentController implements Initializable {

    private IGUI gui;
    private String currentRoom;
    @FXML
    private Label coordinates;
    @FXML
    private AnchorPane ClickerPane;
    @FXML
    private GridPane textContainer;
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
    private GridPane ScoreGrid;
    @FXML
    private ImageView BackIcon;
    @FXML
    private ImageView SettingsQuit;
    @FXML
    private TextArea textOutput;
    @FXML
    private GridPane StatusGrid;
    @FXML
    private Rectangle HungerMeter;
    @FXML
    private Label MoneyAmount;
    @FXML
    private Label ExpAmount;
    @FXML
    private Label EnhAmount;
    @FXML
    private Label CapacityAmount;
    @FXML
    private Label MovesAmount;
    @FXML
    private GridPane InvGrid;
    @FXML
    private ListView<acq.IItem> InventoryListView;
    @FXML
    private Label DaysAmount;
    @FXML
    private Label HungerString;
    @FXML
    private GridPane InvitationGrid;

    private acq.IItem item;

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

        StatusGrid.setOpacity(0);
        StatusGrid.setDisable(true);

        InvGrid.setOpacity(0);
        InvGrid.setDisable(true);

        InvitationGrid.setOpacity(0);
        InvitationGrid.setDisable(true);

        gui = PresentationFacade.getInstance();

        //Load items into inventory tab::
        InventoryListView.setItems(gui.getInventory());
        InventoryListView.getSelectionModel().selectedItemProperty().addListener(evt -> {
            item = InventoryListView.getSelectionModel().getSelectedItem();
        });
        this.currentRoom = gui.getCurrentRoom();
        setRoomImage();
        textOutput.setText("Welcome to Pretty Woman - the Game. This a point and click adventure, so make sure to explore your surroundings, and to always manage your home life, and do your job well. \nA key goal of this game is to collect items, and manage to survive long enough to find your mr. perfect.");
        coordinates.setOpacity(0);
    }

    public void changeInvitationState(int i, boolean bool) {
        InvitationGrid.setOpacity(i);
        InvitationGrid.setDisable(bool);

    }

    ClickableField keys;
    ClickableField door;
    ClickableField car;
    ClickableField home;
    ClickableField lockerroom;
    ClickableField dancefloor;
    ClickableField stealC;
    ClickableField backroom;
    ClickableField danceC;
    ClickableField outside;
    ClickableField enter;
    ClickableField flirt;
    ClickableField privateroomC;

    public void setHitBoxes() {
        String pos = gui.getCurrentRoom();
        switch (pos) {
            case "HOME":
                Point Door = new Point(640, 10);
                door = new ClickableField(Door, 310, 130);
                Point Table = new Point(279, 237);
                keys = new ClickableField(Table, 100, 250);
                break;

            case "DRIVE":
                door.destroy();
                keys.destroy();
                Point cardoor = new Point(333, 150);
                car = new ClickableField(cardoor, 150, 200);
                Point homedoor = new Point(0, 0);
                home = new ClickableField(homedoor, 370, 225);
                break;

            case "BACKROOM":
                home.destroy();
                car.destroy();
                Point locker = new Point(515, 15);
                lockerroom = new ClickableField(locker, 350, 115);
                Point dance = new Point(350, 90);
                dancefloor = new ClickableField(dance, 100, 100);
                break;

            case "LOCKER ROOM":
                lockerroom.destroy();
                dancefloor.destroy();
                Point steal = new Point(100, 95);
                stealC = new ClickableField(steal, 190, 170);
                Point back = new Point(0, 300);
                backroom = new ClickableField(back, 80, 790);
                break;

            case "DANCE FLOOR":
                lockerroom.destroy();
                dancefloor.destroy();
                Point dancer = new Point(433, 65);
                danceC = new ClickableField(dancer, 210, 277);
                Point out = new Point(251, 81);
                outside = new ClickableField(out, 200, 120);
                back = new Point(0, 300);
                backroom = new ClickableField(back, 80, 790);
                break;

            case "OUTSIDE":
                danceC.destroy();
                outside.destroy();
                backroom.destroy();
                Point dancefloor = new Point(168, 250);
                enter = new ClickableField(dancefloor, 120, 180);
                Point bouncer = new Point(666, 280);
                flirt = new ClickableField(bouncer, 80, 130);
                break;

            case "PRIVATE ROOM":
                danceC.destroy();
                outside.destroy();
                backroom.destroy();
                Point privateroom = new Point(0, 0);
                privateroomC = new ClickableField(privateroom, 400, 800);
                break;
        }
    }

    public String processCommands(String command) {
        String val = "";

        if (gui.getMoves() > 0) {
            this.currentRoom = gui.getCurrentRoom();

            if (gui.managerPlayerSameRoom()) {
                val += gui.managerTakesCut();
            }
            val += gui.processCommand(command);
            InventoryListView.setItems(gui.getInventory());
            InventoryListView.refresh();
            if (!this.currentRoom.equals(gui.getCurrentRoom())) {
                setRoomImage();
            }
            if (this.currentRoom.equals("PRIVATEROOM")) {
                //Did not update image, because you are in the same room twice.
                setRoomImage();
            }

            setHitBoxes();
            return val;
        } else {
            gui.processCommand("HOME");
            setRoomImage();
            setHitBoxes();
            gui.removeDaysLeft();

            return val + " You went home, after a long day at work. Time to take care of you and your daughter.";
        }
    }

    public void setRoomImage() {
        System.out.println("you are at: " + gui.getCurrentRoom());
        String path = "FXML/Visuals/Highres/800x400/" + gui.getCurrentRoom() + ".jpg";
        Image room = new Image(path, true);
        RoomIMGContainer.setImage(room);
    }

    public void setTextOutput(String s) {
        textOutput.setText(s);
    }

    public void setHelpText() {
        HelpText.setText(gui.getRoomHelpText());
        HelpText.setOpacity(1);
    }

    @FXML
    private void PaneClicked(MouseEvent event) {
        String val = "";
        if (gui.getPRoomInvite() && !gui.getCurrentRoom().equals("PRIVATE ROOM") && gui.getCurrentRoom().equals("DANCE FLOOR")) {
            changeInvitationState(1, false);
        } else {
            changeInvitationState(0, true);
        }
        setHitBoxes();
        if (gui.getCurrentRoom().equals("HOME")) {
            if (keys.hit(event)) {
                val += processCommands("KEYS");
            }
            if (door.hit(event)) {
                val += processCommands("WORK");
            }
        } else if (gui.getCurrentRoom().equals("DRIVE")) {
            if (home.hit(event)) {
                val += processCommands("HOME");
            }
            if (car.hit(event)) {
                val += processCommands("CAR");
            }
        } else if (gui.getCurrentRoom().equals("BACKROOM")) {
            if (lockerroom.hit(event)) {
                val += processCommands("LOCKER");
            }
            if (dancefloor.hit(event)) {
                val += processCommands("DANCEFLOOR");
            }
        } else if (gui.getCurrentRoom().equals("LOCKER ROOM")) {
            if (stealC.hit(event)) {
                val += processCommands("STEAL");

            }
            if (backroom.hit(event)) {
                val += processCommands("BACKROOM");

            }
        } else if (gui.getCurrentRoom().equals("DANCE FLOOR")) {
            if (danceC.hit(event)) {
                val += processCommands("DANCE");

            }
            if (outside.hit(event)) {
                val += processCommands("OUTSIDE");
            }
            if (backroom.hit(event)) {
                val += processCommands("BACKROOM");
            }
        } else if (gui.getCurrentRoom().equals("OUTSIDE")) {
            if (flirt.hit(event)) {
                val += processCommands("FLIRT");
            }
            if (enter.hit(event)) {
                val += processCommands("DANCEFLOOR");
            }
        } else if (gui.getCurrentRoom().equals("PRIVATE ROOM")) {
            if (privateroomC.hit(event)) {
                gui.setPrivateRoomCommand("DANCE");
                val += processCommands("PRIVATEROOM");
            }
        }

        setTextOutput(val);
    }

    @FXML
    private void MouseMoved(MouseEvent event) {
        //coordinates.setText("(" + event.getX() + "," + event.getY() + ")");
        coordinates.setOpacity(0);
    }

    @FXML
    private void ShowInventory(MouseEvent event) {
        ChangeMapState(0, true);
        ChangeStatusState(0, true);
        InventoryListView.setItems(gui.getInventory());

        InventoryListView.refresh();
        if (InvGrid.isDisabled()) {
            //Enable
            InvGrid.setOpacity(1);
            InvGrid.setDisable(false);
        } else {
            //Disable
            InvGrid.setOpacity(0);
            InvGrid.setDisable(true);
        }
    }

    public void ChangeInventoryState(int i, boolean bool) {
        InvGrid.setOpacity(i);
        InvGrid.setDisable(bool);
    }

    public void ChangeMapState(int i, boolean bool) {
        MapIMG.setOpacity(i);
        MapIMG.setDisable(bool);
    }

    public void ChangeStatusState(int i, boolean bool) {
        StatusGrid.setOpacity(i);
        StatusGrid.setDisable(bool);
    }

    @FXML
    private void ShowMap(MouseEvent event) {
        ChangeInventoryState(0, true);
        ChangeStatusState(0, true);
        String path = "FXML/Visuals/Highres/Map/" + gui.getCurrentRoom() + ".png";
        Image map = new Image(path, true);
        MapIMG.setImage(map);

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
        MenuGrid.setDisable(false);
        SettingsGrid.setDisable(false);
        ChangeSaveMenu(1, false);
        ChangeGameState(true);
    }

    private void ChangeGameState(boolean bool) {
        ClickerPane.setDisable(bool);
        textContainer.setDisable(bool);

        StatusGrid.setOpacity(0);
        StatusGrid.setDisable(true);

        InvGrid.setOpacity(0);
        InvGrid.setDisable(true);
        MapIMG.setDisable(true);
        MapIMG.setOpacity(0);
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
    }

    @FXML
    private void QuitGame(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    private void LoadGame(MouseEvent event) {
        gui.load();

        SettingsGrid.setDisable(true);
        MenuGrid.setDisable(false);
        ChangeSaveMenu(0, true);
        ChangeGameState(false);
        InventoryListView.getItems().clear();
        InventoryListView.setItems(gui.getInventory());

        InventoryListView.refresh();

    }

    @FXML
    private void SaveGame(MouseEvent event) {
        gui.save();
        SettingsGrid.setDisable(true);
        MenuGrid.setDisable(false);
        ChangeSaveMenu(0, true);
        ChangeGameState(false);
    }

    private double calcHunger() {
        return 320.0 * (gui.getHunger() / 100.0);
    }

    @FXML
    private void ShowStats(MouseEvent event) {
        ChangeMapState(0, true);
        ChangeInventoryState(0, true);
        if (StatusGrid.isDisabled()) {
            //Enable
            StatusGrid.setOpacity(1);
            StatusGrid.setDisable(false);

            getStatusInfo();

        } else {
            //Disable
            StatusGrid.setOpacity(0);
            StatusGrid.setDisable(true);
        }

    }

    public void getStatusInfo() {
        MoneyAmount.setText("$" + String.valueOf(Math.round(gui.getMoney() * 100.0) / 100.0));
        ExpAmount.setText(String.valueOf(gui.getExp()));
        EnhAmount.setText(String.valueOf(gui.getEnh()));
        MovesAmount.setText(String.valueOf(gui.getMoves()));
        DaysAmount.setText(String.valueOf(gui.getDaysLeft()));
        CapacityAmount.setText(gui.getCapacity());
        HungerString.setText(gui.getShortHunger());
        HungerMeter.setWidth(calcHunger());
    }

    @FXML
    private void HelpClicked(MouseEvent event) {
        System.out.println("Help clicked");
    }

    @FXML
    private void HelpExited(MouseEvent event) {
        ChangeHelpState(0, true);
    }

    @FXML
    private void HelpHover(MouseEvent event) {
        ChangeHelpState(1, true);
        setHelpText();
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

    @FXML
    private void BuyEnhancements(MouseEvent event) {
        gui.buyEnh();
        getStatusInfo();
    }

    @FXML
    private void BuyFood(MouseEvent event) {
        gui.buyFood();
        getStatusInfo();
    }

    @FXML
    private void DropItem(MouseEvent event) {
        item = InventoryListView.getSelectionModel().getSelectedItem();

        if (item != null) {
            gui.removeItem(item);
            System.out.println("Dropped: " + item.getName());
        } else {
        }
        InventoryListView.setItems(gui.getInventory());
        InventoryListView.refresh();
    }

    @FXML
    private void InspectItem(MouseEvent event) {
        item = InventoryListView.getSelectionModel().getSelectedItem();
        if (item != null) {
            String values = "A(n) " + item.getCat() + " item." + "\n" + item.getName() + " - " + item.getDesc();
            textOutput.setText(values);
            InventoryListView.refresh();
        }
    }

    @FXML
    private void AcceptInvitation(MouseEvent event
    ) {
        if (gui.getPRoomInvite() == true) {

            textOutput.clear();
            gui.setPrivateRoomCommand("ACCEPT");
            setTextOutput(gui.processCommand("PRIVATEROOM"));
            changeInvitationState(0, true);
            setRoomImage();
            gui.setPrivateRoomCommand(null);
        }
    }

    @FXML
    private void DeclineInvitation(MouseEvent event
    ) {
        if (gui.getPRoomInvite() == true) {
            textOutput.clear();
            gui.setPrivateRoomCommand("REJECT");
            setTextOutput(gui.processCommand("PRIVATEROOM"));
            changeInvitationState(0, true);
            gui.setPrivateRoomCommand(null);
        }
    }

    @FXML
    private void InfoOnRegular(MouseEvent event
    ) {
        if (gui.getPRoomInvite() == true) {
            textOutput.setText(gui.getRegularInRoomInfo());
        }
    }

}
