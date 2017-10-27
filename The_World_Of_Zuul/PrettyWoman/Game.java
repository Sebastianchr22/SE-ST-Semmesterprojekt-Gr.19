package PrettyWoman;

/**
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
import java.util.*;
public class Game {
    //Regulars regulars = new Regulars();
    PlayerStats playerStats = new PlayerStats();
    Inventory inv = new Inventory();
    Chance chanceCalc = new Chance();
    //ArrayList<Regulars> list = new ArrayList<>();
    //ListOfRegulars reglist = new ListOfRegulars(list);
    //DanceMech mech = new DanceMech(playerStats, regulars, inv, reglist);
    private Parser parser;
    private Room currentRoom;
  
    public Moves moves = new Moves();

    public Game(ListOfRegulars reglist, Regulars regulars) {
        
        createRooms();
        dance(reglist, regulars);
        parser = new Parser();
    }
    public void dance(ListOfRegulars reglist, Regulars regulars)
    {
    DanceMech mech = new DanceMech(playerStats, regulars, inv, reglist);
    }

   
    
    private void createRooms() {

        Room home, back, locker, floor, privateRoom, office, outside, motel, tower;
      
        privateRoom = new Room("Private room", "in the private room, where everything can happen");        
        office = new Room("Office", "in the managers office");
        outside = new Room("Outside", "in front of the strip club");
        motel = new Room("Motel", "in a motel");
        tower = new Room("Tower", "in the home of your new lover");
        home = new Room("Home", "home, where your daughter is");
        back = new Room("Backroom", "in the backroom.");
        locker = new Room("Locker room", "in the locker room. Here you can gather points and money by stealing from other strippers");
        floor = new Room("Dance floor", "on the floor. Here you can earn money by doing various dance moves or by talking to the guests to see if you meet someone interesting");

        home.setExit("back", back);

        back.setExit("floor", floor);
        back.setExit("locker", locker);

        back.setExit("home", home);

        locker.setExit("back", back);

        floor.setExit("back", back);

        floor.setExit("outside", outside);

        floor.setExit("private", privateRoom);

        privateRoom.setExit("floor", floor);

        office.setExit("back", back);

        outside.setExit("floor", floor);

        motel.setExit("home", home);

        tower.setExit("home", home);

        currentRoom = home;
    }  

    public void play() {
//        regulars.createReglist(reglist);
//        reglist.toString();
        printWelcome();
        boolean finished = false;
        while (!finished) {
            playerStats.printUI();
            
            System.out.println("Moves left: " + moves.getMoves());

            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the Pretty Woman Strip Club!");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }
        if (commandWord == CommandWord.HELP) {
            printHelp();
        } else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }else if(commandWord == CommandWord.MAP){
            playerStats.printMap(currentRoom.getNameBackend());
        }else if (commandWord == CommandWord.FLIRT && currentRoom.getNameBackend().equals("OUTSIDE")){
            
        }else if(commandWord == CommandWord.DANCE && command.hasSecondWord()){
            //Calls danceMech with 
            String danceMoveChoosen = getDanceMove(command);
            //As parser variables.
            
        }else if(commandWord == CommandWord.STEAL && currentRoom.getNameBackend().equals("LOCKER ROOM")){
            //Call lockerroom(); with an itemlist and a player inventory parameters.
            
        }
        else if (commandWord == CommandWord.QUIT) {

            wantToQuit = quit(command);
        }
        return wantToQuit;
    }
    private String getDanceMove(Command command){
        if(command.hasSecondWord()){
            //Return the secondword:
            return command.getSecondWord();
            
        }else{
            //Not a known dance move:
            System.out.println("You have not specified a dance move.");
            return "error";
        }
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);
        
        if (currentRoom.getNameBackend().equals("HOME")) {
            moves.resetMoves();
        }if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            moves.removeMoves();
            System.out.println(currentRoom.getLongDescription());

        }
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }
    public String getName()
    {
        return currentRoom.getNameBackend();
    }
}
