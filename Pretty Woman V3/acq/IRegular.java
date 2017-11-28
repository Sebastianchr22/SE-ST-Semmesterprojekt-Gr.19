package acq;
import acq.IPreference;

public interface IRegular {
    public String getName();
    public int getAge();
    public String getLooks();
    public double getWealth();
    public String getPreferences();
    public IPreference getPreference0();
    public IPreference getPreference1();
    public String info();
}
