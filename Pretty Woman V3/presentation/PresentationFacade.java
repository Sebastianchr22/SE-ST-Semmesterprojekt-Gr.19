package presentation;

import acq.ILogic;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import acq.IGUI;
import acq.IItem;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public class PresentationFacade implements IGUI {

    private ILogic logic;
    private static IGUI IGUI;
    private Stage mainStage = new Stage();

    @Override
    public void injectLogic(ILogic logic) {
        this.logic = logic;
    }

    public static IGUI getInstance() {
        return IGUI;
    }

    private Scene scene;

    public Scene getScene() {
        return scene;
    }
    
    @Override
    public boolean getGameWon(){
        return logic.getWon();
    }

    @Override
    public void start(Stage mainStage) throws Exception {
        IGUI = this;
        Parent root = FXMLLoader.load(getClass().getResource("StartScreenFXML.fxml"));

        scene = new Scene(root);

        setStage(mainStage);
    }

    public void setStage(Stage stage) {
        mainStage.setMinHeight(600);
        mainStage.setMinWidth(800);
        mainStage.setHeight(600);
        mainStage.setWidth(800);
        mainStage.setResizable(false);
        mainStage.setScene(scene);
        mainStage.show();

        Image icon = new Image(getClass().getResourceAsStream("../FXML/Visuals/Icons/Icon.png"));
        mainStage.setTitle("Pretty Woman - The Game");

        mainStage.getIcons().add(icon);
    }

    private Parent root;

    @Override
    public void newGame(MouseEvent event) {
        try {
            /*Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            scene = new Scene(root);
            setStage(mainStage);*/

            Parent blah = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.close();
            appStage.show();
            logic.resetGame();
        } catch (IOException ex) {
            System.out.println("Error loading");
            Logger.getLogger(PresentationFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        logic.setWon(false);

    }

    @Override
    public void mainMenu(MouseEvent event) {
        try {
            /*Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            scene = new Scene(root);
            setStage(mainStage);*/

            Parent blah = FXMLLoader.load(getClass().getResource("StartScreenFXML.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.close();
            appStage.show();
            logic.resetGame();
        } catch (IOException ex) {
            System.out.println("Error loading");
            Logger.getLogger(PresentationFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        logic.setWon(false);

    }

    @Override
    public void loadGame(MouseEvent event) {
        newGame(event);
        logic.load();
    }

    @Override
    public void start() {
        try {
            start(mainStage);
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("Something went wrong in Initialize");
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
    public ObservableList loadHighScores() {
        return logic.loadHighScore();
    }

    @Override
    public double getMoney() {
        return (logic.getMoneySave() * 100.0) / 100.0;
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

    @Override
    public String getCapacity() {
        return logic.getCapacity();
    }

    @Override
    public int getHunger() {
        return logic.getCurrentHunger();
    }

    @Override
    public String getShortHunger() {
        return logic.getShortHunger();
    }

    @Override
    public String buyFood() {
        return logic.buyFood();
    }

    @Override
    public String buyEnh() {
        return logic.buyEnhancements();
    }

    @Override
    public ObservableList<IItem> getInventory() {
        return this.logic.getInventoryList();
    }

    @Override
    public void removeItem(IItem item) {
        logic.dropItem(item);
    }

    @Override
    public String processCommand(String command) {
        return logic.processCommand(command);
    }

    @Override
    public void setPrivateRoomCommand(String s) {
        logic.setPrivateRoomCommand(s);
    }

    @Override
    public String getRegularInRoomInfo() {
        return logic.getRegularInRoom().info();
    }

    public boolean managerPlayerSameRoom() {
        return logic.managerPlayerSameRoom();
    }

    public String managerTakesCut() {
        return logic.managerTakesCut();
    }

    public String getRoomDescription() {
        return logic.getRoomDescription();
    }

    public boolean getPRoomInvite() {
        return logic.getPRoomInvite();
    }

    public void removeDaysLeft() {
        logic.removeDaysLeft();
    }

    public String getRoomHelpText() {
        return logic.getRoomHelpText();
    }
}
