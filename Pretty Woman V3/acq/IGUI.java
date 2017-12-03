package acq;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public interface IGUI {

    void injectLogic(ILogic logic);

    void start(Stage mainStage) throws Exception;

    public void start();

    public void newGame(MouseEvent event);

    public void mainMenu(MouseEvent event);

    public void loadGame(MouseEvent event);

    //Access to logic methods:
    void save();

    void load();

    public ObservableList loadHighScores();

    double getMoney();
    
    boolean getGameWon();

    int getExp();

    int getEnh();

    int getMoves();

    int getDaysLeft();

    public String getCurrentRoom();

    public String getCapacity();

    public int getHunger();

    public String getShortHunger();

    public String buyFood();

    public String buyEnh();

    public ObservableList<IItem> getInventory();

    public void removeItem(IItem item);

    public String processCommand(String command);

    public String getRegularInRoomInfo();

    public boolean managerPlayerSameRoom();

    public String managerTakesCut();

    public String getRoomHelpText();

    public String getRoomDescription();

    public Scene getScene();

    public void setPrivateRoomCommand(String s);

    public boolean getPRoomInvite();

    public void removeDaysLeft();

}
