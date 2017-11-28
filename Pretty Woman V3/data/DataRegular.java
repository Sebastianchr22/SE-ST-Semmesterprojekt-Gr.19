package data;

import logic.*;



public class DataRegular 
{
    private String name;
    private int age;
    private String looks;
    private double wealth;
    private DataPreference preference0;
    private DataPreference preference1;
 
    DataRegular(String name, int age, String looks, DataPreference preference0, DataPreference preference1) 
    {
        this.name = name;
        this.age = age;
        this.looks = looks;
        wealth = Math.round(1000+Math.random()*2200000);
        this.preference0 = preference0;
        this.preference1 = preference1;
    }

    String getName()
    {
        return name;
    }
    int getAge()
    {
        return age;
    }
    String getLooks()
    {
        return looks;
    }
    double getWealth()
    {
        return wealth;
    }
    String getPreferences()
    {
        return "Preferences:\n" + preference0.getAmount() + " " + preference0.getName() + " are needed.\n" + preference1.getAmount() + ": " + preference1.getName() + " are needed.\n";
    }
    DataPreference getPreference0()
    {
        return this.preference0;
    }
    DataPreference getPreference1()
    {
        return this.preference1;
    }
    String info(){
        return "You are looking at " + name + ", " + age + ", Looks " + looks + "\n" + "He " + preference0.getPreference() + " He also " + preference1.getPreference();
    }
}