package acq;

import java.util.ArrayList;
import java.util.Collection;
import javafx.collections.ObservableList;

public interface IData {

    /**
     * This will inject a the reference to the ILogic interface, implemented by the LogicFacade, into the DataFacade, for later use
     * This prevents nullPointerExceptions.
     * @param logic 
     */
    public void injectLogic(ILogic logic);
    
    /**
     * This method will print all data vertically in the savefile.txt
     * @param stats a collection of integers
     * @param inventory a collection of strings
     */
    public void save(Collection<Integer> stats, Collection<String> inventory);

    /**
     * This method will create a new player, with the give stats and inventory found in the save file.
     * @return IPlayer
     */
    public IPlayer load();
    
    /**
     * Used to save a given score in the highscore.txt.
     * @param score 
     */
    public void saveHighScore(int score);

    /**
     * Used to get an ObsevableList of all highscores found in the highscore.txt file.
     * @return ObservableList sorted high - low.
     */
    public ObservableList loadHighScore();
}
