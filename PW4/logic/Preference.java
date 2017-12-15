package logic;


public class Preference implements acq.IPreference {
    private String name;
    private int amount;
    
    /**
     * Constructor for a preference, will set its name, and amount.
     * @param name : String
     * @param amount : Integer
     */
    Preference(String name, int amount){
        this.name = name;
        this.amount = amount;
    }
    
    /**
     * Returns a string version of the specific preference.
     * @return descriptive : String
     */
    public String getPreference(){
        return "likes " + amount + " " + name+ " item(s).";
    }
    
    /**
     * Returns the name of the preference
     * @return name : String
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Returns the amount of the specific preference
     * @return amount : int
     */
    public int getAmount(){
        return this.amount;
    }
}
