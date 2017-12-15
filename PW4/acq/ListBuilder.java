package acq;

import acq.IItem;
import logic.Item;

public interface ListBuilder {
    void addToList(Item item);
    void removeFromList(Item item);
}