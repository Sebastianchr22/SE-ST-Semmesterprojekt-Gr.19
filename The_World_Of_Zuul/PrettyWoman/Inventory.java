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
class Inventory extends Item{
    ArrayList<Item> Inventory = new ArrayList<>();
    public void addToIventory(Item item){
        Inventory.add(item);
    }
    public void removeFromInventory(Item item){
        Inventory.remove(item);
    }
    public void showInventory(){
        int count = 0;
        for(Item item : Inventory){
            count++;
            System.out.println(item.getValues());
        }
        /*if(count == 0){
            System.out.println("Your inventory is empty.");
        }*/
    }
    
}
