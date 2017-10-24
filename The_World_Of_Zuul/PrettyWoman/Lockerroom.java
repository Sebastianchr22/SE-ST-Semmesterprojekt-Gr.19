/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrettyWoman;

/**
 *
 * @author Sebas
 */

public class Lockerroom {
    public int genRandom(Inventory itemlist){
        return (int) Math.round(0+Math.random()*itemlist.listLenght());
    }
    Lockerroom(Inventory itemlist, Inventory inv){
        int random = genRandom(itemlist);
        System.out.println("");
        System.out.println("You found a "+itemlist.Inventory.get(random).getName());
        inv.addToIventory(itemlist.Inventory.get(random));
        System.out.println("");
        itemlist.removeFromInventory(itemlist.Inventory.get(random));
        System.out.println("");
        itemlist.showInventory();
    }
}
