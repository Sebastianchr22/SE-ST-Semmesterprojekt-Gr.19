package PrettyWoman;

import java.util.ArrayList;
class Inventory extends Item{
    ArrayList<Item> Inventory = new ArrayList<>();

    public int totalSize = 0;
    public int totalWeight = 0;
    public int itemsCarried = 0;
    public int goldItems = 0;
    public int silverItems = 0;
    public int Outfit = 0;
    public int wig = 0;
    public int shoes = 0;
    public int makeup = 0;
    public boolean weddingring;
    
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
    public int listLenght(){
        int count = 0;
        for(Item item : Inventory){
            count++;
        }
        return count;
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
                case "Outfit":
                    Outfit++;
                    break;
                case "Wig":
                    wig++;
                    break;
                case "Shoes":
                    shoes++;
                    break;
                case "Makeup":
                    makeup++;
                    break;
                case "Wedding":
                    weddingring=true;
                    break;
            }
            totalSize+=item.getSize();
            itemsCarried++;
            totalWeight=totalSize*5;
        }
    }
    public boolean checkCapasity(int itemWeight){
        countItems();
        if(totalWeight + itemWeight <= 1000){
            //Under capasity:
            return true;
        }else{
            //Over capasity:
            System.out.println("You cannot carry any more.");
            return false;
        }
    }
    public int getTotalWeight(){
        return this.totalWeight;
    }
    public void weightToString(){
        System.out.println("Capacity: " + totalWeight + "/1000g");
    }
}
