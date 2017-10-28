package PrettyWoman;
class PlayerStats {
    private int Experience = 0;
    private int Enhancements = 0;
    private double moneySaved = 1000;
    private int currentHunger = 60;
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
    public void addExperience(int value){
        this.Experience+=value;
    }
    public void removeExperience(int value){
        this.Experience-=value;
    }
    public void addMoneySaved(double value){
        this.moneySaved+=value;
    }
    public void removeMoneySaved(double value){
        this.moneySaved-=value;
    }
    public void addEnhancements(int value){
        this.Enhancements+=value;
    }
    public void removeEnhancements(int value){
        this.Enhancements-=value;
    }
    public boolean addHunger(int value){
        if(this.currentHunger+value <= 100){
            this.currentHunger+=value;
            return true;
        }else{
            return false;
        }         
    }
    public void printUI(){
        System.out.println("");
        System.out.println("");
        System.out.println("");System.out.println("                      "+"           Hunger:");
        System.out.print("                      "+"----------------------------"+"     $ " + moneySaved+" "     +"\n"+"                      "+"|");
        for(int i = 0; i <= currentHunger/4; i++){
            System.out.print("/");
        }for(int j = 24-currentHunger/4;j >= 0; j--) 
            System.out.print(" ");
        System.out.print("|"+"     Enhancements: "+Enhancements+"\n"+"                      "+"----------------------------"+"     Experience: "+Experience+"\n");
    }
    
    public void printMap(String CurrentRoom){
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
        for(int i = 0; i <= 17; i++){
            System.out.println(Map[i]);
        }
    }
}