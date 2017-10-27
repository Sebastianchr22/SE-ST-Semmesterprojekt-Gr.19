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
    
    int jewelryWeigth = 3;
    int outfitWeigth = 60;
    int wigWeigth = 20;
    int shoesWeigth = 40;
    int makeupWeigth = 5;
    
    public Inventory inv = new Inventory();
    //wedding ring
    public Item weddingring = new Item(0, "Wedding Ring", "Your wedding ring", "Wedding", jewelryWeigth);
    //gold jewelry
    public Item goldring = new Item(1, "Gold Ring", "A nice gold ring", "Gold", jewelryWeigth);
    public Item goldearring = new Item(2, "Gold Earring", "A nice gold earring", "Gold", jewelryWeigth);
    public Item goldwristwatch = new Item(3, "Gold Wristwatch", "A nice gold wristwatch", "Gold", jewelryWeigth);
    public Item goldbracelet = new Item(4, "Gold Bracelet", "A nice gold bracelet", "Gold", jewelryWeigth);
    public Item goldnecklace = new Item(5, "Gold Necklace", "A nice silver necklace", "Gold", jewelryWeigth);
    //silver jewelry
    public Item silverring = new Item(6, "Silver Ring", "A cool silver ring", "Silver", jewelryWeigth);
    public Item silverearring = new Item(7, "Silver Earring", "A cool silver earring", "Silver", jewelryWeigth);
    public Item silverwristwatch = new Item(8, "Silver Wristwatch", "A cool silver wristwatch", "Silver", jewelryWeigth);
    public Item silverbracelet = new Item(9, "Silver Bracelet", "A cool silver bracelet", "Silver", jewelryWeigth);
    public Item silvernecklace = new Item(10, "Silver Necklace", "A cool silver necklace", "Silver", jewelryWeigth);
    //outfits
    public Item schoolO = new Item(11, "School Girl Outfit", "An outfit that will make you look like a sexy young high school student", "Outfit", outfitWeigth);
    public Item nurseO = new Item(12, "Nurse Outfit", "An outfit that will make you look like a sexy nurse", "Outfit", outfitWeigth);
    public Item ninjaO = new Item(13, "Ninja Outfit", "An outfit that will make you look like a sexy acrobatic ninja", "Outfit", outfitWeigth);
    public Item maidO = new Item(14, "Maid Outfit", "An outfit that will make you look like a sexy french maid", "Outfit", outfitWeigth);
    public Item policeO = new Item(15, "Police Outfit", "An outfit that will make you look like a sexy police officer", "Outfit", outfitWeigth);
    public Item cheerleaderO = new Item(16, "Cheerleader Outfit", "An outfit that will make you look like a sexy cheerleader", "Outfit", outfitWeigth);
    public Item cowgirlO = new Item(17, "Cowgirl Outfit", "An outfit that will make you look like a sexy cowgirl", "Outfit", outfitWeigth);
    public Item minecraftO = new Item(18, "Sexy Minecraft Outfit", "An outfit that will make you look like a sexy minecraft girl, made of blocks", "Outfit", outfitWeigth);
    public Item bunnyO = new Item(19, "Bunny Outfit", "An outfit that will make you look sexy with bunny ears and tail", "Outfit", outfitWeigth);
    public Item devilO = new Item(20, "Devil Outfit", "An outfit that will make you look like a sexy devil", "Outfit", outfitWeigth);
    public Item adidasO = new Item(21, "Adidas Outfit", "An outfit that will make you into a real slav", "Outfit", outfitWeigth);
    public Item superWomanO = new Item(22, "Super Woman Outfit", "An outfit that will make you look like the sexy Super Woman", "Outfit", outfitWeigth);
    //wigs
    public Item curlyBlondeW = new Item(23, "Curly Blonde Wig", "Classy curly blonde hair", "Wig", wigWeigth);
    public Item longBlueW = new Item(24, "Long Blue Hair Wig", "Long blue hair like taken from an anime", "Wig", wigWeigth);
    public Item baldW = new Item(25, "Bald Wig", "Makes you bald", "Wig", wigWeigth);
    public Item shortStylishW = new Item(26, "Short Stylish Hair Wig", "Gives you really stylish short hair", "Wig", wigWeigth);
    public Item superSaiyanW = new Item(27, "Super Saiyan Wig", "Makes your hair glow yellow, Over 9000!!", "Wig", wigWeigth);
    //shoes
    public Item yeezyS = new Item(28, "Yeezy", "Shoes for a real swagster", "Shoe", shoesWeigth);
    public Item adidasS = new Item(29, "Adidas Shoes", "The only shoes for a real slav", "Shoe", shoesWeigth);
    public Item sandalsS = new Item(30, "Sandals", "Usefull for walking on the beach", "Shoe", shoesWeigth);
    public Item highHeelsS = new Item(31, "Red High Heels", "Classy red heels for at classy woman", "Shoe", shoesWeigth);
    public Item gucciS = new Item(32, "Gucci Shoes", "Show through your shoes that you got money and bad style", "Shoe", shoesWeigth);
    //makeup
    public Item heavyMakeupM = new Item(33, "Heavy Makeup", "When you have to look really good, even if you need a full facemask of makeup", "Makeup", makeupWeigth);
    public Item mediumMakeupM = new Item(34, "Medium Makeup", "When you really wanna look good, but still won't use too much makeup", "Makeup", makeupWeigth);
    public Item lightMakeupM = new Item(35, "Light Makeup", "Makeup for a more neutral and healthy look", "Makeup", makeupWeigth);
    
    
    public void createStartInv(){
        inv.addToIventory(weddingring);
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