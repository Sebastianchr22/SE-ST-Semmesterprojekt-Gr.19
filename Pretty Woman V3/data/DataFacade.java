package data;

import acq.IData;
import acq.ILogic;
import acq.IPlayer;
import java.util.ArrayList;
import java.util.Collection;
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
    public void save(Collection<Integer> stats, Collection<String> inventory) {
        data = this;
        TXTSaver saver = new TXTSaver();
        saver.save(stats, inventory);
    }

    @Override
    public void saveHighScore() {
        HighScore saver = new HighScore();
        saver.save(100);
    }
    
    
    
    private IPlayer player;

    @Override
    public IPlayer load() {
        TXTSaver saver = new TXTSaver();
        player = saver.load();
        return player;
    }

    @Override
    public void loadHighScore() {
        HighScore saver = new HighScore();
        saver.load();
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
