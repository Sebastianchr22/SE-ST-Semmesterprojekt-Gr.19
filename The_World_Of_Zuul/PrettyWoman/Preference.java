package PrettyWoman;
public class Preference {
    private String name;
    private int amount;
    
    Preference(String name, int amount){
        this.name = name;
        this.amount = amount;
    }
    public String getPreference(){
        return "Likes " + amount + " " + name+ " item(s).";
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
