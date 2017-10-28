package PrettyWoman;

import java.util.*;
import java.util.Collections;

public class ListOfRegulars {

    private int numberofregulars = 0;
    ArrayList<Regular> regularList;

    ListOfRegulars(ArrayList reglist) {
        this.regularList = reglist;
    }

    public void addToList(Regular regular) {
        regularList.add(regular);
    }

    public void removeFroList(Regular regular) {
        if (regularList.contains(regular)) {
            regularList.remove(regular);
        }
    }

    public void clearList() {
        regularList.clear();
    }

    public int countRegulars() {
        int num = 0;
        for (Regular regular : regularList) {
            num++;
        }
        return num--;
    }

    public void sortByWealth() {
        Collections.sort(regularList, new Comparator<Regular>() {

            @Override
            public int compare(Regular t, Regular t1) {
                return (int) t1.getWealth() - (int) t.getWealth();
            }
        });
        for (Regular regular : regularList) {//For debugging
            System.out.println(regular.getName() + " $" + regular.getWealth());
        }
    }

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

    public Regular getRandomRegular() {
        int lenght = countRegulars();
        int random = (int) Math.round(0 + Math.random() * lenght--);
        return getRegularAtIndex(random);

    }

    public double winDegree(Regular regular) {
        //Returns the index of the regular, on sorted/ un-sorted list:
        //List is sorted by most wealthy at index 0:
        sortByWealth();
        double Index = regularList.indexOf(regular);
        System.out.println("Index: " + Index); //Debug
        System.out.println("Regular matched with: " + regular.info());//Debug
        System.out.println("Total Regulars: " + countRegulars());//Debug
        double WinPercent = ((countRegulars() - Index++) / countRegulars()) * 100.0;
        System.out.println("Percentage: " + WinPercent); //Debug

        return WinPercent;
    }

    public void showList() {
        for (Regular regular : regularList) {
            System.out.println(regular.info());
        }
    }

}
