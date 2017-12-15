package logic;

import acq.IData;
import acq.IItem;
import acq.ILogic;
import acq.IPlayer;
import acq.IPreference;
import acq.IRegular;
import java.util.ArrayList;
import java.util.Collection;
import javafx.collections.FXCollections;
import javafx.collections.*;

public class LogicFacade implements acq.ILogic {

    private IData data;
    private static ILogic logic;
    Room privateRoom = new Room("Private room", "in the private room, where everything can happen", "Click anywhere to perform a dance.");
    Room office = new Room("Office", "in the managers office", "");
    Room outside = new Room("Outside", "outside of the club", "Click the door to go back, or hang out with the bouncer some more.");
    Room motel = new Room("Motel", "in a grimm looking motel", "Click anywhere to go back home.");
    Room hotel = new Room("Hotel", "in the home of your new lover", "");
    Room home = new Room("Home", "home sweet home..", "You will need your car keys to exit, and go to work");
    Room drive = new Room("Drive", "The old parkinglot, where your car is, the old tin can..", "You should take your car to work, but where did you park it?");
    Room back = new Room("Backroom", "in the backroom.", "You can go to the locker room, and to the main dancefloor from here.");
    Room locker = new Room("Locker room", "in the locker room. Here you can find all sorts of nice things.", "You can always steal from the other strippers. Click on the lockers to attempt to steal. \n Click the bottom of the screen to go back.");
    Room floor = new Room("Dance floor", "on the floor. Here you can really perform, a good show brings good money, and a regular, can bring you even more..", "Click the pole to dance, maybe you will be invitet to the private room by a regular. \n you can also go outside. \n Click the bottom of the screen to go back.");

    private Regulars reg = new Regulars();
    private ArrayList<Regular> regularList = new ArrayList<>();
    private ListOfRegulars reglist = new ListOfRegulars(regularList);
    private Player player;
    private Inventory inv;
    private ItemList itemlist;
    private IRegular regularInRoom;
    private Room currentRoom = home;
    private double winPercent;
    private boolean gameWon;
    private boolean inPRoom;
    private int highscore;
    private boolean pRoomInvite;
    private String privateRoomCommand;
    private String hotelMotel = "";

    Manager manager = new Manager("Manager", office);

    /**
     * Constructor for the logicFacade, to create rooms, player, inventory,
     * itemlist, regulars, and listofRgulars. Also game important variables are
     * initialized.
     */
    public LogicFacade() {
        logic = this;
        reg.createReglist(reglist);
        Regulars reg = new Regulars();
        reg.createReglist(reglist);

        player = new Player();
        inv = new Inventory();
        itemlist = new ItemList();
        winPercent = 0;
        highscore = 0;

        home.setExit("work", back);

        back.setExit("floor", floor);
        back.setExit("locker", locker);

        back.setExit("home", home);

        locker.setExit("back", back);

        floor.setExit("back", back);

        floor.setExit("outside", outside);

        floor.setExit("private", privateRoom);

        privateRoom.setExit("floor", floor);

        office.setExit("back", back);

        outside.setExit("floor", floor);

        motel.setExit("home", home);

        hotel.setExit("home", home);

    }

    /**
     * A mutator for the IData data variable.
     *
     * @param data : IData
     */
    @Override
    public void injectData(IData data) {
        this.data = data;
    }

    /**
     * Sets the currentRoom of the player, to the room, home.
     */
    @Override
    public void setRoomHome() {
        this.currentRoom = home;
    }

    /**
     * Will return a reference to this ILogic reference within.
     *
     * @return ILogic Logic.
     */
    public static ILogic getInstance() {
        return logic;
    }

