package logic;

import acq.IItem;

public interface ListBuilder {
    void addToList(Item item);
    void removeFromList(Item item);
}