package Presentation;

import ACQ.IController;
import ACQ.ILogic;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Controller extends Application implements IController {

    private ILogic logic;

    public void injectLogic(ILogic logic) {
        this.logic = logic;
    }

    @Override
    public void start(Stage mainStage) throws Exception {
        
    }

    @Override
    public void startApplication(Stage mainStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        FXMLDocumentController controller = new FXMLDocumentController();

        Image icon = new Image(getClass().getResourceAsStream("Visuals/Icons/Icon.png"));
        mainStage.setTitle("Pretty Woman - The Game");

        mainStage.getIcons().add(icon);

        loader.setController(controller);
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root, 800, 600);

        mainStage.setMinHeight(600);
        mainStage.setMinWidth(800);
        mainStage.setHeight(600);
        mainStage.setWidth(800);
        mainStage.setResizable(false);
        mainStage.setScene(scene);
        mainStage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
    }
}
