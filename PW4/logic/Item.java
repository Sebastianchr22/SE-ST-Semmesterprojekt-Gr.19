package logic;
public class Item implements acq.IItem {

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
   
    
    @Override
    public String toString(){
        return this.ID + "." + this.name + " - " + this.description;
    }
}