package PrettyWoman;
import java.io.*;
public interface SaveBuilder {
    public void saveGame(Driver driver);
    public void loadGame(Driver driver);
    public void setDriver(String value, int index, Driver driver);
}
