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
     * 
     * @return 
     */
    public Regular getRandomRegular() {
        int lenght = countRegulars();
        int random = (int) Math.round(0 + Math.random() * lenght--);
        return getRegularAtIndex(random);

    }

    public double winDegree(IRegular regular) {
        //Returns the index of the regular, on sorted/ un-sorted list:
        //List is sorted by most wealthy at index 0:
        sortByWealth();
        double Index = regularList.indexOf(regular);
        double WinPercent = ((countRegulars() - Index++) / countRegulars()) * 100.0;
        if (regular.getName().equals("Ex-boyfriend Daniel") || regular.getName().toUpperCase().equals("JACK THE BOUNCER")) {
            return 100.0;
        } else {
            return WinPercent;
        }
    }

    public void showList() {
        for (Regular regular : regularList) {
            System.out.println(regular.info());
        }
    }

}