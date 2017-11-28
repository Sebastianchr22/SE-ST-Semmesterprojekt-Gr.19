package acq;

import logic.Player;
import java.util.ArrayList;
import java.util.Collection;
import logic.Inventory;
import logic.Item;
import logic.ItemList;
import logic.ListOfRegulars;
import logic.Regular;

public interface ILogic {
    
    public void injectData(IData data);

    public void save();

    public void load();

    public boolean inPRoom();

    public IRegular regularInRoom();

    public void setExperience(int i);

    public void setEnhancements(int i);

    public void setMoves(int i);

    public void setMoneySaved(double d);

    public void setCurrentHunger(int i);

    public void setDaysLeft(int i);

    public void setInPRoom(boolean bool);

    public void setWon(boolean bool);

    public void setHighScore();
    
    public void setInventory(Inventory inventory);
    
    public void setItemList(ItemList list);
    
    public void setRegularList(ListOfRegulars list);
    
    public void setPlayer(Player player);

    public void addToInventory(Item item);

    public void addToItemList(Item item);

    public void removeFromInventory(Item item);

    public void removeFromItemList(Item item);

    public String info(IRegular regular);

    public void resetWon();
    
    
    public Collection<String> getDataInv();
    
    public Player getPlayer();
    
    public String getName(IRegular regular);

    public int getAmount(IPreference preference);

    public int getSpecific(String specific);

    public IPreference getPreference0(IRegular regular);

    public IPreference getPreference1(IRegular regular);

    public int getExperience();

    public int getEnhencements();

    public int getMoves();

    public double getMoneySave();

    public int getCurrentHunger();

    public int getDaysLeft();

    public ArrayList<Regular> getRegularList();

    public ArrayList<Item> getItemList();

    public ArrayList<Item> getInventory();

    public boolean getWon();

    public boolean getInPRoom();

    public IItem getWeddingRing();

    public int getScore();
    
    public void setWinPercent(double d);
     
    public double getWinPercent();
    
    public Regular getRegularInRoom();
        
    public String getCurrentRoom();
    
    public void setCurrentRoom(String s);

}
