package acq;

import java.util.ArrayList;
import java.util.Collection;
import javafx.collections.ObservableList;

public interface IData {

    public void injectLogic(ILogic logic);
    
    public void save(Collection<Integer> stats, Collection<String> inventory);

    public IPlayer load();
    

    public void saveHighScore(int score);

    public ObservableList loadHighScore();

    public int scoreCalc();

    public ArrayList<Integer> highScores(ArrayList<Integer> list);

    public ArrayList<Integer> getHighScores();

}
