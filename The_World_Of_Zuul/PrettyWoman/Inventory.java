package PrettyWoman;

import java.util.ArrayList;

class Inventory extends Item {

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
    public int weddingring = 0;
    public int Adidas = 0;
    //Items:
    Inventory() {
        //Items:
        Item weddingring = new Item(0, "Wedding Ring", "Your wedding ring given to you by your ex- boyfriend", "Wedding", 3);
        
        //Adds all starting items to the inventory:
        Inventory.add(weddingring);
    }

    public void addToInventory(Item item) {
        Inventory.add(item);
    }

    public void removeFromInventory(Item item) {
        Inventory.remove(item);
    }

    public String showInventory() {
        int counter = 0;
        System.out.println("Item Name:                         Weight:");
        System.out.println("");
        for (Item item : Inventory) {
            System.out.println(counter + ". " + item.getValues() + "     |  " + item.getSize()*5 + "g");
            counter++;
        }
        System.out.println("");
        System.out.println(weightToString());
        return "";
    }

    public int listLenght() {
        int count = 0;
        for (Item item : Inventory) {
            count++;
        }
        return count;
    }

    public void countItems() {
        //Setting default values to avoid error counting:
        totalSize = 0;
        totalWeight = 0;
        itemsCarried = 0;
        goldItems = 0;
        silverItems = 0;
        Outfit = 0;
        wig = 0;
        shoes = 0;
        makeup = 0;
        weddingring = 0;
        Adidas = 0;
        for (Item item : Inventory) {
            switch (item.getCat()) {
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
                case "Adidas":
                    Adidas++;
                    break;
                case "Wedding":
                    weddingring = 1;
                    break;
            }
            totalSize += item.getSize();
            itemsCarried++;
        }
        totalWeight = totalSize*5;
    }

    public boolean checkCapacity(Item item) {
        countItems();
        if (totalWeight + item.getSize()*5 <= 1000) {
            //Under capasity:
            return true;
        } else {
            //Over capasity:
            System.out.println("You cannot carry any more.");
            return false;
        }
    }

    public int getTotalWeight() {
        return this.totalWeight;
    }

    public String weightToString() {
        countItems();
        return "Capacity: " + totalWeight + "/1000g";
    }
}
