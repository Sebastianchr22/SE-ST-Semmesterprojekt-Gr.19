package PrettyWoman;
class Regular 
{
    private String name;
    private int age;
    private String looks;
    private double wealth;
    private Preference preference0;
    private Preference preference1;
 
    Regular(String name, int age, String looks, Preference preference0, Preference preference1) 
    {
        this.name = name;
        this.age = age;
        this.looks = looks;
        wealth = Math.round(1000+Math.random()*2200000);
        this.preference0 = preference0;
        this.preference1 = preference1;
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
    public String info(){
        return "You are looking at " + name + ", " + age + ", Looks " + looks + "\n" + "He " + preference0.getPreference() + " He also " + preference1.getPreference();
    }
}

