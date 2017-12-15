package acq;

public interface IPreference {

    /**
     * Returns the string value of a preference's name and amount.
     * @return preference : String
     */
    public String getPreference();

    /**
     * Returns the name of the specific preference
     * @return name : String
     */
    public String getName();

    /**
     * Returns the amount of the specific preference
     * @return amount : int
     */
    public int getAmount();
}
