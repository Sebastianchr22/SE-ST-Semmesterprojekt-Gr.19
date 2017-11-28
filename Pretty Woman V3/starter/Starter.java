package starter;

import acq.IData;
import acq.ILogic;
import data.DataFacade;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.LogicFacade;
import presentation.PresentationFacade;
import acq.IGUI;
import logic.Game;

public class Starter extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        IData data = new DataFacade();
        ILogic logic = new LogicFacade();
        IGUI ui = new PresentationFacade();
        
        
        logic.setCurrentRoom("HOME");
        logic.injectData(data);
        ui.injectLogic(logic);
        ui.start();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