    /**
     * This method is called to save the current game.
     *
     * <p>
     * This is done by creating two collections, one for the stats, and one for
     * the inventory. To the stats, this method will add all the relevant
     * playerStats one by one. Finally a for each loop is used, to add all item
     * names in the players inventory, to the inventory collection.
     *
     * <p>
     * Finally the save() method is called on the dataFacade, with the two
     * collections as parameter.
     */
    @Override
    public void save() {
        Collection<Integer> stats = new ArrayList();
        Collection<String> inventory = new ArrayList();

        stats.add(player.getDaysLeft());
        stats.add(player.getEnhancements());
        stats.add(player.getExperience());
        stats.add(player.getHunger());
        stats.add(player.getMoves());
        stats.add((int) player.getMoneySaved());

        for (IItem item : inv.Inventory) {
            inventory.add(item.getName());
        }

        data.save(stats, inventory);
    }

    /**
     * This method takes a given score, this is parser with the saveHighsScore()
     * method call on the dataFacade, this method also takes a score and saves
     * it.
     *
     * @param score : int
     */
    @Override
    public void saveHighScore(int score) {
        data.saveHighScore(score);
    }

    /**
     * This method calls the load() method on the dataFacade which returns an
     * IPlayer object. Which is then used to set a new player on the logic
     * facade to have the found variables.
     *
     * <p>
     * The inventory colelction is found on the newPlayer object, and the
     * containsItem() method is called on the itemlist. This returns the
     * specific item object, from just the name as a string.
     *
     * <p>
     * The current Inventory and itemlist are then set, as soon as the found
     * items are removed from the itemlist, and added to the inventory.
     */
    @Override
    public void load() {
        IPlayer newplayer = data.load();
        this.player.setCurrentHunger(newplayer.getHunger());
        this.player.setDaysLeft(newplayer.getDaysLeft());
        this.player.setEnhancements(newplayer.getEnhancements());
        this.player.setExperience(newplayer.getExperience());
        this.player.setMoneySaved(newplayer.getMoneySaved());
        this.player.setMoves(newplayer.getMoves());
        ArrayList<Item> newInv = new ArrayList();
        ArrayList<Item> newItemList = new ArrayList();
        newItemList = itemlist.itemList;

        for (String item : newplayer.getInv()) {
            if (!item.equals("Wedding Ring") && !item.equals("Car keys")) {
                Item found = itemlist.containsItem(item);
                newInv.add(found);
                newItemList.remove(found);
            } else if (item.equals("Wedding Ring")) {
                newInv.add(inv.getWeddingRing());
            }
            if (item.equals("Car keys")) {
            }
        }

        inv.Inventory = newInv;
        itemlist.itemList = newItemList;
    }

    /**
     * This method is called, to return an ObservableList of all the found
     * highscores, sorted.
     *
     * @return ObervableList of highscores : int
     */
    public ObservableList loadHighScore() {
        return data.loadHighScore();
    }

    /**
     * This method is called to see if the player is in the privateroom, as a
     * booelean.
     *
     * @return getInPRoom() : Boolean
     */
    @Override
    public boolean inPRoom() {
        return this.getInPRoom();
    }

    /**
     * This method is called to completely reset the game. New player, itemlist,
     * inventory, pRoomInvite, winPercent, privateRoomCommand and more.
     *
     * This will be called to reset the game, when a retry is choosen.
     */
    @Override
    public void resetGame() {
        this.player = new Player();
        this.currentRoom = home;
        goRoom(home);
        processCommand("HOME");
        this.itemlist = new ItemList();
        this.inv = new Inventory();
        this.pRoomInvite = false;
        this.privateRoomCommand = null;
        this.winPercent = 0;
        this.hotelMotel = "";
    }

    /**
     * Fetches a specific regulars info(). This describes the regular, and
     * returns that as a string.
     *
     * @param regular : IRegular.
     * @return info() : String
     */
    @Override
    public String info(IRegular regular) {
        return regular.info();
    }

    /**
     * This is a mutator for the privateRoomCommand variable. This takes a
     * String of specific keyword, such as room names, or specific command
     * names. See processCommand() for further reference.
     *
     * @param s : String
     */
    @Override
    public void setPrivateRoomCommand(String s) {
        this.privateRoomCommand = s;
    }

