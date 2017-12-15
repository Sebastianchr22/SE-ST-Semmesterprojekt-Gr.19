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

    /**
     * Resets the regular in the room, by calling methods on the logic facade,
     * which holds the regular. The regular is set to null, and his invite set
     * to null, along with the privateRoomCommand. Also a string is returned as
     * feedback that a regular left the club.
     *
     * @return feedback : String
     */
    public String resetRegularInRoom() {
        String s = logic.getRegularInRoom().getName() + " left the club.";
        regularInRoom = null;
        logic.setRegularInRoom(null);
        logic.setPRoomInvite(false);
        logic.setPrivateRoomCommand(null);
        return s;
    }

    /**
     * This is used to sort the privateRoomInvite, if a player dances or rejects
     * the invitation. If the player has not yet choosen a command, this method
     * will return a string promting the player to choose. If the invitation is
     * accepted, the player will have the option to dance, which is a valid
     * command. If dance is called a new object of the privateroom type is
     * initialized, and the privateroom method called, to take
     *
     * @param command
     * @return
     */
    public String PrivateRoomInvite(String command) {
        String val = "";
        if (command == null) {
            val += "You have been invited to private room by " + regularInRoom.getName();
            val += "Do you accept the invitation?";
        }
        System.out.println("Command: " + command);
        if (command.equals("DANCE")) {
            PrivateRoom proom = new PrivateRoom();
            val += proom.PrivateRoom();
        } else if (command.equals("REJECT")) {
            val += resetRegularInRoom();
        }
        System.out.println(val);
        return val;
    }

    /**
     * This method will get a reference to the logicFacade, and the player
     * reference, along with the regular in room, if any.
     * <p>
     * By 35% chance a regular might appear, if no regular is in the room. This
     * sets the regularInRoom variable to the randomly found regular the regular
     * is found through calling getRandomRegular on the logicFacade.
     *
     * <p>
     * If a regular is in the room, there will be 25% chance of being invited to
     * privateRoom.
     *
     * <p>
     * if nothing else, and if a regular is in the room, this will let the
     * player know, that someone is there.
     *
     * @return feedback : String
     */
    public String DanceMech() {
        String val = "";
        logic = LogicFacade.getInstance();
        this.player = logic.getPlayer();
        this.regularInRoom = logic.getRegularInRoom();
        if (logic.getWon() != true) {
            if (chance.ChanceCalc(35, 100) && regularInRoom == null) {
                //Regular appears in the club:
                regularInRoom = logic.getRandomRegular();
                logic.setRegularInRoom(regularInRoom);
                //Prompt accept private room invite:
                val = regularInRoom.getName() + " just appeared. Press info to learn more.";
            }
            if (regularInRoom != null) {
                //Someone in here:
                //Chance of invite to private room:
                if (chance.ChanceCalc(25, 100)) {
                    logic.setPRoomInvite(true);
                }
            }
            if (regularInRoom != null && logic.inPRoom() != true) {
                val = "You recognize a regular in the room";
            }
        }
        logic.setPlayer(player);
        return val;
    }

    /**
     * This method is used to calculate a percentage bonus, and a given tip, the
     * player has gotten from dancing.
     *
     * <p>
     * This done by first calculating the bonus percentage, this includes the
     * players enhancements * 0.05, this equals a given percentage, then 1.0 is
     * added, to be a positive percentage for later use.
     *
     * <p>
     * The tip is found by finding a random number between 5 and 30.0.
     *
     * <p>
     * To the tip is added the tip * the bonus found. And eventually * the bonus
     * again. This is rounded to one decimal.
     *
     * @param bonus
     * @return
     */
    public double tipsGained(double bonus) {
        double percentageBonusTip = 1 + logic.getEnhencements() * 0.05;//Calculates a percentage of bonus based on improvements
        double tips = 5.0 + Math.random() * 30.0;//Calculates a random number between 5 to 30
        return Math.round((tips + (percentageBonusTip * tips) * bonus) * 100.0) / 100.0; //Returns the random* the percentage, rounded off with two digits after the comma.
    }

    /**
     * Calculates an a bonus to the players tips, from the players experience.
     * This is done as a percentage, as 5 exp, would be equal to 0.05% bonus *
     * 3, so a 0.15% bonus to the tips.
     *
     * @param required
     * @return
     */
    public double exptips(int required) {
        return (logic.getExperience() / 100.0) * 3;
    }

    /**
     * This method is used as feedback to the player regarding the move that the
     * player performed.
     *
     * <p>
     * By 85% chance the players move is successful, and this method will let
     * them know. 1 Experience is added, and tips are calculated using
     * tipsGained(), and adding it to the players moneySaved variable on the
     * LogicFacade.
     *
     * @return feedback : String
     */
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
