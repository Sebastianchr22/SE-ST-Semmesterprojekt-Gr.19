package logic;

import acq.ILogic;

public class DanceMech {
    
    private ILogic logic;
    private Player player;
    private ListOfRegulars reglist;
    private Regular regularInRoom;
    
    int move1ExpRequired = 0;
    int move2ExpRequired = 25;
    Chance chance = new Chance();

    /**
     * Prints the money and experience gained by the player:
     *
     * @return nothing.
     */

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
    }

    public void PrivateRoomInvite(Regular regular, Command command, boolean accepted) {
        if (accepted != true) {
            System.out.println("You have been invited to private room by " + regularInRoom.getName());
            System.out.println("Do you accept the invitation?");
        } else {
            if (command.getCommandWord() == CommandWord.ACCEPT || command.getCommandWord() == CommandWord.YES) {
                PrivateRoom proom = new PrivateRoom(regular);
            } else if (command.getCommandWord() == CommandWord.NO || command.getCommandWord() == CommandWord.REJECT) {
                System.out.println(regularInRoom.getName() + " left the club.");
                resetRegularInRoom();
            }
        }
    }

    DanceMech() {
        printPrompt();
        this.player = logic.getPlayer();
        this.reglist.regularList = logic.getRegularList();
        this.regularInRoom = logic.getRegularInRoom();
    }

    DanceMech(Command command) {
        if (logic.getWon() != true) {
            if (chance.ChanceCalc(35, 100) && regularInRoom == null) {
                //Regular appears in the club:
                regularInRoom = reglist.getRandomRegular();
                //Prompt accept private room invite:
                System.out.println("A regular just appeared. Type info to learn more.");
            }
            if (regularInRoom != null) {
                //Someone in here:
                //Chance of invite to private room:
                if (chance.ChanceCalc(25, 100)) {
                    PrivateRoomInvite(regularInRoom, command, false);
                }
            }
            if (regularInRoom != null && logic.inPRoom() != true) {
                System.out.println("You recognize a regular in the room");
            }
        }

        //Input prompt:
        if (command.hasSecondWord()) {

            danceMoveYield(command.getSecondWord());

        } else {
            if (command.getCommandWord() == CommandWord.INFO) {
                System.out.println(infoOnRegular());
            } else if (command.getCommandWord() == CommandWord.ACCEPT || command.getCommandWord() == CommandWord.YES) {
                PrivateRoomInvite(regularInRoom, command, true);
                resetRegularInRoom();
            } else if (command.getCommandWord() == CommandWord.REJECT || command.getCommandWord() == CommandWord.NO) {
                if (regularInRoom != null) {
                    resetRegularInRoom();
                } else {
                    System.out.println("There are no regulars to reject.");
                }
            } else {
                player.addMoves(1);
                System.out.println("Please choose a specific dance to perform");
            }
        }
        logic.setPlayer(player);
    }

    public double tipsGained(double bonus) {
        double percentageBonusTip = 1 + player.getEnhancements() * 0.05;//Calculates a percentage of bonus based on improvements
        double tips = 5.0 + Math.random() * 30.0;//Calculates a random number between 5 to 30
        return Math.round((percentageBonusTip * tips + bonus) * 100.0) / 100.0; //Returns the random* the percentage, rounded off with two digits after the comma.
    }

    public void danceMoveYield(String danceMoveChoosen) {
        switch (danceMoveChoosen.toUpperCase()) {
            case "BASIC":
                danceMovePrint(move1ExpRequired);//Calls the method below to print success or failure.
                break;
            case "ADVANCED":
                danceMovePrint(move2ExpRequired);
                break;
            default:
                player.addMoves(1);
                break;
        }

        //PrivateRoom proom = new PrivateRoom(driver, driver.reg.Sebastian);
        //System.out.println(driver.reg.Sebastian.info());
    }

    public int exptips(int required) {
        if (required > player.getExperience()) {
            return 0;
        } else {
            return (player.getExperience() - required) * 3;
        }
    }

    public void danceMovePrint(int danceMoveExpRequired) {
        if (player.getExperience() >= danceMoveExpRequired) {
            //You have enough experience to perform this move:
            System.out.println("Your move was successful.");
            player.addExperience(1);
            double tipsFromMove = tipsGained(exptips(danceMoveExpRequired));
            System.out.println("You received $" + tipsFromMove + " in tips for that move.");
            player.addMoney(tipsFromMove);
        } else {
            //You do not have enough experience to perform this move:
            if (chance.ChanceCalc(25, 100)) {
                //It was successful:
                System.out.println("Although you are not experienced with that move, you were successful.");
                player.addExperience(1);
                double tipsFromMove = tipsGained(exptips(danceMoveExpRequired) + 25);
                System.out.println("You received $" + tipsFromMove + " in tips for that move.");
                player.addMoney(tipsFromMove);

            } else {
                //You failed:
                System.out.println("Your lack of experience clearly shows and the crowd are not happy.");
            }
        }
    }
}
