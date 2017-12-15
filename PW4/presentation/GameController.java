package presentation;

import acq.IGUI;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class GameController implements Initializable {

    private IGUI gui;
    private acq.IItem item;

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
    @FXML
    private ListView<?> ScoresListView;
    @FXML
    private GridPane GameWonGrid;
    @FXML
    private GridPane GameLostGrid;
    @FXML
    private GridPane WelcomeGrid;

    /**
     * Sets all default values of the FXML document. This includes disabling the
     * layered FXML grids, grids include, Status grid, Score grid, inventory
     * grid inv grid, and more. Also the showGameLost, and showGameWon are also
     * disabled, and instance of the IGUI is fetched. The inventory listview is
     * set and refreshed. The introduction text is displayed, and the background
     * image is set to the image of HOME.
     *
     * @param url
     * @param rb
     */
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

        showGameWon(0, true);
        showGameLost(0, true);

        gui = PresentationFacade.getInstance();

        //Load items into inventory tab::
        InventoryListView.setItems(gui.getInventory());
        InventoryListView.getSelectionModel().selectedItemProperty().addListener(evt -> {
            item = InventoryListView.getSelectionModel().getSelectedItem();
        });
        this.currentRoom = gui.getCurrentRoom();
        setRoomImage();
        textOutput.setText("Welcome to Pretty Woman - the Game. This a point and click adventure, so make sure to explore your surroundings, and to always manage your home life, and do your job well. \nA key goal of this game is to collect items, and manage to survive long enough to find your mr. perfect.\nYou can always hover over the questionmark icon for more help, in case you get lost.");
        coordinates.setOpacity(0);

        //Fixed issue of replay option using the previous bacground image, and not displaying home on reload.
        String path = "FXML/Visuals/Highres/800x400/HOME.jpg";
        Image room = new Image(path, true);
        RoomIMGContainer.setImage(room);
    }

    /**
     * Disbables or enables the inventory grid, also sets the opacity
     *
     * @param i : Integer
     * @param bool : Boolean
     */
    public void changeInvitationState(int i, boolean bool) {
        InvitationGrid.setOpacity(i);
        InvitationGrid.setDisable(bool);

    }

    //sets all clickable fields as privates:
    private ClickableField keys;
    private ClickableField door;
    private ClickableField car;
    private ClickableField home;
    private ClickableField lockerroom;
    private ClickableField dancefloor;
    private ClickableField stealC;
    private ClickableField backroom;
    private ClickableField danceC;
    private ClickableField outside;
    private ClickableField enter;
    private ClickableField flirt;
    private ClickableField privateroomC;
    private ClickableField office;

    /**
     * Uses the name of the currentroom, (String) as a switch case parameter.
     * According to the name of the currentroom of the player, a set of
     * clickable fields are created, and the previous room's ones are destroyed.
     *
     * <p>
     * specific hitboxes are created for each individual room, this is done by
     * pixel count. A point is created, as it is to be used as a measurement of
     * the x-axis offset, and the y-axis offset. Then a width and a height is
     * set for the clickable field. When any room other than home has it's
     * hitboxes set, the prior rooms hitboxes are destroyed, this means that the
     * prior rooms hitboxses's offesets, width, and height are set to 0. making
     * them unclickable.
     */
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
                Point officedoor = new Point(464, 63);
                office = new ClickableField(officedoor, 200, 30);
                break;

            case "LOCKER ROOM":
                lockerroom.destroy();
                dancefloor.destroy();
                office.destroy();
                Point steal = new Point(100, 95);
                stealC = new ClickableField(steal, 190, 170);
                Point back = new Point(0, 300);
                backroom = new ClickableField(back, 80, 790);
                break;

            case "DANCE FLOOR":
                lockerroom.destroy();
                dancefloor.destroy();
                office.destroy();
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

    /**
     * This method is used with the Presentation layer facade, to process a
     * command given by a simple data type (String, Integer, such.), the
     * processing will happen at the business layer. Checks are being run along
     * the way, to make sure that the game is not yet won, and that the game is
     * not yet lost. A check is also run to see if the player has any more moves
     * left. This method will return a String, to be displayed as it contains an
     * explanation of what happened, as feedback to the player.
     *
     * <p>
     * Takes a String command parameter. Will check if game is won already, if
     * the player has lost (no money, hunger empty, or money), or if the player
     * has any more moves left. if the game is won, call showGameWon(). if game
     * is lost, call showGameLost(). if more moves are left, checks if manager
     * and player are in the same room (Boolean), calls gui.managerTakesCut().
     * Will then process command<p>
     *
     * <p>
     * When the prior if's have been run through, this method will process the
     * given String command, by parsing it to the presentation facade. this
     * returns a string, which is added to the String val, which is returned.
     * The inventory listview is updated, and refreshed. If the player has
     * entered a new room since last time this method was run, the background
     * image is updated.<p>
     *
     * <p>
     * new hitboxes are set, and val is returned after all this.<p>
     *
     * <p>
     * If the player has no more moves left, this method will process the
     * command 'HOME', which places the player at home, updates the image, and
     * sets the hitboxes for the room. This also counts down on the players days
     * left to play the game. Feedback to the player is returned.<p>
     *
     *
     * @param command, a simple type, given by which room the player is in, and
     * which field the player clicked on.
     * @return String as feedback to the player, of what happened when the
     * command was processed.
     */
    public String processCommands(String command) {
        String val = "";
        if (gui.getGameWon()) {
            showGameWon(1, false);
            setRoomImage();

        }
        if (gui.getHunger() <= 0 || gui.getDaysLeft() <= 0 || gui.getMoney() < 0) {
            if (gui.getGameWon() != true) {
                showGameLost(1, false);
                setRoomImage();
            }
        }

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

    /**
     * <p>
     * prints in the console, the player location, finds the 'path' to the
     * background image. Done by fetching the currentRoom String from business.
     * <p>
     * <p>
     * the image is then set with the found image path, and displayed.<p>
     */
    public void setRoomImage() {
        System.out.println("you are at: " + gui.getCurrentRoom());
        String path = "FXML/Visuals/Highres/800x400/" + gui.getCurrentRoom() + ".jpg";
        Image room = new Image(path, true);
        RoomIMGContainer.setImage(room);
    }

    /**
     * This method sets the textoutput text field, to a specific String value.
     *
     * @param s a specified string, can be set when calling processcommand(),
     * this also returns a string, which is the feedback to the player.
     */
    public void setTextOutput(String s) {
        textOutput.setText(s);
    }

    /**
     * This method is important for better player interaction with the game, by
     * providing the player with useful information about the given room, what
     * the player can do in the given room, and maybe how to get out of it. This
     * information is stored in a textField called HelpText, which is accessed
     * by hovering the questionmark in the upper right corner.
     *
     * <p>
     * setText is called on the textfield, and a call to fetch a String from the
     * business layer is made, the String is set in the Room class's constructor
     * as it takes a room name, description, and help text. The String is set in
     * the TextField, and its opacity set to 1.
     */
    public void setHelpText() {
        HelpText.setText(gui.getRoomHelpText());
        HelpText.setOpacity(1);
    }

    /**
     * When the background image is clicked, and event is parsed through this
     * method, the event contains amoung others, the x and y-axis coordinates.
     * this is used to check wether a specific clickable field is clicked, if
     * the event coordinates was withing the clickablefields hitbox.
     *
     * <p>
     * At first, if a player has a pending invitation, this will be displayed
     * for every click the player makes, until the player accepts or rejects the
     * invitation. When displayed to buttons can be pressed, accept, and reject.
     * These will call process command, for the given action to be taken.
     *
     * <p>
     * After this, the hitboxes are set (refreshed), by calling setHitBoxes(),
     * and the currentroom is checked to make sure that only the current room's
     * clickable fields are checked if clicked. This is also being done, when
     * setting the hitboxes as that method, destroys prior rooms hitboxes. It
     * then checks if each hitbox in the room is hit, by calling the hitbox's
     * .hit(event). If true, the methid calls the processcommand with the
     * clickable fields purpose as a parameter (String type). These
     * processcommand calls all return a String value, whitch is to be dusplayed
     * in the textOutput textField.
     *
     * @param event, the point where the player clicked, x-and-y-coordinates can
     * be derived from this event.
     */
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
            if (office.hit(event)) {
                val += processCommands("OFFICE");
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

    /**
     * This method was used for testing the clickable fields, and to find their
     * pixel values for the offset, height, and width. Now this is no longer in
     * use, but can be activated to display the pixel possition of the mouse
     * cursor.
     *
     * @param event
     */
    @FXML
    private void MouseMoved(MouseEvent event) {
        //coordinates.setText("(" + event.getX() + "," + event.getY() + ")");
        coordinates.setOpacity(0);
    }

    /**
     * This method is to be called on button click, to show the player inventory
     * as a listview. This method, along with, showMap and showStats, also
     * refreshes the listview.
     *
     * <p>
     * when the InvGrid is disabled the method will call for it to be enabled
     * and visible, and when it is enabled the method will call for the grid to
     * be disabled and invisible. This creates the illusion of opening and
     * closing the menu tab.
     */
    @FXML
    private void ShowInventory() {
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

    /**
     * This method is used in initialize to set the default opacity and to
     * disable the grid from use. This method can also be called, when needed to
     * display the grid.
     *
     * @param i and Integer representing the opacity from 0 - 1.
     * @param bool a boolean dictating wether or not the grid is disabled.
     */
    public void ChangeInventoryState(int i, boolean bool) {
        InvGrid.setOpacity(i);
        InvGrid.setDisable(bool);
    }

    /**
     * This method is used in initialize to set the default opacity and to
     * disable the grid from use. This method can also be called, when needed to
     * display the grid.
     *
     * @param i and Integer representing the opacity from 0 - 1.
     * @param bool a boolean dictating wether or not the grid is disabled.
     */
    public void ChangeMapState(int i, boolean bool) {
        MapIMG.setOpacity(i);
        MapIMG.setDisable(bool);
    }

    /**
     * This method is used in initialize to set the default opacity and to
     * disable the grid from use. This method can also be called, when needed to
     * display the grid.
     *
     * @param i and Integer representing the opacity from 0 - 1.
     * @param bool a boolean dictating wether or not the grid is disabled.
     */
    public void ChangeStatusState(int i, boolean bool) {
        StatusGrid.setOpacity(i);
        StatusGrid.setDisable(bool);
    }

    /**
     * This method will 'close' all other tabs (Inventory, stats) and display
     * the map, if the mapIMG isn't already enabled. If it already is enabled,
     * this method will disable it and set the opacity to 0, otherwise it will
     * display the mapIMG. This method is called when the map tab is clicked.
     */
    @FXML
    private void ShowMap() {
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

    /**
     * his method is called when the settings icon is clicked, it will disable
     * everygrid behind it, so that settings will be on top, and nothing else
     * can be clicked. This is done by calling ChangeGameState and parsing
     * false. also this method will also call the ChangeSaveMenu, parsing 1 and
     * false.
     */
    @FXML
    private void ShowSettings() {
        MenuGrid.setDisable(false);
        SettingsGrid.setDisable(false);
        ChangeSaveMenu(1, false);
        ChangeGameState(true);
    }

    /**
     * This method will disable and make invisible, the invGrid, the StatusGrid,
     * and the Map image.
     *
     * @param bool to disable the clickerpane and textContainer. This will
     * disable the main game.
     */
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

    /**
     * This method will enable or disable the HelpGrid, and make it visible or
     * invisible.
     *
     * @param value corresponding to the wished opacity from 0 - 1.0.
     * @param bool to disable the grid.
     */
    private void ChangeHelpState(int value, boolean bool) {
        HelpGrid.setOpacity(value);
        HelpGrid.setDisable(bool);
    }

    /**
     * This method will show or hide the save / load menu.
     *
     * @param value opacity value
     * @param bool disable value
     */
    private void ChangeSaveMenu(int value, boolean bool) {
        SettingsBackdrop.setOpacity(value);
        SettingsGrid.setDisable(bool);
        SettingsGrid.setOpacity(value);

    }

    /**
     * This method will disable the SettingsGrid, and re-enable the MenuGrid.
     * Also this method will hide and disable the savemenu, and enable the main
     * game.
     */
    @FXML
    private void CloseSettings() {
        SettingsGrid.setDisable(true);
        MenuGrid.setDisable(false);
        ChangeSaveMenu(0, true);
        ChangeGameState(false);
    }

    /**
     * calls for the platform to quit.
     */
    @FXML
    private void QuitGame() {
        Platform.exit();
    }

    /**
     * calls the load method on the presentation facade. Also closes the
     * save/load menu, and enables the main game, clears and updates the
     * inventory listview
     */
    @FXML
    private void LoadGame() {
        gui.load();

        SettingsGrid.setDisable(true);
        MenuGrid.setDisable(false);
        ChangeSaveMenu(0, true);
        ChangeGameState(false);
        InventoryListView.getItems().clear();
        InventoryListView.setItems(gui.getInventory());

        InventoryListView.refresh();

    }

    /**
     * calls the save method on the presentation facade, disables the save/load
     * menu, and enables the main game.
     */
    @FXML
    private void SaveGame() {
        gui.save();
        SettingsGrid.setDisable(true);
        MenuGrid.setDisable(false);
        ChangeSaveMenu(0, true);
        ChangeGameState(false);
    }

    /**
     * This method is used to display the current hunger of the players daughter
     * in real time. for each move the player makes, the daughter will grow more
     * hungry by 3/100 hunger each move.
     *
     * <p>
     * it is known that the hunger bar is 320 pixels wide, and so the current
     * hunger is divided by 100.0, to return the percentage of fullness this is
     * timed with the 360 pixels to find how wide the bar has to be, to
     * represent the current hunger.
     *
     * <p>
     * this is then returned to be set, and to set the width of the actual bar.
     *
     * @return
     */
    private double calcHunger() {
        return 320.0 * (gui.getHunger() / 100.0);
    }

    /**
     * This method will hide and disable the map and inventory, then see if the
     * status grid already is enabled, if it is, it will hide the grid,
     * otherwise the grid will be shown on click.
     */
    @FXML
    private void ShowStats() {
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

    /**
     * This method will fetch all the player's stats from the logicfacade which
     * holds it.
     *
     * <p>
     * the values fetched are, money,exp,enhancements, moves, days left,
     * capacity, hunger /100, and then it calls the calcHunger method, to find
     * the hungetmeters width.
     * <p>
     * these values are fetched and then displayed in the status grid.
     */
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

    //This method is not really used..
    @FXML
    private void HelpClicked() {
        System.out.println("Help clicked");
    }

    /**
     * When this method is called, the player no longer hovers the mouse cursor over the help icon.
     * This means that the help grid has to be hidden and disabled.
     * 
     * <p>this is done by calling the ChangeHelpState parsing 0, and true.
     * @param event 
     */
    @FXML
    private void HelpExited(MouseEvent event) {
        ChangeHelpState(0, true);
    }

    /**
     * When the help icon is hovered, this method is called.
     * <p>it will call the ChangeHelpState to make the help grid visible, and
     * enabled.
     * 
     * <p>this method also calls the setHelpText method to fetch the rooms help text, and set it in the helptext textfield.
     *
     * @param event
     */
    @FXML
    private void HelpHover(MouseEvent event) {
        ChangeHelpState(1, true);
        setHelpText();
    }

    /**
     * This method is called when the game is won, and when the message that the player was successful is to be shown.
     * 
     * <p>This method will enable and make visible, the grid containing the message. While disabling the main game, and the menu options.
     * @param i
     * @param bool 
     */
    private void showGameWon(int i, boolean bool) {
        GameWonGrid.setOpacity(i);
        GameWonGrid.setDisable(bool);

        StatusGrid.setOpacity(0);
        StatusGrid.setDisable(true);

        SettingsGrid.setDisable(true);
        MenuGrid.setDisable(false);
        ChangeSaveMenu(0, true);
        ChangeGameState(false);
    }

    /**
     * Same as showGameWon, but this method will show the game lost message.
     * @param i opacity 0 - 1.0
     * @param bool disabled true / false
     */
    private void showGameLost(int i, boolean bool) {
        GameLostGrid.setOpacity(i);
        GameLostGrid.setDisable(bool);

        StatusGrid.setOpacity(0);
        StatusGrid.setDisable(true);

        SettingsGrid.setDisable(true);
        MenuGrid.setDisable(false);
        ChangeSaveMenu(0, true);
        ChangeGameState(false);
    }

    /**
     * This method is called to display the listview of the highscores.
     * <p> to show that, the method will have to disable and make the save menu invisible, so that the highscore menu can be visible and enabled
     * This method also replaces the close icon with a back icon, to go back to the save menu, from the highscore menu. The listview is the updated 
     * with a new fetch call for the highscores to be read and returned.
     */
    @FXML
    private void ShowScore() {
        SaveGrid.setDisable(true);
        SaveGrid.setOpacity(0);

        ScoreGrid.setDisable(false);
        ScoreGrid.setOpacity(1);
        BackIcon.setDisable(false);
        BackIcon.setOpacity(1);
        SettingsQuit.setOpacity(0);
        SettingsQuit.setDisable(true);

        ScoresListView.setOpacity(1);
        ScoresListView.setDisable(false);
        
        ScoresListView.setItems(gui.loadHighScores());

    }

    /**
     * This method will disable and hide the highscore grid. and enable and make visible the save / load menu, and also replace the back icon with a 
     * clos icon.
     */
    @FXML
    private void CloseScore() {
        ScoreGrid.setDisable(true);
        ScoreGrid.setOpacity(0);

        SaveGrid.setDisable(false);
        SaveGrid.setOpacity(1);
        BackIcon.setDisable(true);
        BackIcon.setOpacity(0);
        ScoresListView.setOpacity(0);
        ScoresListView.setDisable(true);

        SettingsQuit.setOpacity(1);
        SettingsQuit.setDisable(false);

    }

    /**
     * This method will call the buyEnh method on the logic facade, to pay for enhancements.
     * 
     * <p> that call returns a string telling the player, how much the purchase cost, or that they did not have enough money to buy more enhancements.
     * this is then set as the text in the textoutput textfield. Finally the method calls the getStatusInfo method to update the player stats, after each
     * purchase.
     */
    @FXML
    private void BuyEnhancements() {
        setTextOutput(gui.buyEnh());
        getStatusInfo();
    }

    /**
     * This method calls the buyFood method on the logicFacade, this method will return a String value representing what happened when the method was 
     * called.
     * <p> this return value is set as the textoutput textfield's text, finally the player stats are updated
     */
    @FXML
    private void BuyFood() {
        setTextOutput(gui.buyFood());
        getStatusInfo();
    }

    /**
     * This method is called when the player has the inventory tab open, and click the drop option.
     * 
     * <p> an item is gotten from that call, by finding which item on the listView was selected. If an item was selected, the method calls item to be 
     * removed from the inventory through the LogicFacade, then a message is printed in the console saying which item was dropped. The inventory ListView
     * items are the reset and refreshed.
     */
    @FXML
    private void DropItem() {
        item = InventoryListView.getSelectionModel().getSelectedItem();

        if (item != null) {
            gui.removeItem(item);
            System.out.println("Dropped: " + item.getName());
        } else {
        }
        InventoryListView.setItems(gui.getInventory());
        InventoryListView.refresh();
    }

    /**
     * This method is called when the player presses the inspect button in the inventory tab.
     * 
     * <p>An item is gotten by finding which item in the listview is selected.
     * If no item is selected, the method will not call for the item to be dropped. If an item is selected, a string value is found, which is the .toString
     * of the item. The textOutput is then sat to the toString value of the item.
     * The listView is then refreshed.
     */
    @FXML
    private void InspectItem() {
        item = InventoryListView.getSelectionModel().getSelectedItem();
        if (item != null) {
            String values = "A(n) " + item.getCat() + " item." + "\n" + item.getName() + " - " + item.getDesc();
            textOutput.setText(values);
            InventoryListView.refresh();
        }
    }

    /**
     * This method is called when the accept button is pressed, and can only be pressed when an invitation is pending. 
     * <p> when an invitation is pending the methods purpose is available. The method will clear the textOutput, and set the Privat room Command to 
     * 'ACCEPT' and process the command 'PRIVATEROOM', then hide and disable the invitationgrid.
     * <p>the room image will then be updated, and lastly reset the privateroom command as being null.
     */
    @FXML
    private void AcceptInvitation() {
        if (gui.getPRoomInvite() == true) {

            textOutput.clear();
            gui.setPrivateRoomCommand("ACCEPT");
            setTextOutput(gui.processCommand("PRIVATEROOM"));
            changeInvitationState(0, true);
            setRoomImage();
            gui.setPrivateRoomCommand(null);
        }
    }

    /**
     * if an invitation is pending, this method will call to set the privateroom command to REJECT, and call to have the command PRIVATEROOM processed
     * also this method will close the invitation grid. Finally it will reset the privateroom command so it is ready for the next use case.
     */
    @FXML
    private void DeclineInvitation() {
        if (gui.getPRoomInvite() == true) {
            textOutput.clear();
            gui.setPrivateRoomCommand("REJECT");
            setTextOutput(gui.processCommand("PRIVATEROOM"));
            changeInvitationState(0, true);
            gui.setPrivateRoomCommand(null);
        }
    }

    /**
     * This method when called will fetch the toString on the regular in the room, if an invitation is pending.
     * <p> this is done by setting the textOutput to the return value of the toString on the regular.
     */
    @FXML
    private void InfoOnRegular() {
        if (gui.getPRoomInvite()) {
            textOutput.setText(gui.getRegularInRoomInfo());
        }
    }

    /**
     * this method calls the newGame method on the presentationFacade, which will replace the current FXML document with the same document, and calls the
     * resetGame method.
     * @param event this method is called on mouse click, and so, parses an event
     */
    @FXML
    private void ReplayGame(MouseEvent event) {
        gui.newGame(event);
    }
    /**
     * calls the mainMenu method og the presentationFacade
     * <p> this loads another FXML document which shows the main menu, and replaces the old document.
     * @param event this method is called on mouse click, and so parses event.
     */
    @FXML
    private void QuitToMainMenu(MouseEvent event) {
        gui.mainMenu(event);
    }

    /**
     * This method disables and makes the WelcomeGrid invisible
     */
    @FXML
    private void CloseWelcome() {
        WelcomeGrid.setOpacity(0);
        WelcomeGrid.setDisable(true);
    }

}
