package acq;

import java.util.ArrayList;

public interface IPlayer {
    public double getMoneySaved();
    public int getEnhancements();
    public int getExperience();
    public int getHunger();
    public int getDaysLeft();
    public int getMoves();
    
    public ArrayList<String> getInv();
}
