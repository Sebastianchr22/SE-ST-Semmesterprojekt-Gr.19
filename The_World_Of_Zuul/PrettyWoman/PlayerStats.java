package PrettyWoman;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Sebas
 */
class PlayerStats {
    private int Experience = 12;
    private int personalImprovements = 5;
    private double moneySaved = 0;
    PlayerStats(){}
    public double getMoneySaved(){
        return this.moneySaved;
    }
    public int getPersonalImprovements(){
        return this.personalImprovements;
    }
    public int getExperience(){
        return this.Experience;
    }
    public int addExperience(int value){
        return this.Experience+=value;
    }
    public double addMoneySaved(double value){
        return this.moneySaved+=value;
    }
    public int addPersonalImprovements(int value){
        return this.personalImprovements+=value;
    }
}
