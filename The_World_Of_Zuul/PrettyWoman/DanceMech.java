package PrettyWoman;

import java.util.*;

public class DanceMech {

    int move1ExpRequired = 0;
    int move2ExpRequired = 25;
    Chance chance = new Chance();

    /**
     * Prints the money and experience gained by the player:
     *
     * @return nothing.
     */
    public void printInterface(PlayerStats playerStats) {
        System.out.println("$" + Math.round((playerStats.getMoneySaved()) * 100.0) / 100.0 + "      " + "Exp: " + playerStats.getExperience());//Prints the saved money rounded off to two digits.
    }

    public void printPrompt() {
        //Main interface printout:
        System.out.println("The crowd looks to have some money to spend on a good show.");
        System.out.println("You know the following moves:");
        System.out.println("Basic");
        System.out.println("Advanced");
    }

    public String infoOnRegular(Driver driver) {
        if (driver.regularInRoom != null) {
            return driver.regularInRoom.info();
        } else {
            return "There is no regular in here.";
        }
    }

    public void resetRegularInRoom(Driver driver) {
        System.out.println(driver.regularInRoom.getName() + " left the club.");
        driver.regularInRoom = null;
    }

    public void PrivateRoomInvite(Driver driver, Regular regular, Command command, boolean accepted) {
        if (accepted != true) {
            System.out.println("You have been invited to private room by " + driver.regularInRoom.getName());
            System.out.println("Do you accept the invitation?");
        } else {
            if (command.getCommandWord() == CommandWord.ACCEPT || command.getCommandWord() == CommandWord.YES) {
                PrivateRoom proom = new PrivateRoom(driver, regular);
            } else if (command.getCommandWord() != CommandWord.INFO) {
                System.out.println(driver.regularInRoom.getName() + " left the club.");
                resetRegularInRoom(driver);
            }
        }
    }

    DanceMech() {
        printPrompt();
    }

    DanceMech(Driver driver, Command command) {

        if (chance.ChanceCalc(35, 100) && driver.regularInRoom == null) {
            //Regular appears in the club:
            driver.regularInRoom = driver.reglist.getRandomRegular();
            //Prompt accept private room invite:
            System.out.println("A regular just appeared. Type info to learn more.");     
        }if(driver.regularInRoom != null){
            //Someone in here:
            //Chance of invite to private room:
            if(chance.ChanceCalc(25, 100)){
                PrivateRoomInvite(driver, driver.regularInRoom, command, false);
            }
        }

        //Input prompt:
        if (command.hasSecondWord()) {
            if (driver.regularInRoom != null) {
                System.out.println("There is a regular in here.");
            }
            danceMoveYield(command.getSecondWord(), driver);

        } else {
            if (command.getCommandWord() == CommandWord.INFO) {
                System.out.println(infoOnRegular(driver));
            }
            if (command.getCommandWord() == CommandWord.ACCEPT || command.getCommandWord() == CommandWord.YES) {
                PrivateRoomInvite(driver, driver.regularInRoom, command, true);
            }
            if (command.getCommandWord() == CommandWord.REJECT || command.getCommandWord() == CommandWord.NO) {
                if (driver.regularInRoom != null) {
                    resetRegularInRoom(driver);
                }else{
                    System.out.println("There are no regulars to reject.");
                }
            } else {
                System.out.println("Please choose a specific dance to perform");
            }
        }
    }

    public double tipsGained(double bonus, Driver driver) {
        double percentageBonusTip = 1 + driver.playerStats.getEnhancements() * 0.05;//Calculates a percentage of bonus based on improvements
        double tips = 5.0 + Math.random() * 30.0;//Calculates a random number between 5 to 30
        return Math.round((percentageBonusTip * tips + bonus) * 100.0) / 100.0; //Returns the random* the percentage, rounded off with two digits after the comma.
    }

    public void danceMoveYield(String danceMoveChoosen, Driver driver) {
        switch (danceMoveChoosen.toUpperCase()) {
            case "BASIC":
                danceMovePrint(move1ExpRequired, driver);//Calls the method below to print success or failure.
                break;
            case "ADVANCED":
                danceMovePrint(move2ExpRequired, driver);
                break;
            default:
                break;
        }

        //PrivateRoom proom = new PrivateRoom(driver, driver.reg.Sebastian);
        //System.out.println(driver.reg.Sebastian.info());
    }

    public int exptips(Driver driver, int required) {
        if (required > driver.playerStats.getExperience()) {
            return 0;
        } else {
            return (driver.playerStats.getExperience() - required) * 3;
        }
    }

    public void danceMovePrint(int danceMoveExpRequired, Driver driver) {
        if (driver.playerStats.getExperience() >= danceMoveExpRequired) {
            //You have enough experience to perform this move:
            System.out.println("Your move was successful.");
            driver.playerStats.addExperience(1);
            double tipsFromMove = tipsGained(exptips(driver, danceMoveExpRequired), driver);
            System.out.println("You received $" + tipsFromMove + " in tips for that move.");
            driver.playerStats.addMoneySaved(tipsFromMove);
        } else {
            //You do not have enough experience to perform this move:
            if (chance.ChanceCalc(25, 100)) {
                //It was successful:
                System.out.println("Although you are not experienced with that move, you were successful.");
                driver.playerStats.addExperience(1);
                double tipsFromMove = tipsGained(exptips(driver, danceMoveExpRequired) + 25, driver);
                System.out.println("You received $" + tipsFromMove + " in tips for that move.");
                driver.playerStats.addMoneySaved(tipsFromMove);

            } else {
                //You failed:
                System.out.println("Your lack of experience clearly shows and the crowd are not happy.");
            }
        }
    }
}
