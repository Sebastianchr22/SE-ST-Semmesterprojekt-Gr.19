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
    
    
    
    Driver()
    {
    }
}
