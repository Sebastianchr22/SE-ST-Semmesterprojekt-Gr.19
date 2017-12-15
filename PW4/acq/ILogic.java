package acq;

import logic.Player;
import java.util.ArrayList;
import java.util.Collection;
import javafx.collections.ObservableList;
import logic.Inventory;
import logic.Item;
import logic.ItemList;
import logic.Regular;
import logic.Room;

public interface ILogic {

    /**
     * Sets a IData object to the specified object.
     *
     * @param data
     */
    public void injectData(IData data);

    /**
     * To call the save method on the data layer.
     */
    public void save();

    /**
     * Called to save a specific highscore through the data layer.
     *
     * @param score : int
     */
    public void saveHighScore(int score);

    /**
     * Called to load the latest save from the data layer.
     */
    public void load();

    /**
     * Called to read the highscore file
     *
     * @return ObservableList : int
     */
    public ObservableList loadHighScore();

    /**
     * gets if the player is in the privateroom
     *
     * @return boolean
     */
    public boolean inPRoom();

    /**
     * Set wether the player is in hotel or motel.
     *
     * @param s : String
     */
    public void setHotelMotel(String s);

    /**
     * sets if the player is in the private room.
     *
     * @param bool : Boolean
     */
    public void setInPRoom(boolean bool);

    /**
     * Sets if the game is won or not yet won.
     *
     * @param bool : Boolean
     */
    public void setWon(boolean bool);

    /**
     * Sets the new inventory to a specific inventory.
     *
     * @param inventory
     */
    public void setInventory(Inventory inventory);

    /**
     * Sets the itemlist to a specific itemlist.
     *
     * @param list : ItemList
     */
    public void setItemList(ItemList list);

    /**
     * Sets a new player to a specifc player object.
     *
     * @param player
     */
    public void setPlayer(Player player);

    /**
     * Adds a specific item to the inventory
     *
     * @param item
     */
    public void addToInventory(Item item);

    /**
     * Adds a specific item to the itemlist
     *
     * @param item
     */
    public void addToItemList(Item item);

    /**
     * Removes a specific item from the inventory
     *
     * @param item
     */
    public void removeFromInventory(Item item);

    /**
     * removes a specific item from the itemlist
     *
     * @param item
     */
    public void removeFromItemList(Item item);

    /**
     * gets the info on a specific regular.
     *
     * @param regular : IRegular
     * @return info : String
     */
    public String info(IRegular regular);

    /**
     * Turns the inventory into a collection of strings. This is for storing in
     * the savefile, so the this is only the names of the items in the inventory
     *
     * @return Collection of strings
     */
    public Collection<String> getDataInv();

    /**
     * @return the current player object
     */
    public Player getPlayer();

    /**
     * Gets the name of the specified regular.
     *
     * @param regular : IRegular
     * @return name : String
     */
    public String getName(IRegular regular);

    /**
     * Gets the amount of items specified in the specific preference.
     *
     * @param preference : IPreference
     * @return amount : int
     */
    public int getAmount(IPreference preference);

    /**
     * gets an amount of items of a specific category the player has in their
     * inventory
     *
     * @param specific : String category
     * @return amount : int
     */
    public int getSpecific(String specific);

    /**
     * get the first preference specified by the given regular.
     *
     * @param regular : IRegular
     * @return IPreference
     */
    public IPreference getPreference0(IRegular regular);

    /**
     * get the second preference specified by the given regular.
     *
     * @param regular : IRegular
     * @return IPreference
     */
    public IPreference getPreference1(IRegular regular);

    /**
     * Gets the players amount of experience
     *
     * @return exp : int
     */
    public int getExperience();

    /**
     * Gets the players amount of enhancements
     *
     * @return enh : int
     */
    public int getEnhencements();

    /**
     * Gets the player moves left
     *
     * @return moves : int
     */
    public int getMoves();

    /**
     * Gets the players moneySaved
     *
     * @return money : double
     */
    public double getMoneySave();

    /**
     * Gets the players current hunger variable
     *
     * @return hunger : int
     */
    public int getCurrentHunger();

    /**
     * Gets the players daysLeft variable
     *
     * @return daysLeft : int
     */
    public int getDaysLeft();

    /**
     * Gets the listOfRegulars
     *
     * @return ArrayList of Regulars
     */
    public ArrayList<Regular> getRegularList();

    /**
     * Gets the itemlist, as a new ArrayList
     *
     * @return ArrayList of items
     */
    public ArrayList<Item> getItemList();

    /**
     * Gets the inventory, as a new ArrayList
     *
     * @return ArrayList of items
     */
    public ArrayList<Item> getInventory();

    /**
     * Gets wether the game is won, or yet to be won.
     *
     * @return gameWon : Boolean
     */
    public boolean getWon();

