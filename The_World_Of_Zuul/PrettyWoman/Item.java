/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrettyWoman;

/**
 *
 * @author Sleaf
 */
public class Item {

    private int ID;
    private String name;
    private String description;
    private String category;
    
    Item(){
        Item goldring = new Item(0, "Gold Ring", "A nice gold ring", "Gold");
    }
    Item(int ID, String name, String desc, String cat) {
        this.ID = ID;
        this.name = name;
        this.description = desc;
        this.category = cat;
    }

    public String getValues() {
        String values = this.name + " - " + this.description;
        return values;
    }

    public int getID() {
        return this.ID;
    }

    public String getCat() {
        return this.description;
    }

    
    public void createInventory(){
        Inventory inv = new Inventory();
    }
    
    public void createStartInv(){
        Inventory inv = new Inventory();
        Item goldring = new Item(0, "Gold Ring", "A nice gold ring", "Gold");
        inv.addToIventory(goldring);
        inv.showInventory();
    }
}

//skal dette bruges?
//Få første objekt ind i mit inventory fra starten af spillet
class createItems{
    
    createItems(){
        Item goldring = new Item(0, "Gold Ring", "A nice gold ring", "Gold");
    }
    
    public void createItems() {
        Item goldring = new Item(0, "Gold Ring", "A nice gold ring", "Gold");
    }
    
}