package logic;

public class Manager {

    private String name;
    private Room currentRoom;
    private Room nextRoom;
    private int percentage = 15;
    private Chance chance = new Chance();

    /**
     * Constructor for the manager, to set his initial room, and his name.
     * @param name : String
     * @param currentRoom : Room
     */
    Manager(String name, Room currentRoom) {
        this.name = name;
        this.currentRoom = currentRoom;
    }

    /**
     * This returns the percentage value of the managers cut.
     * @return percentage : Double
     */
    public double getPercentage() {
        return this.percentage / 100.00;
    }

    /**
     * A random number is generated, and a corresponding string is found from a switch statement using the random number.
     * @return room name : String
     */
    public String genRandomExit() {
        int random = 0;
        random = (int) Math.round(1.0 + Math.random() * 6.0);
        String returnValue = "";
        switch (random) {
            case 1:
                returnValue = "privateRoom";
                break;
            case 2:
                returnValue = "office";
                break;
            case 3:
                returnValue = "outside";
                break;
            case 4:
                returnValue = "back";
                break;
            case 5:
                returnValue = "locker";
                break;
            case 6:
                returnValue = "floor";
                break;
            default:
                break;
        }
        return returnValue;
    }

    /**
     * Calling this method has a 20% chance, of moving the manager to a new location.
     * This is done, with the chanceCald method on the Chance class object. A string direction, is set to the return value of genRandomExit
     * If the managers currentroom has an exit with the string value of the randomly found string, the manager will move, else it will try again.
     */
    public void moveManager() {
        //currentRoom = currentRoom.getExit(currentRoom.getNameBackend());
        System.out.println("Manager at: " + currentRoom.getNameBackend());
        if (chance.ChanceCalc(20, 100)) {
            nextRoom = null;
            while (nextRoom == null) {
                String direction = genRandomExit();
                nextRoom = currentRoom.getExit(direction);
            }
            setCurrentRoom(nextRoom);
        }
    }

    /**
     * Will return the managers currentRoom name, in all caps.
     *
     * @return currentRoom name : String
     */
    public String getRoom() {
        return currentRoom.getNameBackend().toUpperCase();
    }

    /**
     * Will set the managers currentRoom to the new room found.
     *
     * @param room : Room
     */
    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }
}
