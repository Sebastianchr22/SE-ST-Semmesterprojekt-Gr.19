package data;

import acq.IItem;
import acq.ILogic;
import acq.IPlayer;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;

public class DataFacade implements acq.IData {

    private ArrayList<Integer> scores;
    private ILogic logic;

    @Override
    public void injectLogic(ILogic logic) {
        this.logic = logic;
    }

    @Override
    public void save() {
        TXTSaver saver = new TXTSaver();
        saver.save();
    }

    @Override
    public void saveHighScore() {
        HighScore saver = new HighScore();
        saver.save(scoreCalc());
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

    @Override
    public Collection<String> InventoryString() {
        return logic.getDataInv();
    }

    @Override
    public int getExperience() {
        return logic.getExperience();
    }

    @Override
    public int getEnhencements() {
        return logic.getEnhencements();
    }

    @Override
    public int getMoves() {
        return logic.getMoves();
    }

    @Override
    public double getMoneySaved() {
        return logic.getMoneySave();
    }

    @Override
    public int getCurrentHunger() {
        return logic.getCurrentHunger();
    }

    @Override
    public int getDaysLeft() {
        return logic.getDaysLeft();
    }

    public double getWinPercent() {
        return logic.getWinPercent();
    }

    @Override
    public int scoreCalc() {
        return (int) (getMoneySaved() + (getMoneySaved() * 1 + (getWinPercent()) / 100.0) + 1.0 + ((getEnhencements() + getExperience()) / 100.0 * getDaysLeft()));
    }

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
}
