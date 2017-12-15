package acq;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public interface IGUI {

    /**
     * Injects a reference to the ILogic Logicfacade object from the strater
     * class. This is used so that, all layers are working with the same version
     * of the references to eachother.
     *
     * @param logic : ILogic
     */
    void injectLogic(ILogic logic);

    /**
     * Starts the JavaFX Application
     *
     * @param mainStage : Stage
     * @throws Exception
     */
    void start(Stage mainStage) throws Exception;

    /**
     * Starts the application
     */
    public void start();

    /**
     * Calls the newGame method on the PresentationFacade, to create a new
     * player, and to restart the game.
     *
     * @param event : Mouse click on button.
     */
    public void newGame(MouseEvent event);

    /**
     * This is used to initialize the application with the mainMenu fxml and
     * controller.
     *
     * @param event : Mouse click on button.
     */
    public void mainMenu(MouseEvent event);

    /**
     * Will start a new game, but set the player as the return value of the load
     * method on the data layer. This means that all itemlists, and invetory,
     * and player are all set to the data found.
     *
     * @param event : Mouse click on button.
     */
    public void loadGame(MouseEvent event);

    /**
     * Calls the save method on the data layer, through the logic layer
     */
    void save();

    /**
     * Calls the load method on the data layer, through the logic layer
     */
    void load();

    /**
     * Calls the loadHighScore method on the data layer, through the logic
     * layer. This returns an ObservableList to be displayed in the gui.
     */
    public ObservableList loadHighScores();

    /**
     * Returns the players money, from the logic layer
     *
     * @return moneySaved : Double
     */
    double getMoney();

    boolean getGameWon();

    /**
     * Returns the players experience, from the logic layer
     *
     * @return experience : int
     */
    int getExp();

    /**
     * Returns the players enhancements, from the logic layer
     *
     * @return enhancements : int
     */
    int getEnh();

    /**
     * Returns the players Moves, from the logic layer
     *
     * @return moves : int
     */
    int getMoves();

    /**
     * Returns the players DaysLeft, from the logic layer
     *
     * @return daysLeft : int
     */
    int getDaysLeft();

    /**
     * Returns the currentRoom of the player, as a string. This is given by the
     * logic layer.
     *
     * @return currentRoom : Room.getName
     */
    public String getCurrentRoom();

    /**
     * Returns the players overall capacity, as a string: x / 1000g.
     *
     * @return capacity : String
     */
    public String getCapacity();

    /**
     * Returns the players current hunger, to display in the gui.
     *
     * @return hunger : int.
     */
    public int getHunger();

    /**
     * Returns the players current hunger, as a string: x / 100.
     *
     * @return hunger : String
     */
    public String getShortHunger();

    /**
     * This method calls the BuyFood method on the logic layer, and returns a
     * string feedback
     *
     * @return feedback : String
     */
    public String buyFood();

    /**
     * This method calls the buyEnhancements method on the logic layer, and
     * returns a string feedback
     *
     * @return feedback : String
     */
    public String buyEnh();

    /**
     * Returns an ObservableList of all IItems in the players inventory, to be
     * displayed in the gui.
     *
     * @return ObservableList of IItems.
     */
    public ObservableList<IItem> getInventory();

    /**
     * Will call the removeFromList on the inventory on the logic layer, to have
     * a specific item removed. This is done by first parsing an IItem, then
     * finding out whitch item the equals in the inventory of just Items. This
     * is done by calling getItem, which finds a specific item, from just the
     * name. Then the item is removed from the inventory.
     *
     * @param item : IItem
     */
    public void removeItem(IItem item);

    /**
     * Calls for a specific command to be processed, this is done of the logic
     * layer, and so a string is parsed.
     *
     * @param command : Command string to be processed
     * @return feedback : String
     */
    public String processCommand(String command);

    /**
     * Gets info on the specific regular on the club. Only one is in there at a
     * time, this is avalible when a regular invites a player to the
     * privateroom. Giving the player the info option to call on the regular.
     *
     * @return feedback : String
     */
    public String getRegularInRoomInfo();

    /**
     * Will call the same method on the logicFacade, to check if the player and
     * manager are in the same room. This is used to tax the player.
     *
     * @return boolean
     */
    public boolean managerPlayerSameRoom();

    /**
     * When the player and manager are in the same room, some feedback is given,
     * to let the player know, that the manager has taken money.
     *
     * @return feedback : String
     */
    public String managerTakesCut();

    /**
     * Calls the same method on the logic layer, to return the helpText on the
     * currentRoom.
     *
     * @return feedback : String
     */
    public String getRoomHelpText();

    /**
     * Returns the string value of the description of the current room.
     *
     * @return description : String
     */
    public String getRoomDescription();

    /**
     * Set or resets the private room command. This is a command to specify wether the player accepts, declines, calls for info, or dances.
     * @param s : String
     */
    public void setPrivateRoomCommand(String s);

    /**
     * Returns if the player is invited to privateroom by a Regular. This invitation comes from danceMech, which will invite the player on chance.
     * @return 
     */
    public boolean getPRoomInvite();

    /**
     * This is done to count down the players moves. This is called whenever the player moves.
     */
    public void removeDaysLeft();

}