    /**
     * This method is used to access the privateRoomCommand variable.
     *
     * @return privateRoomCommand : String
     */
    @Override
    public String getPrivateRoomCommand() {
        return this.privateRoomCommand;
    }

    /**
     * This method will add a specific item to the players inventory
     *
     * @param item : Item
     */
    @Override
    public void addToInventory(Item item) {
        inv.addToList(item);
    }

    /**
     * This method will add a specific item to the itemlist.
     *
     * @param item : Item
     */
    @Override
    public void addToItemList(Item item) {
        itemlist.addToList(item);
    }

    /**
     * This method will remove a specific item from the inventory.
     *
     * @param item : Item
     */
    @Override
    public void removeFromInventory(Item item) {
        inv.removeFromList(item);
    }

    /**
     * This method will remove a specific item from the itemlist
     *
     * @param item : Item
     */
    @Override
    public void removeFromItemList(Item item) {
        itemlist.removeFromList(item);
    }

    /**
     * This method will remove a specified amount of moves from the players
     * moves left.
     *
     * @param i : int of specified amount of moves to remove.
     */
    @Override
    public void removeMoves(int i) {
        this.player.removeMoves(i);
    }

    /**
     * This method returns the name of the players current room, in all caps.
     *
     * @return currentRoom name : String
     */
    @Override
    public String getCurrentRoom() {
        return this.currentRoom.getNameBackend();
    }

    /**
     * This method will return a boolean of wether the player is currently
     * invited to the privateroom.
     *
     * @return invite : boolean.
     */
    @Override
    public boolean getPRoomInvite() {
        return this.pRoomInvite;
    }

    /**
     * This will set a specific regular in the room
     *
     * @param regular : IRegular.
     */
    @Override
    public void setRegularInRoom(IRegular regular) {
        this.regularInRoom = regular;
    }

    /**
     * Sets the pRoomInvite variable to a specifed boolean.
     *
     * @param bool of invitation.
     */
    @Override
    public void setPRoomInvite(boolean bool) {
        this.pRoomInvite = bool;
    }

    /**
     * subtracts a specified amount of money from the players moneySaved.
     *
     * @param d : Double
     */
    @Override
    public void removeMoney(double d) {
        this.player.removeMoney(d);
    }

    /**
     * Adds a specified amount of experience to the players experience.
     *
     * @param i : int
     */
    @Override
    public void addExperience(int i) {
        this.player.addExperience(i);
    }

    /**
     * Sets the players currentRoom to a specific room.
     *
     * @param room : Room
     */
    @Override
    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    /**
     * Sets wether or not the player is in the privateRoom.
     *
     * @param bool : boolean
     */
    @Override
    public void setInPRoom(boolean bool) {
        this.inPRoom = bool;
    }

    /**
     * Sets the game to won, or not yet won.
     *
     * @param bool : Boolean
     */
    @Override
    public void setWon(boolean bool) {
        this.gameWon = bool;
    }

    /**
     * Adds a specified amount of money to the players moneySaved.
     *
     * @param d : Double
     */
    @Override
    public void addMoney(double d) {
        this.player.addMoney(d);
    }

    /**
     * This method will return a collection of string to be saved, as it
     * contains all names of items in the inventory.
     *
     * @return String collection of names.
     */
    public Collection<String> getDataInv() {
        ArrayList<String> list = new ArrayList();

        for (Item item : inv.Inventory) {
            list.add(item.getName());
        }

        return list;
    }

    /**
     * @return The players inventory
     */
    @Override
    public Inventory getInv() {
        return this.inv;
    }

    /**
     * this method will return the player object reference.
     *
     * @return player
     */
    @Override
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Will return a boolean of if the player is in the privateroom.
     *
     * @return inPRoom : Boolean
     */
    @Override
    public boolean getInPRoom() {
        return this.inPRoom;
    }

