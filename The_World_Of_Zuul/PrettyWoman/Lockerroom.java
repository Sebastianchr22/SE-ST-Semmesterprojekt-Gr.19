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

public class Lockerroom extends DanceMech {
    public Item weddingring = new Item(0, "Wedding Ring", "Your wedding ring", "Wedding",3);
    public Item goldring = new Item(1, "Gold Ring", "A nice gold ring", "Gold",3);
    public Item goldearring = new Item(2, "Gold Earring", "A nice gold earring", "Gold",3);
    public Item goldnecklace = new Item(3, "Gold Ring", "A nice gold necklace", "Gold",3);
    public Item goldwristwatch = new Item(4, "Gold Wristwatch", "A nice gold wristwatch", "Gold",3);
    public Item goldbracelet = new Item(5, "Gold Bracelet", "A nice gold bracelet", "Gold",3);
    public int amountOfItems = 4;
    
    public int genRandom(){
        return (int) Math.round(0+Math.random()*amountOfItems);
    }
    public void steal(){
        inv.addToIventory(goldring);
        inv.addToIventory(goldearring);
        inv.addToIventory(goldnecklace);
        inv.addToIventory(goldwristwatch);
        inv.addToIventory(goldbracelet);
        inv.showInventory();
        
        int random = genRandom();
        System.out.println("You found a "+inv.Inventory.get(random).getName());
    }
    public static void main(String[] args) {
        Lockerroom locker = new Lockerroom();
        locker.steal();
        
    }
    
}
