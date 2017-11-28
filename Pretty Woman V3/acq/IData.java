package acq;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;

public interface IData {

    public void injectLogic(ILogic logic);

    public void save();

    public IPlayer load();

    public void saveHighScore();

    public void loadHighScore();

    public Collection<String> InventoryString();

    public int getExperience();

    public int getEnhencements();

    public int getMoves();

    public double getMoneySaved();

    public int getCurrentHunger();

    public int getDaysLeft();

    public int scoreCalc();

    public ArrayList<Integer> highScores(ArrayList<Integer> list);

    public ArrayList<Integer> getHighScores();

}
