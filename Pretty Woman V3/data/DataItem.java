
package data;

public class DataItem implements acq.IItem {

    private int ID;
    private String name;
    private String description;
    private String category;
    private int size;
    
    DataItem(){
    }
    
    DataItem(int ID, String name, String desc, String cat, int size) {
        this.ID = ID;
        this.name = name;
        this.description = desc;
        this.category = cat;
        this.size = size;
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