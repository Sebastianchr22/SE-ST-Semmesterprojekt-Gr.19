package PrettyWoman;

/**
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
import java.util.*;

public class Game {

    private Parser parser;
    private Room currentRoom;
    public Preference Gold0 = new Preference("Gold", 0);
    public Manager manager;

    public Regular Bouncer = new Regular( "Jack the bouncer", 45, "muscular, he's always smiled at you, and greets you every morning. Maybe he fancies you a bit..?", Gold0, Gold0);

    public Game(Driver driver) {

        createRooms(driver);

        parser = new Parser();
    }

    private void createRooms(Driver driver) {

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
        manager = new Manager("Manager James", office, driver);

    }

    public void play(Driver driver) {
        printWelcome();

        boolean finished = false;
        while (!finished) {

            manager.moveManager();
            driver.playerStats.printUI(driver);
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

    private void printInventory(Driver driver) {
        System.out.println("");
        System.out.println("");
        System.out.println("____________________________Your inventory:___________________________");
        driver.inv.showInventory();
        System.out.println("______________________________________________________________________");
    }

    private boolean processCommand(Command command, Driver driver) {
        boolean wantToQuit = false;
        if (driver.playerStats.getMoneySaved() > 0) {
            CommandWord commandWord = command.getCommandWord();
            if (driver.playerStats.getMoves() == 0) {
                createRooms(driver);
                System.out.println("You've gone home, after a long day at work.");
                driver.playerStats.resetMoves();
            }

            if (commandWord == CommandWord.UNKNOWN) {
                System.out.println("I don't know what you mean...");
                return false;
            } else {
                driver.playerStats.minusMoves();
                driver.playerStats.removeHunger();
                if (currentRoom.getNameBackend().toUpperCase().equals(manager.getRoom()) && !currentRoom.getNameBackend().toUpperCase().equals("DANCE FLOOR") && !currentRoom.getNameBackend().toUpperCase().equals("LOCKER ROOM")) {
                    System.out.println("Your manager just spotted you leaving, and took his 15% cut.");
                    driver.playerStats.removeMoneySaved(driver.playerStats.getMoneySaved() * manager.getPercentage());
                }
                if (commandWord == CommandWord.HELP) {
                    printHelp();
                    driver.playerStats.addMoves(1);
                } else if (commandWord == CommandWord.GO) {
                    goRoom(command, driver);
                } else if (commandWord == CommandWord.MAP) {
                    driver.playerStats.printMap(currentRoom.getNameBackend());
                    driver.playerStats.addMoves(1);
                } else if (commandWord == CommandWord.SHOW) {
                    driver.playerStats.addMoves(1);
                    if (command.hasSecondWord()) {
                        String Show = command.getSecondWord();

                        switch (Show.toUpperCase()) {
                            case "INVENTORY":
                                printInventory(driver);
                                break;
                            case "INV":
                                printInventory(driver);
                                break;
                            case "MAP":
                                driver.playerStats.printMap(currentRoom.getNameBackend());
                                break;
                        }
                    } else {
                        System.out.println("Show what?");
                    }

                } else if (commandWord == CommandWord.DROP) {
                    driver.playerStats.addMoves(1);
                    if (command.hasSecondWord()) {
                        String itemnr = command.getSecondWord();
                        if (driver.inv.listLenght() >= Integer.valueOf(itemnr)) {
                            Item item = driver.inv.Inventory.get(Integer.valueOf(itemnr));
                            if (driver.inv.Inventory.contains(item)) {
                                driver.inv.removeFromInventory(item);
                                System.out.println(item.getName() + " has been removed from your inventory");
                                driver.itemlist.addItem(item);
                            } else {
                                System.out.println("The choosen item, is not in your inventory.");
                            }
                        } else {
                            System.out.println("The choosen item, is not in your inventory.");
                        }
                    } else {
                        System.out.println("Please enter the index number of the item you wish to drop.");
                    }
                    //Drop a specific item:

                    //Place it back in the itemlist:
                    //Remove from inv:
                } else if (commandWord == CommandWord.FLIRT) {
                    if (currentRoom.getNameBackend().equals("OUTSIDE")) {
                        System.out.println("You flirt with the bouncer");
                        Flirt flirt = new Flirt(driver, Bouncer);
                    } else {
                    }
                } else if (currentRoom.getNameBackend().equals("DANCE FLOOR")) {
                    //Calls danceMech with 
                    DanceMech dance = new DanceMech(driver, command);

                    //As parser variables.
                } else if (commandWord == CommandWord.STEAL) {
                    //Call lockerroom(); with an itemlist and a player inventory parameters.
                    if (currentRoom.getNameBackend().equals("LOCKER ROOM")) {
                        Lockerroom locker = new Lockerroom(driver);
                    } else {
                        System.out.println("There is nothing to steal here.");
                    }
                } else if (commandWord == CommandWord.BUY && currentRoom.getNameBackend().equals("HOME")) {
                    BuyFromHome buy = new BuyFromHome(driver, command);
                    driver.playerStats.addMoves(1);
                } else if (commandWord == CommandWord.QUIT) {

                    wantToQuit = quit(command);
                } else {
                    driver.playerStats.addMoves(1);
                    System.out.println("Something went wrong.");
                }
            }
        } else {
            wantToQuit = true;
            System.out.println("You have run out of money, therefore you've lost the game.");
        }
        if (driver.playerStats.getHunger() <= 0) {
            wantToQuit = true;
            System.out.println("Your daughter is starving, therefore you've lost the game.");
        }
        if (driver.getWon() == true) {
            wantToQuit = true;
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

    private void goRoom(Command command, Driver driver) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
        }

        String direction = command.getSecondWord();

        nextRoom = currentRoom.getExit(direction);

        if (currentRoom.getNameBackend().equals("HOME")) {
            driver.playerStats.resetMoves();
        }
        if (nextRoom == null) {
            driver.playerStats.addMoves(1);
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());

        }
    }

    private boolean quit(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            if (command.getSecondWord().toUpperCase().equals("GAME")) {
                return true;
            } else {
                System.out.println("Quit what?");
                return false;
            }
        }
    }

    public String getName() {
        return currentRoom.getNameBackend();
    }
}
