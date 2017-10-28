package PrettyWoman;




/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
class Regular 
{
    private int ID;
    private String name;
    private int age;
    private String looks;
    private double wealth;
    private Preference preference0;
    private Preference preference1;
 
    Regular(int ID, String name, int age, String looks, Preference preference0, Preference preference1) 
    {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.looks = looks;
        wealth = Math.round(1000+Math.random()*2200000);
        this.preference0 = preference0;
        this.preference1 = preference1;
    }

    public int getID()
    {
        return ID;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public String getLooks()
    {
        return looks;
    }
    public double getWealth()
    {
        return wealth;
    }
    public String getPreferences()
    {
        return "Preferences:\n" + preference0.getAmount() + " " + preference0.getName() + " are needed.\n" + preference1.getAmount() + ": " + preference1.getName() + " are needed.\n";
    }
    public Preference getPreference0()
    {
        return this.preference0;
    }
    public Preference getPreference1()
    {
        return this.preference1;
    }
    public boolean getInvite()
    {
        return false;
    }
    public String info(){
        return name + ", " + age + ", Looks " + "\"" + looks + "\"" + "\n" + preference0.getPreference() + " Also " + preference1.getPreference();
    }
}

