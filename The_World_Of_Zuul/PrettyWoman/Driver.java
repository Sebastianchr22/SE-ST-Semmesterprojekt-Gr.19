package PrettyWoman;

import java.util.ArrayList;

public class Driver
{

    Regulars reg = new Regulars();
    ArrayList<Regular> regularList = new ArrayList<>();
    ListOfRegulars reglist = new ListOfRegulars(regularList);
    PlayerStats playerStats = new PlayerStats();
    Inventory inv = new Inventory();
    Chance chanceCalc = new Chance();
    ItemList itemlist = new ItemList();
    Regular regularInRoom;
    boolean gameWon;
    boolean inPRoom;
    
    
    public void List(){
        for(int i = 0; i <= 2; i++){
            System.out.println("Index: " + i  + " " + regularList.get(i).info());
        }
    }
    Driver()
    {
        reg.createReglist(reglist);
    }
    public void setWon(boolean bool){
        this.gameWon=bool;
    }
    public void resetWon(){
        this.gameWon = false;
    }
    public void setInPRoom(boolean bool){
        this.inPRoom = bool;
    }
    public boolean getInPRoom(){
        return this.inPRoom;
    }
    public boolean getWon(){
        return this.gameWon;
    }
}
