package logic;

import acq.IData;
import acq.IPreference;
import acq.IRegular;
import java.util.ArrayList;
import java.util.Collection;

public class LogicFacade implements acq.ILogic {

    private IData data;
    
    private final ArrayList<IRegular> regularList;
    private ListOfRegulars reglist;
    private Player player;
    private Inventory inv;
    private ItemList itemlist;
    private Regular regularInRoom;
    private String currentRoom;
    private double winPercent;
    private boolean gameWon;
    private boolean inPRoom;
    private int highscore;

    public LogicFacade() {
        Regulars reg = new Regulars();
        regularList = new ArrayList<>();
        reglist = new ListOfRegulars(regularList);
        player = new Player();
        inv = new Inventory();
        itemlist = new ItemList();
        winPercent = 0;
        highscore = 0;
        currentRoom = "HOME";
    }

//    public int getScore(){
//        return highscore = (playerStats.getMoneySaved() + (playerStats.getMoneySaved()*))
//    }
    @Override
    public void injectData(IData data) {
        this.data = data;
    }

    @Override
    public void save() {
        data.save();
    }

    @Override
    public void load() {
        data.load();
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
    public String getCurrentRoom() {
        return this.currentRoom;
    }

    @Override
    public void setCurrentRoom(String s) {
        this.currentRoom = s;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public Regular getRegularInRoom() {
        return this.regularInRoom;
    }

}
