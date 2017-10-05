


/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
class Regular 
{
    private int ID = 0;
    private String name;
    private int age;
    private String looks;
    private double wealth;
    private String preference0;
    private String preference1;
    private int preferencevalue0;
    private int preferencevalue1;
    public Regular(String name, int age, String looks, String preference0, int preferenceValue0, String preference1, int preferenceValue1) 
    {
        this.name = name;
        this.age = age;
        this.looks = looks;
        wealth = Math.round(500+Math.random()*1500000000);
        this.preference0 = preference0;
        this.preferencevalue0 = preferenceValue0;
        this.preference1 = preference1;
        this.preferencevalue1 = preferenceValue1;
    }

    Regular()
    {
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
        return "Preferences:" + preference0;
    }
    
}

