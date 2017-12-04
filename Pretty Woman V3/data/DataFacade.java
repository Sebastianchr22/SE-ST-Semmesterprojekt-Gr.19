package data;

import acq.IData;
import acq.ILogic;
import acq.IPlayer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.LogicFacade;

public class DataFacade implements IData {

    private ArrayList<Integer> scores;
    private static ILogic logic = LogicFacade.getInstance();
    private static IData data;
    

    @Override
    public void injectLogic(ILogic logic) {
        this.logic = logic;
    }
    
    public static IData getInstance(){
        return data;
    }
    
    @Override
    public void newFiles(){
        TXTSaver saver = new TXTSaver();
        saver.newFiles();
    }

    @Override
    public void save(Collection<Integer> stats, Collection<String> inventory) {
        data = this;
        TXTSaver saver = new TXTSaver();
        saver.save(stats, inventory);
    }

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

    @Override
    public IPlayer load() {
        TXTSaver saver = new TXTSaver();
        player = saver.load();
        return player;
    }

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

    public Collection<String> InventoryString() {
        return logic.getDataInv();
    }

   /* @Override
    public int scoreCalc() {
        return (int) (getMoneySaved() + (getMoneySaved() * 1 + (getWinPercent()) / 100.0) + 1.0 + ((getEnhencements() + getExperience()) / 100.0 * getDaysLeft()));
    }*/

    @Override
    public ArrayList<Integer> highScores(ArrayList<Integer> list) {
        this.scores = new ArrayList();
        return this.scores = list;
    }

    @Override
    public ArrayList<Integer> getHighScores() {
        //Sort before returning:

        return this.scores;
    }

    @Override
    public int scoreCalc() {
        return 100;
    }
}