    /**
     * This method is called to return if the gameIsWon.
     *
     * @return gameWon : Boolean
     */
    @Override
    public boolean getWon() {
        return this.gameWon;
    }

    /**
     * Maps the players inventory, this is done by returning a new arraylist of
     * the inventory
     *
     * @return inventory : ArrayList
     */
    @Override
    public ArrayList<Item> getInventory() {
        return new ArrayList(inv.Inventory);
    }

    /**
     * This method maps the itemlist, to a new ArrayList, with the itemlist in
     * it.
     *
     * @return itemlist : ArrayList
     */
    @Override
    public ArrayList getItemList() {
        return new ArrayList(itemlist.itemList);
    }

    /**
     * Maps the reglist to a new ArrayList.
     *
     * @return reglist : ArrayList.
     */
    @Override
    public ArrayList getRegularList() {
        return new ArrayList(reglist.regularList);
    }

    /**
     * Calls getRandomRegular on the reglist, and returns an IRegular object.
     *
     * @return IRegular
     */
    @Override
    public IRegular getRandomRegular() {
        return this.reglist.getRandomRegular();
    }

    /**
     * calls getExperience on the player object.
     *
     * @return experience : int
     */
    @Override
    public int getExperience() {
        return player.getExperience();
    }

    /**
     * Calls getEnhancements on the player object.
     *
     * @return enhancements : int
     */
    @Override
    public int getEnhencements() {
        return player.getEnhancements();
    }

    /**
     * calls getMoves on the player object.
     *
     * @return moves : int
     */
    @Override
    public int getMoves() {
        return player.getMoves();
    }

    /**
     * calls getMoneySaved on the player object. Rounded to one decimal.
     *
     * @return money : double
     */
    @Override
    public double getMoneySave() {
        return (player.getMoneySaved() * 100.0) / 100.0;
    }

    /**
     * calls getHunger on the player object.
     *
     * @return hunger : int
     */
    @Override
    public int getCurrentHunger() {
        return player.getHunger();
    }

    /**
     * calls getDaysLeft on the player object.
     *
     * @return daysLeft : int
     */
    @Override
    public int getDaysLeft() {
        return player.getDaysLeft();
    }

    /**
     * This method returns a number of how many items of a specific category the
     * player carries in their inventory. This is done by calling the
     * getSpecific on the player object.
     *
     * @param specific : String
     * @return amount : int
     */
    @Override
    public int getSpecific(String specific) {
        return inv.getSpecific(specific);
    }

    /**
     * Gets a preference's amount, as in, how many of items of the specific
     * category are required.
     *
     * @param preference : IPreference
     * @return amount : int
     */
    @Override
    public int getAmount(IPreference preference) {
        return preference.getAmount();
    }

    /**
     * Gets the name of the specified regular of the IRegular type.
     *
     * @param regular : IRegular
     * @return name : String
     */
    @Override
    public String getName(IRegular regular) {
        return regular.getName();
    }

    /**
     * This method will return the first preference of a specified regular.
     *
     * @param regular : IRegular
     * @return IPreference0 : Preference
     */
    @Override
    public IPreference getPreference0(IRegular regular) {
        return regular.getPreference0();
    }

    /**
     * This method will return the second preference of a specified regular.
     *
     * @param regular : IRegular
     * @return IPreference1 : Preference
     */
    @Override
    public IPreference getPreference1(IRegular regular) {
        return regular.getPreference1();
    }

    /**
     * This method is used to get a reference to the weddingRing item in the
     * inventory.
     *
     * @return weddingring : Item.
     */
    @Override
    public Item getWeddingRing() {
        return this.inv.getWeddingRing();
    }

    /**
     * This method is used to access the highscore variable, and return it.
     *
     * @return highscore : int
     */
    @Override
    public int getScore() {
        return this.highscore;
    }

    /**
     * This is used as a mutator for the winPercent variable.
     *
     * @param d : Double
     */
    @Override
    public void setWinPercent(double d) {
        this.winPercent = d;
    }

