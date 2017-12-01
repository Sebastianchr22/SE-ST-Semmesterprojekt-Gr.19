package presentation;

import acq.ILogic;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import acq.IGUI;
import acq.IItem;
import javafx.collections.ObservableList;

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
    public void start(Stage mainStage) throws Exception {
        IGUI = this;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Image icon = new Image(getClass().getResourceAsStream("../FXML/Visuals/Icons/Icon.png"));
        mainStage.setTitle("Pretty Woman - The Game");

        mainStage.getIcons().add(icon);

        scene = new Scene(root);

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
    public void buyFood() {
        logic.buyFood();
    }

    @Override
    public void buyEnh() {
        logic.buyEnhancements();
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

    public void removeDaysLeft(){
        logic.removeDaysLeft();
    }
    
    public String getRoomHelpText(){
        return logic.getRoomHelpText();
    }
}