    /**
     * gets wether the player is in the privateroom
     *
     * @return inPRoom : Boolean
     */
    public boolean getInPRoom();

    /**
     * Gets the weddingring item from the inventory.
     *
     * @return weddingring : IItem
     */
    public IItem getWeddingRing();

    /**
     * Gets the specific highscore, in logicFacade
     *
     * @return score : int
     */
    public int getScore();

    /**
     * sets the winPercent in logicFacade
     *
     * @param d : double
     */
    public void setWinPercent(double d);

    /**
     * Gets the winPercent from logicFacade.
     *
     * @return winPercent : double
     */
    public double getWinPercent();

    /**
     * Gets the regular in the room, or else null.
     *
     * @return regularInRoom : IRegular
     */
    public IRegular getRegularInRoom();

    /**
     * Gets the name of the players currentRoom in all caps.
     *
     * @return currentRoom : String
     */
    public String getCurrentRoom();

    /**
     * Sets the players currentRoom to a specific room.
     *
     * @param room : Room
     */
    public void setCurrentRoom(Room room);

    /**
     * Gets the players capacity as a string
     *
     * @return capacity : x/1000g
     */
    public String getCapacity();

    /**
     * gets the players current hunger
     *
     * @return hunger / 100.
     */
    public String getShortHunger();

    /**
     * gets the inventory
     *
     * @return Inventory
     */
    public Inventory getInv();

    /**
     * Called to buy food for the player.
     *
     * @return feedback : String
     */
    public String buyFood();

    /**
     * Called to buy enhancements
     *
     * @return feedback : String
     */
    public String buyEnhancements();

    /**
     * Sets the players currentRoom to the room home.
     */
    public void setRoomHome();

    /**
     * Is to reset everything about the game, from player to the lists, and
     * more.
     */
    public void resetGame();

    /**
     * Gets the inventory as an observablelist for use in the gui.
     *
     * @return Inventory : ObservableList
     */
    public ObservableList<IItem> getInventoryList();

    /**
     * To remove an item from the inventory, and add it to the itemlist yet
     * again
     *
     * @param item
     */
    public void dropItem(IItem item);

    /**
     * Process a specific command given by a string, this method only takes very
     * specific keywords, and will process them.
     *
     * @param command : String
     * @return feedback : String
     */
    public String processCommand(String command);

    /**
     * Sets the players currentRoom to a specific room.
     *
     * @param room
     */
    public void goRoom(Room room);

    /**
     * Check if the player and manager are in the same room, and not in the
     * lockerroom, or on the dance floor.
     *
     * @return boolean
     */
    public boolean managerPlayerSameRoom();

    /**
     * Feedback on the fact that the manager takes a cut of the players money.
     * The money will be taken, and a check to make sure that the player and
     * manager are in the same room, is executed.
     *
     * @return feedback : string
     */
    public String managerTakesCut();

    /**
     * Gets the player's currentRoom's helptext.
     *
     * @return helpText : String
     */
    public String getRoomHelpText();

    /**
     * Gets the description of the player's currentRoom.
     *
     * @return description : String
     */
    public String getRoomDescription();

    /**
     * Adds a specific amount of experience to the players exp variable
     *
     * @param i : int
     */
    public void addExperience(int i);

    /**
     * Removes a specific amount of money from the players bank
     *
     * @param d : double
     */
    public void removeMoney(double d);

    /**
     * Gets a random regular from the list of regulars.
     *
     * @return random regular : IRegular
     */
    public IRegular getRandomRegular();

    /**
     * Removes a specified amount of moves from the players moveLeft variable.
     *
     * @param i : int
     */
    public void removeMoves(int i);

    /**
     * Adds a specific amount of money to the player's bank
     *
     * @param d : double
     */
    public void addMoney(double d);

    /**
     * Returns true if an invite is pending.
     *
     * @return boolean
     */
    public boolean getPRoomInvite();

    /**
     * Sets a pending invite to the privateroom
     *
     * @param bool
     */
    public void setPRoomInvite(boolean bool);

    /**
     * Sets a specific regular in the room.
     *
     * @param regular : IRegular
     */
    public void setRegularInRoom(IRegular regular);

    /**
     * Sets a specific coomand to be executed
     *
     * @param s : string command
     */
    public void setPrivateRoomCommand(String s);

    /**
     * Gets the command to be executed.
     *
     * @return feedback : String
     */
    public String getPrivateRoomCommand();

    /**
     * Gets the percentage with which the player won the game calculated on how
     * rich the regular was compared to all possible regulars
     *
     * @param regular : IRegular
     * @return percent : double
     */
    public double getWinPercent(IRegular regular);

    /**
     * Removes one day left from the players daysLeft variable.
     */
    public void removeDaysLeft();

}