    /**
     * this method will return the winPercent variable
     *
     * @return winPercent : Double
     */
    @Override
    public double getWinPercent() {
        return this.winPercent;
    }

    /**
     * This method will set the current inventory to a new list of items.
     *
     * @param inventory : inventory
     */
    @Override
    public void setInventory(Inventory inventory) {
        this.inv = inventory;
    }

    /**
     * This will set the itemlist to a new itemlist.
     *
     * @param list : ItemList.
     */
    @Override
    public void setItemList(ItemList list) {
        this.itemlist = list;
    }

    /**
     * This will set the player object to a new object.
     *
     * @param player : Player
     */
    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * This will return the regularInRoom
     *
     * @return regularInRoom : IRegular
     */
    @Override
    public IRegular getRegularInRoom() {
        return this.regularInRoom;
    }

    /**
     * This method is used to get a string description of the players inventory
     * weight.
     *
     * @return weightToString : String
     */
    @Override
    public String getCapacity() {
        return this.inv.weightToString();
    }

    /**
     * This will return a string value of the players hunger as x /100.
     *
     * @return huger : String
     */
    public String getShortHunger() {
        return this.player.getShortHunger();
    }

    /**
     * This method is called to buy food.
     *
     * <p>
     * First, it will be checked if the player has enough money to buy more
     * food, as food is calculated as the enhancements * 1.35 + 1 and /10. This
     * calculation is called i, and the base price for food is 100, so the price
     * is 100* i.
     *
     * <p>
     * This makes sure that food gets more expensive as the player makes more
     * money pr dance.
     *
     * <p>
     * 10 food is added pr purchase. and the money amount removed.
     *
     * @return Feedback is returned, with the price or info.
     */
    @Override
    public String buyFood() {
        double i = Math.round((this.getEnhencements() + 1 * 1.35) / 10 * 100.0) / 100.0;
        if (player.getMoneySaved() > 100 * (1.0 + i)) {
            if (player.getHunger() <= 90) {
                this.player.addHunger(10);
                this.player.removeMoney(100 * i);
                return "You bought some food, costing you $" + 100 * i;
            } else {
                return "You can't have more food.";
            }
        } else {
            return "You do not have enough money to buy food, costing $" + 100 * (1.0 + i);
        }
    }

    /**
     * The price of enhancements increse pr experience, as this calculated as
     * 150 * i.
     *
     * <p>
     * Where i = (experience + 1 * 1.35)/10 rounded to one digit. This makes it
     * slightly more expensive pr enhancement, according to exp.
     *
     * @return feedback of purchase.
     */
    @Override
    public String buyEnhancements() {
        double i = Math.round((this.getExperience() + 1 * 1.35) / 10 * 100.0) / 100.0;

        if (player.getMoneySaved() >= 150 * (1.0 + i)) {
            this.player.addEnhancements(1);
            this.player.addDaysLeft(highscore);
            this.player.removeMoney(150 * i);
            return "You bought an enhancement costing you $" + 150 * i;
        } else {
            return "You do not have enough money to buy enhancments, costing $" + 150 * (1.0 + i);
        }
    }

    /**
     * This method makes the inventory into an FXCollection ObservableList. This
     * makes it updateable and a live view of the inventory. All items in the
     * current inventory is added, and the list returned.
     *
     * @return list : ObservableList
     */
    @Override
    public ObservableList<IItem> getInventoryList() {
        ObservableList<IItem> list = FXCollections.observableArrayList();
        for (IItem item : inv.Inventory) {
            list.add(item);
        }
        return list;
    }

    /**
     * From just a string the whole inventory is searched for an item with the
     * given name. That name is then returned, if it is found.
     *
     * @param name : String
     * @return Item or null
     */
    public Item getItem(String name) {
        int count = 0;
        for (Item item : inv.Inventory) {
            if (item.getName().equals(name)) {
                System.out.println("Found " + item.getName() + " - " + item.getDesc());
                return inv.Inventory.get(count);
            } else {
                count++;
            }
        }
        return null;
    }

