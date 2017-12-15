package acq;

public interface IItem {

    /**
     * Returns the ID of the given item
     * @return ID : int
     */
    public int getID();

    /**
     * Returns the items name
     * @return name : String
     */
    public String getName();

    /**
     * Returns a description of the item
     * @return Description : String
     */
    public String getDesc();

    /**
     * Returns the category of the item
     * @return category : String
     */
    public String getCat();

    /**
     * Returns the given size of the item.
     * @return size : Int
     */
    public int getSize();
}
