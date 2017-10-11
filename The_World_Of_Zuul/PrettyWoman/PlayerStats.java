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
class PlayerStats {
    private int Experience = 12;
    private int Enhancements = 5;
    private double moneySaved = 0;
    PlayerStats(){}
    public double getMoneySaved(){
        return this.moneySaved;
    }
    public int getEnhancements(){
        return this.Enhancements;
    }
    public int getExperience(){
        return this.Experience;
    }
    public int addExperience(int value){
        return this.Experience+=value;
    }
    public double addMoneySaved(double value){
        return this.moneySaved+=value;
    }
    public int addEnhancements(int value){
        return this.Enhancements+=value;
    }
    
    public void printMap(String CurrentRoom){
        String PlayerPosition = "";
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
        Map[10] ="        -----           |               |        | ";
        Map[11] ="        |   |          -----            |        | ";
        Map[12] ="        -----          |   |  - - - - > |        | ";
        Map[13] ="       LOCKER          -----            |        | ";
        Map[14] ="                      P. ROOM           |   _    | ";
        Map[15] ="                                        |  |'|   | ";
        Map[16] ="                                        ---------- ";
        Map[17] ="                                        PENTHOUSE  ";
        
        switch(CurrentRoom){
            case "LOCKER":
                Map[11] = "        | X |          -----            |        | ";
                break;
            case "OUTSIDE":
                Map[1] = "          |   |     | X |                /  o  \\  ";
                break;
            case "P. ROOM":
                Map[12] = "        -----          | X |  - - - - > |        | ";
                break;
            case "HOME":
                Map[6] = "| X  | ____ |   | ___ |   |             |  | |   | ";
                break;
            case "B. ROOM":
                Map[6] = "|    | ____ | X | ___ |   |             |  | |   | ";
                break;
            case "FLOOR":
                Map[6] = "|    | ____ |   | ___ | X |             |  | |   | ";
                break;
        }
        for(int i = 0; i <= 17; i++){
            System.out.println(Map[i]);
        }
    }
}
