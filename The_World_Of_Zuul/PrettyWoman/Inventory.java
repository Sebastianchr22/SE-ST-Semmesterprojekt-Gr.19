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
    
    //Items:
    Inventory(){
        //Items:
     Item weddingring = new Item(0, "Wedding Ring", "Your wedding ring", "Silver",3);
     Item goldring = new Item(1, "Gold Ring", "A nice gold ring", "Gold",3);
     Item goldearring = new Item(2, "Gold Earring", "A nice gold earring", "Gold",3);
     Item goldnecklace = new Item(3, "Gold Ring", "A nice gold necklace", "Gold",3);
     Item goldwristwatch = new Item(4, "Gold Wristwatch", "A nice gold wristwatch", "Gold",3);
     Item goldbracelet = new Item(5, "Gold Bracelet", "A nice gold bracelet", "Gold",3);
     
     //Adds all starting items to the inventory:
        Inventory.add(weddingring);
        Inventory.add(goldring);
        Inventory.add(goldearring);
        Inventory.add(goldnecklace);
        Inventory.add(goldwristwatch);
        Inventory.add(goldbracelet);
       showInventory();
        System.out.println("Created in Inventory Class");
    }
    
    public void addToIventory(Item item){
        Inventory.add(item);
    }
    public void removeFromInventory(Item item){
        Inventory.remove(item);
    }
    public String showInventory(){
        for(Item item : Inventory){
            System.out.println(item.getValues());
        }
        return "";
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
    public boolean checkCapacity(Item item){
        countItems();
        if(totalWeight + item.getSize() <= 1000){
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
