package acq;
public interface IInventory {
    public void addToList(IItem item);
    public void removeFromList(IItem item);
    public int listLenght();
}
