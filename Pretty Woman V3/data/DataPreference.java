package data;

import logic.*;



public class DataPreference {
    private String name;
    private int amount;
    
    DataPreference(String name, int amount){
        this.name = name;
        this.amount = amount;
    }
    public String getPreference(){
        return "likes " + amount + " " + name+ " item(s).";
    }
    public void updatePreference(String name, int amount){
        this.name=name;
        this.amount=amount;
    }
    public String getName(){
        return this.name;
    }
    public int getAmount(){
        return this.amount;
    }
}
