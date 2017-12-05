package logic;

import acq.IRegular;
import java.util.*;
import java.util.Collections;

public class ListOfRegulars {

    private int numberofregulars = 0;
    ArrayList<Regular> regularList;

    /**
     * The list of regulars is uninitialized and so takes an ArrayList of regulars to initialize
     * @param reglist an ArrayList of Regulars.
     */
    ListOfRegulars(ArrayList<Regular> reglist) {
        this.regularList = reglist;
    }

    /**
     * This method will add a regular to the list (regularlist).
     * @param regular of the type Regular
     */
    public void addToList(Regular regular) {
        regularList.add(regular);
    }

    /**
     * This method is used to safely remove a regular from the list.
     * <p> this is done by first checking if the regularlist contains the given regular, if it does, then we call the .remove(regular). Otherwise there is
     * no need to remove the given regular.
     * @param regular 
     */
    public void removeFroList(Regular regular) {
        if (regularList.contains(regular)) {
            regularList.remove(regular);
        }
    }

    /**
     * This method will count and return the amount of regulars in the regularlist
     * <p>This is done by using a for-each loop. counting an integer ++ for each loop.
     * @return num the counted amount of regulars in the list.
     */
    public int countRegulars() {
        int num = 0;
        for (Regular regular : regularList) {
            num++;
        }
        return num--;
    }

    /**
     * This method overrides a method from the Comparator<T> interface, to compare regulars by wealth.
     * <p> This an example of using generics. We utilize the Comparator<Regular> interface to override the compare method, to compare the regular class's
     * .getWealth integer, to find the richest.
     * 
     * <p> This method gets called when the player has won the game, we then find which regular the player went with, and thereby find the index of the 
     * one choosen, and calculate a percentage of success, as the goal is to find the richest.
     */
    public void sortByWealth() {
        Collections.sort(regularList, new Comparator<Regular>() {
            @Override
            public int compare(Regular t, Regular t1) {
                return (int) t1.getWealth() - (int) t.getWealth();
            }
        });
    }

    /**
     * This method is used to find a regular at a specific index. This gets used when we want to find a random Regular and place him in the club.
     * 
     * <p> it is done by first checking if the desired regular index is less than the count of how many regulars we have, then we check if the list 
     * contains a regular at that spot, if not, we will step one index back and attempt to find a regular there. Either way, a regular is returned.
     * <p> if the index was larger than the count of regulars in the list, this method will return the regular at index 0.
     * @param index
     * @return 
     */
    public Regular getRegularAtIndex(int index) {
        if (index < countRegulars()) {
            if (regularList.contains(regularList.get(index))) {
                return regularList.get(index);
            } else {
                return regularList.get(index--);
            }
        } else {
            return regularList.get(0);
        }
    }

    /**
     * This method will generate a random number, and find the corresponding Regular at that index.
     * <p> this is done by first finding the lenght of the regularlist, then finding a random number between 0 and the lenght.
     * lastly it will return a call to getRegularAtIndex(random), using the found random number.
     * @return 
     */
    public Regular getRandomRegular() {
        int lenght = countRegulars();
        int random = (int) Math.round(0 + Math.random() * lenght--);
        return getRegularAtIndex(random);

    }

    /**
     * This method is used to calculate the percentage of success the player had in the mission to find the richest regular.
     * <p> this is done by first, sorting the list according to wealth, then finding the index of the regularlist on which the given Regular appears,
     * then using that it will calculate a percentage of success; by first taking the total regulars minus the index of the given regular, then divide that
     * by the total, and finally times 100.0. This is the overall success percentage the player earned.
     * in case the Regular was not one of the two (Ex-boyfriend, or the bouncer), the percentage will be returned, if the regular was one of those, 100.0
     * will be returned, as they are special characters in the game, and a complete success if the player matches with them.
     * @param regular using a given Regular to find out how rich he was compared to all other regulars.
     * @return winPercent or 100.0.
     */
    public double winDegree(IRegular regular) {
        sortByWealth();
        double Index = regularList.indexOf(regular);
        double WinPercent = ((countRegulars() - Index++) / countRegulars()) * 100.0;
        if (regular.getName().equals("Ex-boyfriend Daniel") || regular.getName().toUpperCase().equals("JACK THE BOUNCER")) {
            return 100.0;
        } else {
            return WinPercent;
        }
    }

}