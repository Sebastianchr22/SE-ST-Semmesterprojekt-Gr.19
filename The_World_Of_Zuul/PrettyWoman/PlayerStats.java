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
    
    public void printMap(String CurrentRoom, String ManagerPossition){
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
        
        //Writes players position, marked with "X":
        if(CurrentRoom.equals("LOCKER")){
            Map[11] = "        | X |          -----            |        | ";
        }
        if(CurrentRoom.equals("OUTSIDE")){
            Map[1] = "          |   |     | X |                /  o  \\  ";
        }
        if(CurrentRoom.equals("P. ROOM")){
            Map[12] = "        -----          | X |  - - - - > |        | ";
        }
        if(CurrentRoom.equals("HOME")){
            Map[6] = "| X  | ____ |   | ___ |   |             |  | |   | ";
        }
        if(CurrentRoom.equals("B. ROOM")){
            Map[6] = "|    | ____ | X | ___ |   |             |  | |   | ";
        }
        if(CurrentRoom.equals("FLOOR")){
            Map[6] = "|    | ____ |   | ___ | X |             |  | |   | ";
        }
        
        
        /*
        //Marks Manager position, marked with "M":
        if(ManagerPossition.equals("LOCKER")){
            Map[11] = "        | M |          -----            |        | ";
        }
        if(ManagerPossition.equals("OUTSIDE")){
            Map[1] = "          |   |     | M |                /  o  \\  ";
        }
        if(ManagerPossition.equals("OFFICE")){
            Map[2] = "          | M |     |   |                /  o  \\  ";
        }
        if(ManagerPossition.equals("P. ROOM")){
            Map[12] = "        -----          | M |  - - - - > |        | ";
        }
        if(ManagerPossition.equals("B. ROOM")){
            Map[6] = "|    | ____ | M | ___ |   |             |  | |   | ";
        }
        if(ManagerPossition.equals("FLOOR")){
            Map[6] = "|    | ____ |   | ___ | M |             |  | |   | ";
        }*/
        
        
        
        for(int i = 0; i <= 17; i++){
            System.out.println(Map[i]);
        }
    }
}
