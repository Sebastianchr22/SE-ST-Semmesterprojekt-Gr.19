package Starter;

import ACQ.*;
import Data.*;
import Logic.*;
import Presentation.*;
import javafx.stage.*;
import static javafx.application.Application.launch;

public class Main {

    private Stage mainStage = new Stage();

    public void references() throws Exception {
        ILogic logic = new LogicFacade();
        IData data = new DataFacade();
        IController controller = new Controller();

        logic.injectData(data);
        controller.injectLogic(logic);
        
        controller.startApplication(mainStage);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
