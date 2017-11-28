package data;

import acq.IItem;
import java.util.ArrayList;

public class DataInventory implements acq.IInventory {

    ArrayList<IItem> Inventory = new ArrayList();

    DataInventory() {

    }

    @Override
    public void addToList(IItem item) {
        Inventory.add(item);
    }

    @Override
    public void removeFromList(IItem item) {
        Inventory.remove(item);
    }

    @Override
    public int listLenght() {
        int count = 0;
        for (IItem item : Inventory) {
            count++;
        }
        return count;
    }
}
