package PrettyWoman;
import java.util.*;

public class DanceMech {
    public int move1ExpRequired = 0;
    public int move2ExpRequired = 25;
    PlayerStats playerStats = new PlayerStats();
    Chance chance = new Chance();
    Inventory inv = new Inventory();
    ArrayList<Regular> reglist = new ArrayList<>();
    ListOfRegulars listReg = new ListOfRegulars(reglist);
    
    
    
    //Example of items, as a set of starting items
    public Item weddingring = new Item(0, "Wedding Ring", "Your wedding ring", "Silver",3);
    public Item goldring = new Item(1, "Gold Ring", "A nice gold ring", "Gold",3);
    public Item goldearring = new Item(2, "Gold Earring", "A nice gold earring", "Gold",3);
    public Item goldnecklace = new Item(3, "Gold Ring", "A nice gold necklace", "Gold",3);
    public Item goldwristwatch = new Item(4, "Gold Wristwatch", "A nice gold wristwatch", "Gold",3);
    public Item goldbracelet = new Item(5, "Gold Bracelet", "A nice gold bracelet", "Gold",3);
    public int amountOfItems = 4;
    
        
    public void addToInv(){
        //Adds all starting items to the inventory:
        inv.addToIventory(weddingring);
        inv.addToIventory(goldring);
        inv.addToIventory(goldearring);
        inv.addToIventory(goldnecklace);
        inv.addToIventory(goldwristwatch);
        inv.addToIventory(goldbracelet);
        inv.showInventory();
    }
    
    
    Preference Gold = new Preference("Gold",2);
    Preference Silver = new Preference("Silver",1);
    Preference Wig  = new Preference("Wig",1);
    Regular Sebastian = new Regular(1,"Sebastian",22,"Swaggy",Gold,Silver);
    Regular John = new Regular(1,"John Mayer", 34, "Nice guy",Gold,Wig);
    Regular Carl = new Regular(2,"CORRAAAAAAL!",12,"small, whiny",Silver,Wig);
    
    
    /**
     * Prints the money and experience gained by the player:
     * @return nothing.
     */
    public void printInterface(){     
        System.out.println("$" + Math.round((playerStats.getMoneySaved())*100.0)/100.0 + "      " + "Exp: " + playerStats.getExperience());//Prints the saved money rounded off to two digits.
    }
    public void defaultRegList(){
        reglist.add(Sebastian);
        reglist.add(Carl);
        reglist.add(John);
    }
      
    
    public static void main(String[] args) {
        
        
        boolean RegularInRoom;
        
        DanceMech gameplay = new DanceMech();
        gameplay.addToInv();
        gameplay.defaultRegList();

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
            System.out.println("3. Private room dance");

            //Spacing:
            System.out.println("");
            System.out.println("");

            //Input prompt:
            System.out.print("> ");
            mainFloorChoice = mainFloorInput.next();
            gameplay.danceMoveYield(mainFloorChoice);
        } while (om == 1);
    }

  

    
  
    public double tipsGained(double bonus) {
        double percentageBonusTip = 1+playerStats.getEnhancements()*0.05;//Calculates a percentage of bonus based on improvements
        double tips = 5.0+Math.random()*30.0;//Calculates a random number between 5 to 30
        return Math.round((percentageBonusTip*tips+bonus)*100.0)/100.0; //Returns the random* the percentage, rounded off with two digits after the comma.
    }

    
 
    public void danceMoveYield(String danceMoveChoosen) {
        PrivateRoom pRoom = new PrivateRoom();
        if (danceMoveChoosen.equals("1")) {
            danceMovePrint(playerStats.getExperience(), move1ExpRequired);//Calls the method below to print success or failure.
        }
        if (danceMoveChoosen.equals("2")) {
            //Insert from move 1:
            danceMovePrint(playerStats.getExperience(), move2ExpRequired);
        }if(danceMoveChoosen.equals("3")){
            pRoom.privateRoomInvite(Sebastian,playerStats,inv,listReg);
        }if(danceMoveChoosen.equals("map")){
            playerStats.printMap("Floor");
        }
        else {
            //Unknown dancemove
        }
    }
    public int exptips(int experience, int required){
        if(required>experience){
            return 0;
        }else{
            return (experience-required)*3;
        }
    }
    
    public void danceMovePrint(int experience, int danceMoveExpRequired){
        if (experience >= danceMoveExpRequired) {
            //You have enough experience to perform this move:
            System.out.println("Your move was successful.");
            playerStats.addExperience(1);
            double tipsFromMove = tipsGained(exptips(experience,danceMoveExpRequired));
            System.out.println("You received $" + tipsFromMove + " in tips for that move.");
            playerStats.addMoneySaved(tipsFromMove);
        } else {
            //You do not have enough experience to perform this move:
            if (chance.ChanceCalc(25, 100)) {
                //It was successful:
                System.out.println("Although you are not experienced with that move, you were successful.");
                playerStats.addExperience(1);
                double tipsFromMove = tipsGained(exptips(experience,danceMoveExpRequired));
                System.out.println("You received $" + tipsFromMove + " in tips for that move.");
                playerStats.addMoneySaved(tipsFromMove);

            } else {
                //You failed:
                System.out.println("Your lack of experience clearly shows and the crowd are not happy.");
            }
        }
    }
}
