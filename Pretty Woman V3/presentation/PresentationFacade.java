package presentation;

import acq.ILogic;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import acq.IGUI;

public class PresentationFacade implements IGUI {

    private ILogic logic;
    private Stage mainStage = new Stage();

    @Override
    public void injectLogic(ILogic logic) {
        this.logic = logic;
    }

    @Override
    public void start(Stage mainStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Image icon = new Image(getClass().getResourceAsStream("../FXML/Visuals/Icons/Icon.png"));
        mainStage.setTitle("Pretty Woman - The Game");

        mainStage.getIcons().add(icon);

        Scene scene = new Scene(root);

        mainStage.setMinHeight(600);
        mainStage.setMinWidth(800);
        mainStage.setHeight(600);
        mainStage.setWidth(800);
        mainStage.setResizable(false);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @Override
    public void start() {
        try {
            System.out.println(getCurrentRoom());
            System.out.println(getExp());
            System.out.println(getMoney());
            System.out.println(getDaysLeft());
            System.out.println("tester start() ");
            String path = "../FXML/Visuals/Highres/Map/" + getCurrentRoom() + ".png";
            System.out.println(path);
            start(mainStage);
        } catch (Exception ex) {
            String path = "../FXML/Visuals/Highres/Map/" + getCurrentRoom() + ".png";
            System.out.println("path: " + path);
            System.out.println("Didnt work.. lol");
        }
    }

    @Override
    public void save() {
        logic.save();
    }

    @Override
    public void load() {
        logic.load();
    }

    @Override
    public double getMoney() {
        return logic.getMoneySave();
    }

    @Override
    public int getExp() {
        return logic.getExperience();
    }

    @Override
    public int getEnh() {
        return logic.getEnhencements();
    }

    @Override
    public int getMoves() {
        return logic.getMoves();
    }

    @Override
    public int getDaysLeft() {
        return logic.getDaysLeft();
    }

    @Override
    public String getCurrentRoom() {
        return logic.getCurrentRoom();
    }

}
