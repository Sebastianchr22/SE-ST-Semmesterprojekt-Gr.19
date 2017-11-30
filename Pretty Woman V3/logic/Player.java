package logic;

import acq.ILogic;
import java.util.ArrayList;

public class Player {
    private static ILogic logic;
    
    private int Experience = 0;
    private int Enhancements = 0;
    private int Moves = 12;
    private double moneySaved = 0;
    private int currentHunger = 100;
    private int daysLeft = 20;

    private final Item weddingring = new Item(0, "Wedding Ring", "Your wedding ring given to you by your ex- boyfriend", "Wedding", 3);

    Player() {
        int Experience = 0;
        int Enhancements = 0;
        int Moves = 12;
        double moneySaved = 0;
        int currentHunger = 100;
        int daysLeft = 20;
    }

    Player(int exp, int enh, int moves, double money, int hunger, int days, ArrayList<String> list, ILogic logic) {
        this.Enhancements = enh;
        this.Experience = exp;
        this.moneySaved = money;
        this.Moves = moves;
        this.currentHunger = hunger;
        this.daysLeft = days;

        for (String val : list) {
            Item item = containsItem(val, logic.getItemList());
            if (!val.equals("Wedding Ring")) {
                logic.addToInventory(item);
                logic.removeFromItemList(item);
            } else {
                logic.addToInventory(weddingring);
            }
        }
    }
    Item getWeddingRing(){
        return this.weddingring;
    }
    void addEnhancements(int i) {
        this.Enhancements += i;
    }

    void addHunger(int i) {
        this.currentHunger += i;
    }

    void addDaysLeft(int i) {
        this.daysLeft += i;
    }

    void addExperience(int i) {
        this.Experience += i;
    }

    void addMoney(double i) {
        this.moneySaved += i;
    }

    void addMoves(int i) {
        this.Moves += i;
    }

    void removeMoney(double i) {
        this.moneySaved -= i;
    }

    void setExperience(int Experience) {
        this.Experience = Experience;
    }

    void setEnhancements(int Enhancements) {
        this.Enhancements = Enhancements;
    }

    void setMoves(int Moves) {
        this.Moves = Moves;
    }

    void setMoneySaved(double moneySaved) {
        this.moneySaved = moneySaved;
    }

    void setCurrentHunger(int currentHunger) {
        this.currentHunger = currentHunger;
    }

    void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    double getMoneySaved() {
        return this.moneySaved;
    }

    int getEnhancements() {
        return this.Enhancements;
    }

    int getExperience() {
        return this.Experience;
    }

    int getHunger() {
        return this.currentHunger;
    }

    int getDaysLeft() {
        return this.daysLeft;
    }

    int getMoves() {
        return this.Moves;
    }

    String getShortHunger() {
        return this.currentHunger + "/100";
    }

    void resetMoves() {
        this.Moves = 12;
    }

    void removeDaysLeft(int i) {
        this.daysLeft -= i;
    }

    void removeMoves(int i) {
        this.Moves -= i;
    }

    void removeHunger(int i) {
        this.currentHunger -= i;
    }

    public Item containsItem(String name, ArrayList<Item> itemlist) {
        for (Item item : itemlist) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public void printUI() {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("                      " + "           Hunger:");
        System.out.print("                      " + "----------------------------" + "     $ " + moneySaved + "                 " + "Days left: " + daysLeft + "\n" + "                      " + "|");
        for (int i = 0; i <= currentHunger / 4; i++) {
            System.out.print("/");
        }
        for (int j = 24 - currentHunger / 4; j >= 0; j--) {
            System.out.print(" ");
        }
        System.out.print("|" + "     Enhancements: " + Enhancements + "          " + "\n" + "                      " + "----------------------------" + "     Experience: " + Experience + "            " + "Moves: " + Moves + "\n");
    }

    public void printMap(String CurrentRoom) {
        String[] Map = new String[18];
        Map[0] = "         OFFICE    OUTSIDE                 / \\    ";
        Map[1] = "          -----     -----                 /   \\   ";
        Map[2] = "          |   |     |   |                /  o  \\  ";
        Map[3] = "          -----     -----               /       \\ ";
        Map[4] = "              |         |               ---------- ";
        Map[5] = "------      -----     -----             |        | ";
        Map[6] = "|    | ____ |   | ___ |   |             |  | |   | ";
        Map[7] = "------      -----     -----             |        | ";
        Map[8] = " HOME      B. ROOM    FLOOR             |        | ";
        Map[9] = "            /           |               |        | ";
        Map[10] = "        -----           |               |        | ";
        Map[11] = "        |   |          -----            |        | ";
        Map[12] = "        -----          |   |  - - - - > |        | ";
        Map[13] = "       LOCKER          -----            |        | ";
        Map[14] = "                      P. ROOM           |   _    | ";
        Map[15] = "                                        |  |'|   | ";
        Map[16] = "                                        ---------- ";
        Map[17] = "                                        PENTHOUSE  ";

        switch (CurrentRoom) {
            case "LOCKER ROOM":
                Map[11] = "        | X |          -----            |        | ";
                break;
            case "FRONT":
                Map[2] = "          |   |     | X |                /  o  \\  ";
                break;
            case "PRIVATE ROOM":
                Map[12] = "        -----          | X |  - - - - > |        | ";
                break;
            case "HOME":
                Map[6] = "| X  | ____ |   | ___ |   |             |  | |   | ";
                break;
            case "BACKROOM":
                Map[6] = "|    | ____ | X | ___ |   |             |  | |   | ";
                break;
            case "DANCE FLOOR":
                Map[6] = "|    | ____ |   | ___ | X |             |  | |   | ";
                break;
            case "OFFICE":
                Map[2] = "          | X |     |   |                /  o  \\  ";
                break;
            case "TOWER":
                Map[6] = "|    | ____ |   | ___ |   |             |  |X|   | ";
                break;
        }
        for (int i = 0; i <= 17; i++) {
            System.out.println(Map[i]);
        }
    }
}
