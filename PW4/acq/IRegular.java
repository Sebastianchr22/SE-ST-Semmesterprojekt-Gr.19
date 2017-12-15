package acq;

import acq.IPreference;

public interface IRegular {

    /**
     * Returns a specific regulars name, String
     *
     * @return name : String
     */
    public String getName();

    /**
     * Returns a given Regulars age, int
     *
     * @return age : Integer
     */
    public int getAge();

    /**
     * Returns a description of the regulars looks.
     *
     * @return looks : String
     */
    public String getLooks();

    /**
     * Returns the Regular's randomly generated wealth
     *
     * @return wealth : Integer
     */
    public double getWealth();

    /**
     * Returns a string description of the given Regulars Preferences
     *
     * @return Preferences : String
     */
    public String getPreferences();

    /**
     * Returns the first given preference of the Regular.
     *
     * @return IPreference, amount and name.
     */
    public IPreference getPreference0();

    /**
     * Returns the second given preference of the Regular.
     *
     * @return IPreference, amount and name.
     */
    public IPreference getPreference1();

    /**
     * Returns a description of the regular as a whole
     *
     * @return description : String
     */
    public String info();
}
