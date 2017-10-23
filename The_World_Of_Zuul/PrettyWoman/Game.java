package PrettyWoman;

/*
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Game {

    DanceMech DanceMechanics = new DanceMech();
    PlayerStats playerStats = new PlayerStats();
    Chance chanceCalc = new Chance();
    private Parser parser;
    private Room currentRoom;
  
    public Moves moves = new Moves();

    public Game() {

        createRooms();

        parser = new Parser();
    }

    public Inventory inv = new Inventory();
    public Item weddingring = new Item(0, "Wedding Ring", "Your wedding ring", "Wedding",3);
    public Item goldring = new Item(1, "Gold Ring", "A nice gold ring", "Gold",3);
    public Item goldearring = new Item(2, "Gold Earring", "A nice gold earring", "Gold",3);
    public Item goldnecklace = new Item(3, "Gold Ring", "A nice gold necklace", "Gold",3);
    public Item goldwristwatch = new Item(4, "Gold Wristwatch", "A nice gold wristwatch", "Gold",3);
    public Item goldbracelet = new Item(5, "Gold Bracelet", "A nice gold bracelet", "Gold",3);
    
    
    public void createStartInv(){
        inv.addToIventory(goldring);
    }
    
    private void createRooms() {

        Room home, back, locker, floor, privateRoom, office, outside, motel, tower, front;

        privateRoom = new Room("in the private room, where everything can happen");
        office = new Room("in the managers office");
        outside = new Room("outside of the strip club"+"\n"+"There is a bit of line of people waiting to get in.."+"\n"+"The bouncer is out here, he always smiles at me..");

        
        privateRoom = new Room("in the private room, where everything can happen");
        office = new Room("in the managers office");
        front = new Room("in front of the strip club");
        motel = new Room("in a motel");
        tower = new Room("in the home of your new lover");
        home = new Room("home, where your daughter is");
        back = new Room("in the backroom.");
        locker = new Room("in the locker room. Here you can gather points and money by stealing from other strippers");
        floor = new Room("on the floor. Here you can earn money by doing various dance moves or by talking to the guests to see if you meet someone interesting");

        home.setExit("back", back);

        back.setExit("floor", floor);
        back.setExit("locker", locker);

        back.setExit("home", home);

        locker.setExit("back", back);

        floor.setExit("back", back);

        floor.setExit("outside", outside);

        floor.setExit("private room", privateRoom);

        privateRoom.setExit("floor", floor);

        office.setExit("back", back);

        outside.setExit("floor", floor);

        motel.setExit("home", home);

        tower.setExit("home", home);

        currentRoom = home;
    }

    public String getRoom(){
        return String.valueOf(currentRoom.hashCode()); 
    }

    public void play() {
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
            System.out.println(getRoom());
            playerStats.printMap(getRoom());
        }else if (commandWord == CommandWord.FLIRT && getRoom().equals("outside")){
            System.out.println("FLIRTIN WOROSH");
        }else if (commandWord == CommandWord.QUIT) {

            wantToQuit = quit(command);
        }
        return wantToQuit;
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
        
        if ("home".equals(direction)) {
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
}