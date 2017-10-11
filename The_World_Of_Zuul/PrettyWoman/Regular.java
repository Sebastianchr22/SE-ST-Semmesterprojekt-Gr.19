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
    private String preference0;
    private String preference1;
    private int preferenceValue0;
    private int preferenceValue1;
    
    Regular()
    {
    }
    
    public Regular(int ID, String name, int age, String looks, String preference0, int preferenceValue0, String preference1, int preferenceValue1) 
    {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.looks = looks;
        wealth = Math.round(500+Math.random()*1500000000);
        this.preference0 = preference0;
        this.preferenceValue0 = preferenceValue0;
        this.preference1 = preference1;
        this.preferenceValue1 = preferenceValue1;
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
        return "Preferences:\n" + Integer.toString(preferenceValue0) + " " + preference0 + " are needed.\n" + Integer.toString(preferenceValue1) + ": " + preference1 + " are needed.\n";
    }
    public boolean getInvite()
    {
        return false;
    }
}

