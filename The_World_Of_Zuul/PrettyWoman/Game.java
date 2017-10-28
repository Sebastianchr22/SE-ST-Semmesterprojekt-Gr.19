package PrettyWoman;

/**
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
import java.util.*;

public class Game {

    private Parser parser;
    private Room currentRoom;

    public Moves moves = new Moves();

    public Game(Driver driver) {

        createRooms();

        parser = new Parser();
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

        home.setExit("work", back);

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

    public void play(Driver driver) {
        printWelcome();
        boolean finished = false;
        while (!finished) {
            driver.playerStats.printUI();
            if (currentRoom.getNameBackend().equals("HOME")) {
                BuyFromHome buy = new BuyFromHome(driver.playerStats);
            }
            if (currentRoom.getNameBackend().toUpperCase().equals("DANCE FLOOR")) {
                DanceMech dance = new DanceMech();
            }

            //System.out.println("Moves left: " + moves.getMoves());
            Command command = parser.getCommand();
            finished = processCommand(command, driver);
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

    private boolean processCommand(Command command, Driver driver) {
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
        } else if (commandWord == CommandWord.MAP) {
            driver.playerStats.printMap(currentRoom.getNameBackend());
        } else if (commandWord == CommandWord.FLIRT && currentRoom.getNameBackend().equals("OUTSIDE")) {

        } else if (nextRoom.getNameBackend().toUpperCase().equals("DANCE FLOOR")) {
            //Calls danceMech with 
            DanceMech dance = new DanceMech(driver, command);

            //As parser variables.
        } else if (commandWord == CommandWord.STEAL && currentRoom.getNameBackend().equals("LOCKER ROOM")) {
            //Call lockerroom(); with an itemlist and a player inventory parameters.

        } else if (commandWord == CommandWord.QUIT) {

            wantToQuit = quit(command);
        } else if (commandWord == CommandWord.BUY && currentRoom.getNameBackend().toUpperCase().equals("HOME")) {
            BuyFromHome buy = new BuyFromHome(driver, command);
        }
        return wantToQuit;
    }

    private String getDanceMove(Command command) {
        if (command.hasSecondWord()) {
            //Return the secondword:
            return command.getSecondWord();

        } else {
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
    public Room nextRoom;

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
        }

        String direction = command.getSecondWord();

        nextRoom = currentRoom.getExit(direction);

        if (currentRoom.getNameBackend().equals("HOME")) {
            moves.resetMoves();
        }
        if (nextRoom == null) {
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

    public String getName() {
        return currentRoom.getNameBackend();
    }
}
