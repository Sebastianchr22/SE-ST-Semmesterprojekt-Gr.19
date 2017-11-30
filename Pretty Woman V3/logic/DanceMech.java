package logic;

import acq.ILogic;
import acq.IRegular;

public class DanceMech {

    private ILogic logic = LogicFacade.getInstance();
    private Player player;
    private IRegular regularInRoom;

    int move1ExpRequired = 0;
    int move2ExpRequired = 25;
    Chance chance = new Chance();

    public void printPrompt() {
        //Main interface printout:
        System.out.println("The crowd looks to have some money to spend on a good show.");
        System.out.println("You know the following moves:");
        System.out.println("Basic");
        System.out.println("Advanced");
    }

    public String infoOnRegular() {
        if (regularInRoom != null) {
            return regularInRoom.info();
        } else {
            return "There is no regular in here.";
        }
    }

    public void resetRegularInRoom() {
        System.out.println(regularInRoom.getName() + " left the club.");
        regularInRoom = null;
        logic.setRegularInRoom(null);
    }

    public String PrivateRoomInvite(String command) {
        String val = "";
        if (logic.getInPRoom() != true) {
            val += "You have been invited to private room by " + regularInRoom.getName();
            val += "Do you accept the invitation?";
        } else {
            if (command.equals("ACCEPT")) {
                PrivateRoom proom = new PrivateRoom(regularInRoom);
            } else if (command.equals("REJECT")) {
                val += regularInRoom.getName() + " left the club.";
                resetRegularInRoom();
            }
        }
        System.out.println(val);
        return val;
    }

    DanceMech() {
        printPrompt();
        logic = LogicFacade.getInstance();
        this.player = logic.getPlayer();
        this.regularInRoom = logic.getRegularInRoom();
        if (logic.getWon() != true) {
            if (chance.ChanceCalc(35, 100) && regularInRoom == null) {
                //Regular appears in the club:
                regularInRoom = logic.getRandomRegular();
                logic.setRegularInRoom(regularInRoom);
                //Prompt accept private room invite:
                System.out.println(regularInRoom.getName() + " just appeared. Type info to learn more.");
            }
            if (regularInRoom != null) {
                //Someone in here:
                //Chance of invite to private room:
                if (chance.ChanceCalc(25, 100)) {
                    logic.setPRoomInvite(true);
                }
            }
            if (regularInRoom != null && logic.inPRoom() != true) {
                System.out.println("You recognize a regular in the room");
            }
        }
        logic.removeMoves(1);
        logic.setPlayer(player);

    }

    public double tipsGained(double bonus) {
        double percentageBonusTip = 1 + logic.getEnhencements() * 0.05;//Calculates a percentage of bonus based on improvements
        double tips = 5.0 + Math.random() * 30.0;//Calculates a random number between 5 to 30
        return Math.round((percentageBonusTip * tips + bonus) * 100.0) / 100.0; //Returns the random* the percentage, rounded off with two digits after the comma.
    }

    //PrivateRoom proom = new PrivateRoom(driver, driver.reg.Sebastian);
    //System.out.println(driver.reg.Sebastian.info());
    public double exptips(int required) {
        return (logic.getExperience() / 1000.0) * 3;
    }

    public String danceMovePrint() {
        String s = "";
        if (chance.ChanceCalc(85, 100)) {
            //You have enough experience to perform this move:
            s += "Your move was successful." + "\n";
            logic.addExperience(1);
            double tipsFromMove = tipsGained(exptips(logic.getExperience()));
            s += "You received $" + tipsFromMove + " in tips for that move.";
            logic.addMoney(tipsFromMove);
        }
        return s;
    }
}
