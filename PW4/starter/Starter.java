package starter;

import acq.IData;
import acq.ILogic;
import acq.IGUI;
import data.DataFacade;
import logic.LogicFacade;
import presentation.PresentationFacade;
import javafx.application.Application;
import javafx.stage.Stage;

public class Starter extends Application {

    /**
     * Creates objects of the IData, ILogic, and IGUI types.
     * Injects the data reference, into the logic facade.
     * Injects the Logic reference, into the presentation facade.
     * Calls the start method on the presentation Facade.
     * @param primaryStage 
     */
    @Override
    public void start(Stage primaryStage) {
        IData data = new DataFacade();
        ILogic logic = new LogicFacade();
        IGUI ui = new PresentationFacade();

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
