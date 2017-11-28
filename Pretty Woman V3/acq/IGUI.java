package acq;

import javafx.stage.Stage;

public interface IGUI {

    void injectLogic(ILogic logic);

    void start(Stage mainStage) throws Exception;

    public void start();
    
    
    //Access to logic methods:
    void save();
    void load();
    double getMoney();
    int getExp();
    int getEnh();
    int getMoves();
    int getDaysLeft();
    public String getCurrentRoom();
    
    
}
