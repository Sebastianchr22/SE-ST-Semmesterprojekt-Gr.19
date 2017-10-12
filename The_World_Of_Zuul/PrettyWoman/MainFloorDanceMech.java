package PrettyWoman;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebas
 */

import java.util.*;


public class MainFloorDanceMech {
    public int move1ExpRequired = 11;
    public int move2ExpRequired = 25;
    PlayerStats playerStats = new PlayerStats();
    Chance chanceClac = new Chance();

    /**
     * Prints the money and experience gained by the player:
     * @return nothing.
     */
    public void printInterface(){     
        System.out.println("Money: " + Math.round((playerStats.getMoneySaved())*100.0)/100.0 + "      " + "Exp: " + playerStats.getExperience());//Prints the saved money rounded off to two digits.

    }
    
    
    public static void main(String[] args) {
        MainFloorDanceMech gameplay = new MainFloorDanceMech();
        int om = 1;
        do {
            gameplay.printInterface();
            //Basic test values set:
            String mainFloorChoice;

            Scanner mainFloorInput = new Scanner(System.in);//Scanner created

            //Main interface printout:
            
            System.out.println("You are at the dance floor:");
            System.out.println("The crowd looks to have some money to spend on a good show.");
            System.out.println("1.  Dance");
            System.out.println("2. Perform move");

            //Spacing:
            System.out.println("");
            System.out.println("");

            //Input prompt:
            System.out.print("> ");
            mainFloorChoice = mainFloorInput.next();
            gameplay.danceMoveYield(mainFloorChoice);
        } while (om == 1);
    }

  

    
    /**
     * Takes experience and improvements to calculate an amout of tips, and add a percentage as a bonus based on your amount
     * of improvements.
     * @param Experience is taken from earlier
     * @param Improvements is taken from earlier
     * @return returns the amount of money gained as tips.
     */
    public double tipsGained(int Improvements) {
        double percentageBonusTip = 1+Improvements*0.05;//Calculates a percentage of bonus based on improvements
        double tips = 5.0+Math.random()*30.0;//Calculates a random number between 5 to 30
        return Math.round((percentageBonusTip*tips)*100.0)/100.0; //Returns the random* the percentage, rounded off with two digits after the comma.
    }

    
    /**
     * 
     * @param danceMoveChoosen is given by the main floor choice
     * @param Experience is based on the amount of moves the player has performed.
     * @return 
     */
    public void danceMoveYield(String danceMoveChoosen) {
        if (danceMoveChoosen.equals("1")) {
            danceMovePrint(playerStats.getExperience(), move1ExpRequired);//Calls the method below to print success or failure.
        }
        if (danceMoveChoosen.equals("2")) {
            //Insert from move 1:
            danceMovePrint(playerStats.getExperience(), move2ExpRequired);// --||--
        } else {
            //Unknown dancemove
        }
    }
    
    
    /**
     * this method is called to display the success or failure of a dance move by the player, based on the players experience.
     * also it displays the amount of tips gained from the move. this is done by calling the function tipsFromMove();. 
     * And also calling the ChanceCalc method from earlier.
     * @param experience given from player experience int
     * @param danceMoveExpRequired given from move requirements
     * @return does not matter
     */
    public void danceMovePrint(int experience, int danceMoveExpRequired){
        if (experience >= danceMoveExpRequired) {
            //You have enough experience to perform this move:
            System.out.println("Your move was successful.");
            playerStats.addExperience(1);
            double tipsFromMove = tipsGained(playerStats.getPersonalImprovements());
            System.out.println("You received $" + tipsFromMove + " in tips for that move.");
            playerStats.addMoneySaved(tipsFromMove);
        } else {
            //You do not have enough experience to perform this move:
            if (chanceClac.ChanceCalc(25, 100)) {
                //It was successful:
                System.out.println("Although you are not experienced with that move, you were successful.");
                playerStats.addExperience(1);
                double tipsFromMove = tipsGained(playerStats.getPersonalImprovements());
                System.out.println("You received $" + tipsFromMove + " in tips for that move.");
                playerStats.addMoneySaved(tipsFromMove);

            } else {
                //You failed:
                System.out.println("Your lack of experience clearly shows and the crowd are not happy.");
            }
        }
    }
}
class Chance{
    /**
     * Takes to numbers and finds a common divider, to figure out the chance of something happening.
     * this is done by first checking which number is larger.
     * then we find a common divider between the two, in int form.
     * we make sure that we are not dividing by 0.
     * @param num1
     * @param num2
     * @return true or false
     */
    public boolean ChanceCalc(int num1, int num2) {
        int divider = 1;

        if (num1 < num2) {
            //Number 1 is smaller than number 2:
            divider = num2 / num1;
        }
        if (num2 < num1) {
            //Number 2 is smaller than number 1:
            divider = num1 / num2;
        } else if (num1 == num2) {
            //Avoiding dividing by 0:
            num1 = 1;
            num2 = 1;
        }
        int random = (int) (1 + Math.random() * divider);
        if (random == divider) {
            //True:
            return true;
        } else {
            return false;
        }

    }

}
