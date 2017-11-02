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
    private int size;
    
    Item(){
    }
    
    Item(int ID, String name, String desc, String cat, int size) {
        this.ID = ID;
        this.name = name;
        this.description = desc;
        this.category = cat;
        this.size = size;
    }

    public String getValues() {
        String values = this.name + " - " + this.description;
        return values;
    }

    public int getID() {
        return this.ID;
    }
    public String getName() {
        return this.name;
    }
    public String getDesc() {
        return this.description;
    }
    public String getCat() {
        return this.category;
    }
    public int getSize() {
        return this.size;
    }
   
}