    /**
     * This method checks the name of the item dropped, and if it isn't the
     * wedding ring, it will both be removed from the inventory and added to the
     * itemlist. If the dropped item is the weddingring, then it will be removed
     * from inventory, and not added to the itemlist.
     *
     * @param item : IItem
     */
    @Override
    public void dropItem(IItem item) {
        String name = item.getName();
        inv.removeFromList(getItem(name));
        if (!name.equals("Wedding Ring")) {
            itemlist.addToList(getItem(name));
        }
    }

    /**
     * This method returns the name of the managers currentroom in all caps.
     *
     * @return currentRoom : String
     */
    public String getManagerRoom() {
        return this.manager.getRoom();
    }

    /**
     * This method checks if the manager and player are in the same room, and
     * not locker room, or dance floor. If they meet anywhere else, the manager
     * will take his cut. So if they meet anywhere but those rooms, this is
     * true, else false.
     *
     * @return boolean
     */
    @Override
    public boolean managerPlayerSameRoom() {
        if (manager.getRoom().equals(this.currentRoom.getNameBackend()) && !this.currentRoom.equals("LOCKER ROOM") && !this.currentRoom.equals("DANCE FLOOR")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * If the manager and player are in the same room, and that room is not
     * dance floor and is not locker room. Then he can take hist 15% cut. The
     * amount is calculated and subtracted from the player.
     *
     * @return feedback : String
     */
    public String managerTakesCut() {
        if (manager.getRoom().equals(this.currentRoom.getNameBackend())) {
            if (!this.currentRoom.getNameBackend().equals("DANCE FLOOR") && !this.currentRoom.getNameBackend().equals("LOCKER ROOM")) {
                double d = Math.round(player.getMoneySaved() * manager.getPercentage() * 100.0) / 100.0;
                this.player.removeMoney(d);
                return "Manager noticed you leaving, and took his " + manager.getPercentage() * 100 + "% cut. He took $" + d + ".";
            }
        }
        return "";
    }

    /**
     * Sets the hotelMotel variable to the string value
     *
     * @param s : STring
     */
    @Override
    public void setHotelMotel(String s) {
        this.hotelMotel = s;
    }
    private DanceMech dance;

    /**
     * This method takes specific key words, and performs a given command action
     * according to the string command.
     *
     * <p>
     * First if the player is in hotel or motel, the room is changed to that
     * room.
     *
     * <p>
     * If the player is home, the moves are reset. And the manager is reset. If
     * any other action is performed than being home, 3 hunger is rmoved, and 1
     * move is removed. And the manager will attempt to move.
     *
     * <p>
     * Lastly all commands are ran through to see, if the parameter command is
     * equal a specified accepted command. And the Appropriate action is
     * performed
     *
     * @param command
     * @return
     */
    @Override
    public String processCommand(String command) {
        if (!this.hotelMotel.equals("")) {
            switch (this.hotelMotel) {
                case "HOTEL":
                    goRoom(hotel);
                    break;
                case "MOTEL":
                    goRoom(motel);
                    break;
            }
        }
        if (this.currentRoom.getNameBackend().equals("HOME")) {
            player.setMoves(12);
            manager.setCurrentRoom(office);
        } else {
            player.removeMoves(1);
            player.removeHunger(3);
        }
        manager.moveManager();
        System.out.println("Manager at: " + manager.getRoom());

        switch (command.toUpperCase()) {
            case "KEYS":
                if (!this.inv.Inventory.contains(inv.getCarKeys())) {
                    // No keys yet:
                    inv.Inventory.add(inv.getCarKeys());
                    return "You found some keys.";
                } else {
                }
                break;

            case "WORK":
                String val = "";
                if (inv.Inventory.contains(inv.getCarKeys())) {
                    goRoom(drive);
                    val += drive.getShortDescription();
                    System.out.println("Went to DRIVE");
                } else {
                    val += "You don't have your keys..";
                }
                return val;

            case "CAR":
                goRoom(back);
                System.out.println("Went to BACKROOM");
                return "You are " + back.getShortDescription();

            case "HOME":
                goRoom(home);
                this.inv.removeFromList(inv.getCarKeys());
                System.out.println("Went to HOME");
                this.player.resetMoves();
                this.pRoomInvite = false;
                this.regularInRoom = null;
                return "You are " + home.getShortDescription();

            case "LOCKER":
                goRoom(locker);
                System.out.println("Went to LOCKER");
                return "You are " + locker.getShortDescription();

            case "DANCEFLOOR":
                goRoom(floor);
                System.out.println("Went to DANCE FLOOR");
                return "You are at the main dance floor." + "\n" + "The crowd looks to have some money to spend on a good show.";

            case "STEAL":
                System.out.println("STOLE");
                Lockerroom locker = new Lockerroom();
                return locker.Lockerroom(this.inv, this.itemlist);

            case "BACKROOM":
                goRoom(back);
                System.out.println("Went to BACKROOM");
                return "You are " + back.getShortDescription();

            case "OFFICE":
                System.out.println("office clicked");
                return "That is the managers office, I'm not supposed to go in there.";

            case "OUTSIDE":
                goRoom(outside);
                System.out.println("Went to OUTSIDE");
                return "You are " + outside.getShortDescription() + ", this is where the Bouncer hangs out. He seems to like you..";

            case "DANCE":
                dance = new DanceMech();
                if (this.pRoomInvite && this.privateRoomCommand != null) {
                    if (this.privateRoomCommand.equals("ACCEPT")) {
                        goRoom(privateRoom);
                    }
                    return dance.PrivateRoomInvite(this.getPrivateRoomCommand());
                }
                return dance.DanceMech() + "\n" + dance.danceMovePrint();

            case "PRIVATEROOM":
                dance = new DanceMech();
                if (this.pRoomInvite && this.privateRoomCommand != null) {
                    if (this.privateRoomCommand.equals("ACCEPT")) {
                        goRoom(privateRoom);
                    }
                    if (this.privateRoomCommand.equals("DANCE")) {
                        val = "";
                        val += dance.PrivateRoomInvite(this.getPrivateRoomCommand());

                        goRoom(floor);

                        this.pRoomInvite = false;
                        this.regularInRoom = null;
                        return val;
                    }
                }
                break;

            case "FLIRT":
                Preference Gold0 = new Preference("Gold", 0);
                Regular Bouncer = new Regular("Jack the bouncer", 45, "muscular, he's always smiled at you, and greets you every morning. Maybe he fancies you a bit..?", Gold0, Gold0);
                Flirt flirt = new Flirt();

                return "You flirted with Jack the Bouncer." + "\n" + flirt.Flirt(Bouncer);

            default:
                break;
        }

        return "";
    }

    /**
     * Sets the players currentRoom to a specified room
     * @param room : Room
     */
    public void goRoom(Room room) {
        this.currentRoom = room;
    }

    /**
     * Gets the description of the currentRoom of the player.
     * @return description : String
     */
    public String getRoomDescription() {
        return this.currentRoom.getShortDescription();
    }

    /**
     * calls the winDegree method on the reglist, using a specified regular as parameter.
     * This returns a percentage of how well that player did, in finding the richest man in the list of men.
     * @param regular : IRegular
     * @return percentage : double
     */
    @Override
    public double getWinPercent(IRegular regular) {
        return this.reglist.winDegree(regular);
    }

    /**
     * Removes 1 day left for the player
     */
    public void removeDaysLeft() {
        this.player.removeDaysLeft(1);
    }

    /**
     * Returns the helpText variable for the given room, that the player is in.
     * @return 
     */
    public String getRoomHelpText() {
        return this.currentRoom.getHelpText();
    }
}
