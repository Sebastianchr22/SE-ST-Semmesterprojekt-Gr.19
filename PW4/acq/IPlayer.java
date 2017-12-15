package acq;

import java.util.ArrayList;

public interface IPlayer {

    /**
     * Returns the players saved money
     *
     * @return money : Double
     */
    public double getMoneySaved();

    /**
     * Returns the amount of enhancements the player has bought
     *
     * @return enhancements : int
     */
    public int getEnhancements();

    /**
     * Returns the players amount of experience
     *
     * @return Experience : int
     */
    public int getExperience();

    /**
     * Returns the players current hunger
     *
     * @return Hunger : Int
     */
    public int getHunger();

    /**
     * Returns the amount of days left, the player has
     *
     * @return daysLeft : Int
     */
    public int getDaysLeft();

    /**
     * Returns the players moves left
     *
     * @return moves : int
     */
    public int getMoves();

    /**
     * Will create a new arrayList of strings, with alle the names of the items
     * the player has in their inventory.
     *
     * @return ArrayList of Strings : Item names.
     */
    public ArrayList<String> getInv();
}
