package PrettyWoman;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sleaf
 */


public class Items_Maptest {
    
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
    public HashMap <ItemWord, String> ItemMap;
           
    Items_Maptest(){
        ItemMap = new HashMap<ItemWord, String>();
        
        //Puts the items into the map as the 'key' role and adds a string value to it
        ItemMap.put(ItemWord.RING, "Shiny golden ring");
        ItemMap.put(ItemWord.AMULET, "Shiny golden amulet");
        ItemMap.put(ItemWord.PANTIES, "These panties are my sexy ones");                        
    }
  /*  Items(int a){
        ItemMap = new HashMap<ItemWord, String>();
        ItemMap.put(ItemWord.RING, "Shiny golden ring");
        ItemMap.put(ItemWord.AMULET, "Shiny golden amulet");
        ItemMap.put(ItemWord.PANTIES, "These panties are my sexy ones"); 
        
        Random       random    = new Random();
        List<String> keys      = new ArrayList<String>(ItemMap.keySet());
        String       randomKey = keys.get( random.nextInt(keys.size()) );
        String       value     = ItemMap.get(randomKey);
    }
*/
    public void ItemList(){
        for(ItemWord key : ItemMap.keySet()){
            System.out.println(key + " - " + ItemMap.get(key));
        }        
    }
    
    public static void main(String[] args){
        Items_Maptest Inv = new Items_Maptest();
        Inv.ItemList();

    }
    //find en løsning til en inventory (array)
    //lav en display inventory
    //add to inventory(item, desc.)
    //removeFromIventory(item)
}
    
        
        
    

