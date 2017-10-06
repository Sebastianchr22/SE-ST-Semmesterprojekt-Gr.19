package PrettyWoman;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Abdi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sebas
 */
class PlayerStats {

    private int Experience = 77;
    private int personalImprovements = 5;
    private double moneySaved = 0;
    private int hunger = 50;

    PlayerStats() {
    }

    public double getMoneySaved() {
        return this.moneySaved;
    }

    public int getPersonalImprovements() {
        return this.personalImprovements;
    }

    public int getExperience() {
        return this.Experience;
    }

    public int addExperience(int value) {
        if (this.Experience - value > 0) {
            return this.Experience += value;     
        }else{
            return Experience;
        }
    }

    public double addMoneySaved(double value) {
        return this.moneySaved += value;
    }

    public int addPersonalImprovements(int value) {
        return this.personalImprovements += value;
    }

    public int addHunger(int value) {
        if (this.hunger + value <= 100) {
            return this.hunger += value;
        } else {
            System.out.println("Hunger is full.");
            return hunger;
        }

    }

    public int removeHunger(int value) {
        if (this.hunger - value > 0) {
            return this.hunger -= value;
        } else {
            System.out.println("Your daughter is starving...");
            return hunger;

        }
    }
    public int getHunger(){
        return this.hunger;
    }

    public String printMap(String CurrentRoom, String ManagerPossition) {
        String Map
                = "          -----     -----                   / \\   " + "\n"
                + "          |   |     |   |                 /    \\  " + "\n"
                + "          -----     -----               /       \\ " + "\n"
                + "              |         |               --------- " + "\n"
                + "------      -----     -----             |        | " + "\n"
                + "|    | ____ |   | ___ |   |             |        | " + "\n"
                + "------      -----     -----             |        | " + "\n"
                + "            /           |               |        | " + "\n"
                + "        -----           |               |        | " + "\n"
                + "        |   |          -----            |        | " + "\n"
                + "        -----          |   |  - - - - - |        | " + "\n"
                + "                       -----            |        | " + "\n"
                + "                                        |        | " + "\n"
                + "                                        |        | " + "\n"
                + "                                        ---------- " + "\n"
                + "                                                   " + "\n"
                + "                                                   ";

        return Map;
    }
}
