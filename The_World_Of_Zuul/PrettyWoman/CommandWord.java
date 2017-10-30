package PrettyWoman;



/**
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public enum CommandWord
{
    // Sets a list of keywords:
    GO("go"), QUIT("quit"), DROP("drop"), SHOW("show"), ACCEPT("accept"), YES("yes"), REJECT("reject"), NO("no"), HELP("help"), FLIRT("flirt"), DANCE("dance"), STEAL("steal"), BUY("buy"), MAP("map"), INFO("info"), UNKNOWN("?");
    
    //Creates a string for the keywords:
    private String commandString;
    
    
    //Puts a string containing commands into an instance of commandstring.
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    
    //Returns a string value of the commandstring:
    public String toString()
    {
        return commandString;
    }
}
