package PrettyWoman;

import java.util.ArrayList;
class Inventory extends Item{
    ArrayList<Item> Inventory = new ArrayList<>();

    public int totalSize;
    public int totalWeight;
    public int itemsCarried = 0;
    public int goldItems = 0;
    public int silverItems = 0;
    public int Jewelry = 0;
    
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
    public void countItems(){
        for(Item item : Inventory){
            switch(item.getCat()){
                case "Gold":
                    goldItems++;
                    break;
                case "Silver":
                    silverItems++;
                    break;
            }
            totalSize+=item.getSize();
            itemsCarried++;
            totalWeight=totalSize*5;
        }
    }
    public void weightToString(){
        System.out.println("Capacity: " + totalWeight + "/1000g");
    }
}
