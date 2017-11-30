package logic;

import acq.IData;
import acq.IItem;
import acq.ILogic;
import acq.IPlayer;
import acq.IPreference;
import acq.IRegular;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import javafx.collections.FXCollections;
import javafx.collections.*;

public class LogicFacade implements acq.ILogic {

    private IData data;
    private static ILogic logic;
    Room privateRoom = new Room("Private room", "in the private room, where everything can happen");
    Room office = new Room("Office", "in the managers office");
    Room outside = new Room("Outside", "in front of the strip club");
    Room motel = new Room("Motel", "in a motel");
    Room tower = new Room("Tower", "in the home of your new lover");
    Room home = new Room("Home", "home, where your daughter is");
    Room drive = new Room("Drive", "The old parkinglot, where your old car is");
    Room back = new Room("Backroom", "in the backroom.");
    Room locker = new Room("Locker room", "in the locker room. Here you can gather points and money by stealing from other strippers");
    Room floor = new Room("Dance floor", "on the floor. Here you can earn money by doing various dance moves or by talking to the guests to see if you meet someone interesting");

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
    Manager manager = new Manager("Manager", office);

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

        tower.setExit("home", home);
    }

//    public int getScore(){
//        return highscore = (playerStats.getMoneySaved() + (playerStats.getMoneySaved()*))
//    }
    @Override
    public void injectData(IData data) {
        this.data = data;
    }

    public static ILogic getInstance() {
        return logic;
    }

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

        System.out.println(newplayer.getInv().toString());
        for (String item : newplayer.getInv()) {
            if (!item.equals("Wedding Ring") && !item.equals("Car keys")) {
                Item found = containsItem(item);
                newInv.add(found);
                newItemList.remove(found);
                System.out.println("Added " + found.getName() + " to inv, and removed from Itemlist");
            } else if (item.equals("Wedding Ring")) {
                newInv.add(inv.getWeddingRing());
                System.out.println("added Wedding Ring");
            }
            if (item.equals("Car keys")) {
            }
        }

        inv.Inventory = newInv;
        itemlist.itemList = newItemList;
    }

    public Item containsItem(String name) {
        itemlist = new ItemList();
        for (Item listitem : itemlist.itemList) {
            if (listitem.getName().equals(name)) {
                System.out.println("ItemList contained: " + listitem.getName());
                return listitem;
            }
        }
        return null;
    }

    @Override
    public boolean inPRoom() {
        return this.getInPRoom();
    }

    //General:
    @Override
    public String info(IRegular regular) {
        return regular.info();
    }

    @Override
    public IRegular regularInRoom() {
        return this.regularInRoom;
    }

    @Override
    public void resetWon() {
        this.gameWon = false;
    }

    @Override
    public void setPrivateRoomCommand(String s) {
        this.privateRoomCommand = s;
    }

    @Override
    public String getPrivateRoomCommand() {
        return this.privateRoomCommand;
    }

    @Override
    public void addToInventory(Item item) {
        inv.addToList(item);
    }

    @Override
    public void addToItemList(Item item) {
        itemlist.addToList(item);
    }

    public void addToRegularList(Regular regular) {
        reglist.addToList(regular);
    }

    @Override
    public void removeFromInventory(Item item) {
        inv.removeFromList(item);
    }

    @Override
    public void removeFromItemList(Item item) {
        itemlist.removeFromList(item);
    }

    public void removeFromRegularList(Regular regular) {
        reglist.removeFroList(regular);
    }

    @Override
    public void removeMoves(int i) {
        this.player.removeMoves(i);
    }

    @Override
    public String getCurrentRoom() {
        return this.currentRoom.getNameBackend();
    }

    @Override
    public boolean getPRoomInvite() {
        return this.pRoomInvite;
    }

    @Override
    public void setRegularInRoom(IRegular regular) {
        this.regularInRoom = regular;
    }

    @Override
    public void setPRoomInvite(boolean bool) {
        this.pRoomInvite = bool;
    }

    @Override
    public void removeMoney(double d) {
        this.player.removeMoney(d);
    }

    @Override
    public void addExperience(int i) {
        this.player.addExperience(i);
    }

    @Override
    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    @Override
    public void setInPRoom(boolean bool) {
        this.inPRoom = bool;
    }

    @Override
    public void setWon(boolean bool) {
        this.gameWon = bool;
    }

    @Override
    public void setExperience(int i) {
        player.setExperience(i);
    }

    @Override
    public void setEnhancements(int i) {
        player.setEnhancements(i);
    }

    @Override
    public void setMoves(int i) {
        player.setMoves(i);
    }

    @Override
    public void setMoneySaved(double d) {
        player.setMoneySaved(d);
    }

    @Override
    public void setCurrentHunger(int i) {
        player.setCurrentHunger(i);
    }

    @Override
    public void setDaysLeft(int i) {
        player.setDaysLeft(i);
    }

    @Override
    public void addMoney(double d) {
        this.player.addMoney(d);
    }

    public Collection<String> getDataInv() {
        ArrayList<String> list = new ArrayList();

        for (Item item : inv.Inventory) {
            list.add(item.getName());
        }

        return list;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public boolean getInPRoom() {
        return this.inPRoom;
    }

    @Override
    public boolean getWon() {
        return this.gameWon;
    }

    @Override
    public ArrayList<Item> getInventory() {
        return new ArrayList(inv.Inventory);
    }

    @Override
    public ArrayList getItemList() {
        return new ArrayList(itemlist.itemList);
    }

    @Override
    public ArrayList getRegularList() {
        return new ArrayList(reglist.regularList);
    }

    @Override
    public IRegular getRandomRegular() {
        return this.reglist.getRandomRegular();
    }

    @Override
    public int getExperience() {
        return player.getExperience();
    }

    @Override
    public int getEnhencements() {
        return player.getEnhancements();
    }

    @Override
    public int getMoves() {
        return player.getMoves();
    }

    @Override
    public double getMoneySave() {
        return player.getMoneySaved();
    }

    @Override
    public int getCurrentHunger() {
        return player.getHunger();
    }

    @Override
    public int getDaysLeft() {
        return player.getDaysLeft();
    }

    @Override
    public int getSpecific(String specific) {
        return inv.getSpecific(specific);
    }

    @Override
    public int getAmount(IPreference preference) {
        return preference.getAmount();
    }

    @Override
    public String getName(IRegular regular) {
        return regular.getName();
    }

    public void updatePreference(String name, int amount) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IPreference getPreference0(IRegular regular) {
        return regular.getPreference0();
    }

    @Override
    public IPreference getPreference1(IRegular regular) {
        return regular.getPreference1();
    }

    @Override
    public Item getWeddingRing() {
        return this.inv.getWeddingRing();
    }

    public void setHighScore() {
        data.saveHighScore();
    }

    @Override
    public int getScore() {
        return this.highscore;
    }

    @Override
    public void setWinPercent(double d) {
        this.winPercent = d;
    }

    @Override
    public double getWinPercent() {
        return this.winPercent;
    }

    @Override
    public void setInventory(Inventory inventory) {
        this.inv = inventory;
    }

    @Override
    public void setItemList(ItemList list) {
        this.itemlist = list;
    }

    @Override
    public void setRegularList(ListOfRegulars list) {
        this.reglist = list;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public IRegular getRegularInRoom() {
        return this.regularInRoom;
    }

    @Override
    public String getCapacity() {
        return this.inv.weightToString();
    }

    public String getShortHunger() {
        return this.player.getShortHunger();
    }

    @Override
    public void buyFood() {
        if (player.getMoneySaved() > 100 && player.getHunger() <= 90) {
            this.player.addHunger(10);
            this.player.removeMoney(100);
        }
    }

    @Override
    public void buyEnhancements() {
        if (player.getMoneySaved() >= 150) {
            this.player.addEnhancements(1);
            this.player.removeMoney(150);
        }
    }

    @Override
    public ObservableList<IItem> getInventoryList() {
        ObservableList<IItem> list = FXCollections.observableArrayList();
        for (IItem item : inv.Inventory) {
            list.add(item);
        }
        return list;
    }

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

    @Override
    public void dropItem(IItem item) {
        String name = item.getName();
        System.out.println("Removing " + name);
        inv.removeFromList(getItem(name));
        if (!name.equals("Wedding Ring")) {
            itemlist.addToList(getItem(name));
        } else {
        }
    }

    public String getManagerRoom() {
        return this.manager.getRoom();
    }

    @Override
    public boolean managerPlayerSameRoom() {
        if (manager.getRoom().equals(this.currentRoom.getNameBackend()) && !this.currentRoom.equals("LOCKER ROOM") && !this.currentRoom.equals("DANCE FLOOR")) {
            return true;
        } else {
            return false;
        }
    }

    public String managerTakesCut() {
        return "Manager noticed you leaving, and took his " + manager.getPercentage() * 100 + "% cut. He took $" + player.getMoneySaved() * (manager.getPercentage() / 100.0) + ".";
    }

    @Override
    public String processCommand(String command) {
        switch (command.toUpperCase()) {
            case "KEYS":
                if (!this.inv.Inventory.contains(inv.getCarKeys())) {
                    // No keys yet:
                    inv.Inventory.add(inv.getCarKeys());
                    return "Added car keys";
                } else {
                }
                break;

            case "WORK":
                if (inv.Inventory.contains(inv.getCarKeys())) {
                    goRoom(drive);
                    System.out.println("Went to DRIVE");
                } else {
                }
                break;

            case "CAR":
                goRoom(back);
                System.out.println("Went to BACKROOM");
                break;

            case "HOME":
                goRoom(home);
                System.out.println("Went to HOME");
                break;

            case "LOCKER":
                goRoom(locker);
                System.out.println("Went to LOCKER");
                break;

            case "DANCEFLOOR":
                goRoom(floor);
                System.out.println("Went to DANCE FLOOR");
                return "The crowd looks to have some money to spend on a good show.";

            case "STEAL":
                System.out.println("STOLE");
                Lockerroom locker = new Lockerroom();
                return locker.Lockerroom(this.inv, this.itemlist);

            case "BACKROOM":
                goRoom(back);
                System.out.println("Went to BACKROOM");
                break;

            case "OUTSIDE":
                goRoom(outside);
                System.out.println("Went to OUTSIDE");
                break;

            case "DANCE":
                DanceMech dance = new DanceMech();
                if (this.pRoomInvite) {
                    System.out.println(this.getPrivateRoomCommand());
                    return dance.PrivateRoomInvite(this.getPrivateRoomCommand());
                } else {
                    return dance.danceMovePrint();
                }

            default:
                break;
        }
        manager.moveManager();
        player.removeMoves(1);
        player.removeHunger(3);
        return "";
    }

    public void goRoom(Room room) {
        this.currentRoom = room;
    }

    public String getRoomDescription() {
        return this.currentRoom.getShortDescription();
    }

    public String getRoomHelpText() {
        String help = "";
        switch (this.currentRoom.getNameBackend()) {
            case "HOME":
                help = "";
                break;
        }
        return help;
    }
}
