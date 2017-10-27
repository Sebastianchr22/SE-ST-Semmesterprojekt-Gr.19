package PrettyWoman;

import java.util.*;

public class DanceMech
{

    public int move1ExpRequired = 0;
    public int move2ExpRequired = 25;
    Chance chance = new Chance();
    

    /**
     * Prints the money and experience gained by the player:
     *
     * @return nothing.
     */
    public void printInterface(PlayerStats playerStats)
    {
        System.out.println("$" + Math.round((playerStats.getMoneySaved()) * 100.0) / 100.0 + "      " + "Exp: " + playerStats.getExperience());//Prints the saved money rounded off to two digits.
    }



    DanceMech(Driver driver)
    {
        boolean RegularInRoom;


        int om = 1;
        do
        {

            printInterface(driver.playerStats);
            //Basic test values set:
            String mainFloorChoice;

            Scanner mainFloorInput = new Scanner(System.in);//Scanner created

            //Main interface printout:
            System.out.println("You are at the dance floor:");
            System.out.println("The crowd looks to have some money to spend on a good show.");
            System.out.println("1.  Dance");
            System.out.println("2. Perform move");
            System.out.println("3. Private room dance");

            //Spacing:
            System.out.println("");
            System.out.println("");

            //Input prompt:
            System.out.print("> ");
            mainFloorChoice = mainFloorInput.next();
            danceMoveYield(mainFloorChoice,driver);
        }
        while (om == 1);
    }

    public double tipsGained(double bonus, Driver driver)
    {
        double percentageBonusTip = 1 + driver.playerStats.getEnhancements() * 0.05;//Calculates a percentage of bonus based on improvements
        double tips = 5.0 + Math.random() * 30.0;//Calculates a random number between 5 to 30
        return Math.round((percentageBonusTip * tips + bonus) * 100.0) / 100.0; //Returns the random* the percentage, rounded off with two digits after the comma.
    }

    public void danceMoveYield(String danceMoveChoosen, Driver driver)
    {
        PrivateRoom pRoom = new PrivateRoom();
        if (danceMoveChoosen.equals("1"))
        {
            danceMovePrint(move1ExpRequired, driver);//Calls the method below to print success or failure.
        }
        if (danceMoveChoosen.equals("2"))
        {
            //Insert from move 1:
            danceMovePrint(move2ExpRequired, driver);
        }
        if (danceMoveChoosen.equals("3"))
        {
            pRoom.privateRoomInvite(driver, driver.reg.Sebastian);
            System.out.println(driver.reg.Sebastian.info());
        }
        if (danceMoveChoosen.equals("map"))
        {
            driver.playerStats.printMap("Floor");
        }
        else
        {
            //Unknown dancemove
        }
    }

    public int exptips(Driver driver, int required)
    {
        if (required > driver.playerStats.getExperience())
        {
            return 0;
        }
        else
        {
            return (driver.playerStats.getExperience() - required) * 3;
        }
    }

    public void danceMovePrint(int danceMoveExpRequired, Driver driver)
    {
        if (driver.playerStats.getExperience() >= danceMoveExpRequired)
        {
            //You have enough experience to perform this move:
            System.out.println("Your move was successful.");
            driver.playerStats.addExperience(1);
            double tipsFromMove = tipsGained(exptips(driver, danceMoveExpRequired), driver);
            System.out.println("You received $" + tipsFromMove + " in tips for that move.");
            driver.playerStats.addMoneySaved(tipsFromMove);
        }
        else
        {
            //You do not have enough experience to perform this move:
            if (chance.ChanceCalc(25, 100))
            {
                //It was successful:
                System.out.println("Although you are not experienced with that move, you were successful.");
                driver.playerStats.addExperience(1);
                double tipsFromMove = tipsGained(exptips(driver, danceMoveExpRequired), driver);
                System.out.println("You received $" + tipsFromMove + " in tips for that move.");
                driver.playerStats.addMoneySaved(tipsFromMove);

            }
            else
            {
                //You failed:
                System.out.println("Your lack of experience clearly shows and the crowd are not happy.");
            }
        }
    }
}
