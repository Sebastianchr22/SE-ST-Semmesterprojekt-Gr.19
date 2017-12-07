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
