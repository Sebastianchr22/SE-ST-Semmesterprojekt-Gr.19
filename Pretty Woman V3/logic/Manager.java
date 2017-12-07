package logic;


public class Manager {

    private String name;
    private Room currentRoom;
    private Room nextRoom;
    private int percentage = 15;
    private Chance chance = new Chance();

    Manager(String name, Room currentRoom) {
        this.name = name;
        this.currentRoom = currentRoom;
    }
    public double getPercentage(){
        return this.percentage/100.00;
    }
        
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

    public String getRoom() {
        return currentRoom.getNameBackend().toUpperCase();
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }
}
