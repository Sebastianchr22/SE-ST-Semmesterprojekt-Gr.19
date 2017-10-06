package PrettyWoman;



/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    private void createRooms() // Room constructor
    {
        Room home, back, locker, floor, privateRoom, office, front, motel, tower, jail;
      
        privateRoom = new Room("in the private room, where everything can happen");
        office = new Room("in the managers office");
        front = new Room("in front of the strip club");
        motel = new Room("in a motel");
        tower = new Room("in the home of your new lover");
        home = new Room("home, where your daughter is.");
        back = new Room("in the backroom.");
        locker = new Room("in the locker room. Here you can gather points and money by stealing from other strippers");
        floor = new Room("on the floor. Here you can earn money by doing various dance moves or by talking to the guests to see if you meet someone interesting");
        jail = new Room("you're in jail, deal with it.");
        
        home.setExit("back", back);
 
        back.setExit("floor", floor);
        back.setExit("locker", locker);
        back.setExit("home", home);
       
        locker.setExit("back", back);
 
        floor.setExit("back", back);        
        
        privateRoom.setExit("floor", floor);

        office.setExit("back", back);

        front.setExit("floor", floor);

        motel.setExit("home", home);
        
        tower.setExit("home", home);
        
        jail.setExit("home", home);


        currentRoom = home;
    }

    public void play() 
    {            
        printWelcome();

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
}
