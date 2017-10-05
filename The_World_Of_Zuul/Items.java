
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sleaf
 */


public class Items {
    
    //HashMap consist of a key and a value <K, V>
    //private HashMap <Items, String> ItemMap;
    
   /* 
    // Sets a list of item-keywords:
        public enum Items {
        RING("ring"),
        AMULET("amulet"),
        PANTIES("panties");
        
        private String itemString;
        Items(String itemString){
            this.itemString = itemString;
        }
        public String getItems(){
            return itemString;
        }
    }
    */
    
    //Initializes keys and values in the Hashmap
    //public ItemList(String desc){
    //    ItemMap = new HashMap<Items, String>();
    //}
    
    //Change ItemList to static to use this statement, then u can print use ItemList(); in main method
    private HashMap <Item, String> ItemMap;
           
    Items(){
        ItemMap = new HashMap<Item, String>();
        
        //Puts the items into the map as the 'key' role and adds a string value to it
        ItemMap.put(Item.RING, "Shiny golden ring");
        ItemMap.put(Item.AMULET, "Shiny golden amulet");
        ItemMap.put(Item.PANTIES, "These panties are my sexy ones");                
        
    }
    
    public void ItemList(){
        for(Item key : ItemMap.keySet()){
            System.out.println(key + " - " + ItemMap.get(key));
        }
    }
    public void ItemListe(){
    for(Item key : ItemMap.keySet()) {
            System.out.print(key + "  ");
        }
        System.out.println();
    }
    
    public static void main(String[] args){
        Items Inv = new Items();
        Inv.ItemList();
    }
    //find en løsning til en inventory (array)
    //lav en display inventory
    //add to inventory(item, desc.)
    //removeFromIventory(item)
}
    
        
        
    

