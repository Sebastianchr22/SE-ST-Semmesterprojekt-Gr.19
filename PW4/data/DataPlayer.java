package data;

import java.util.ArrayList;

public class DataPlayer implements acq.IPlayer {

    private int Experience = 0;
    private int Enhancements = 0;
    private int Moves = 12;
    private double moneySaved = 10;
    private int currentHunger = 100;
    private int daysLeft = 20;
    
    private ArrayList<String> inv = new ArrayList();
    
    DataPlayer(){}

    DataPlayer(int exp, int enh, int moves, double money, int hunger, int days, ArrayList<String> list) {
        this.Enhancements = enh;
        this.Experience = exp;
        this.moneySaved = money;
        this.Moves = moves;
        this.currentHunger = hunger;
        this.daysLeft = days;
        this.inv = list;
    }

    @Override
    public double getMoneySaved() {
        return this.moneySaved;
    }

    @Override
    public int getEnhancements() {
        return this.Enhancements;
    }

    @Override
    public int getExperience() {
        return this.Experience;
    }

    @Override
    public int getHunger() {
        return this.currentHunger;
    }

    @Override
    public int getDaysLeft() {
        return this.daysLeft;
    }

    @Override
    public int getMoves() {
        return this.Moves;
    }

    @Override
    public ArrayList<String> getInv() {
        return this.inv;
    }
}
