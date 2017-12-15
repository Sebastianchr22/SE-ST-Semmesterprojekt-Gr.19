package data;

import acq.IData;
import acq.ILogic;
import acq.IPlayer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import logic.LogicFacade;

public class DataFacade implements IData {

    private static ILogic logic = LogicFacade.getInstance();
    
    /**
     * Method to mutate the private ILogic variable, to the Ilogic variable in use by the starter class.
     * This prevents null pointer exceptions
     * @param logic : ILogic type
     */
    @Override
    public void injectLogic(ILogic logic) {
        this.logic = logic;
    }
 
    /**
     * Creates a new object of the TXTSaver type, and calls the save method, with a given collection of ints called stats
     * and a collection of strings called inventory. This inventory is only the names of items, and stats only the numbers.
     * @param stats : Collection
     * @param inventory : Collection
     */
    @Override
    public void save(Collection<Integer> stats, Collection<String> inventory) {
        TXTSaver saver = new TXTSaver();
        saver.save(stats, inventory);
    }

    /**
     * Creates a new object of the TXTSaver type, and calls the savehighscore method on it, with a given score as a parameter.
     * this method will catch a fileNotFoundException, when the highscore.txt does not exist, or is deleted.
     * This makes sure that the game does not crach when the file is not yet created.
     * If the exception is caught, a new file will be created, with the score in it.
     * @param score 
     */
    @Override
    public void saveHighScore(int score) {
        TXTSaver saver = new TXTSaver();
        try {
            saver.saveHighScore(score);
        } catch (IOException ex) {
            System.out.println("Error saving highscore");
            Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private IPlayer player;

    /**
     * This method creates a new player of the IPlayer type. This player is set as the TXTSaver objects load method return type. Which is an IPlayer
     * This method will also catch a fileNotFoundException, and print an error message.
     * @return player : IPlayer
     */
    @Override
    public IPlayer load() {
        TXTSaver saver = new TXTSaver();
        try {
            player = saver.load();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return player;
    }

    /**
     * This method will create a new object of the TXTSaver type, and call the loadHighScore method.
     * The loadHighScore method will return an ObservableList, and so will this method. The list is already sorted, and only contains integers
     * @return 
     */
    @Override
    public ObservableList loadHighScore() {
        TXTSaver saver = new TXTSaver();
        try {
            return saver.loadHighScore();
        } catch (IOException ex) {
            System.out.println("Error loading highscores");
            Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }


}
