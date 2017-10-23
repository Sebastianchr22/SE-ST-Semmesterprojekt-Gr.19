package PrettyWoman;

import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sleaf
 */
class Inventory{
    ArrayList<Item> Inventory = new ArrayList<Item>();
    
    public void addToIventory(Item item){
        Inventory.add(item);
    }
    
    public void removeFromInventory(Item item){
        Inventory.remove(item);
    }
    
    public void showInventory(){
        for(Item item : Inventory){
            System.out.println(item.getValues());
        }
    }
    
}
