package worldofzuul;

/** 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class Command
{
    //Sets a private of the class commandWord with the name commandWord.
    //This is for use later on, to identify specific key words, like QUIT, HELP, and GO...
    
    //Sets a private String called secondWord, used later on in combination with a commandWord, for more specific commands, like,
    // GO West, or Go East.
    private CommandWord commandWord;
    private String secondWord;

    
    
    /**
     * Takes the set values into the method called Command, and sets an instance of these commands in the prior variables 
     * (commandWord, secondWord)
     * Returns nothing.
     * @param commandWord
     * @param secondWord 
     */
    public Command(CommandWord commandWord, String secondWord)
    {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    
    /**
     * Calls a funktion from the CommandWords.java document, to specifically check if the commandwords are valid.
     * 
     * @return commandword in String format
     */
    public CommandWord getCommandWord()
    {
        return commandWord;
    }

    
    
    /**
     * Repeats prior action for the secondWord, check if valid
     * @return 
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    
    
    
    /**
     * Checks if the getCommandWord returned an unknow for the command (If the commandword was unknow or not specified)
     * 
     * @return only returns a value if command was unknown. 
     */
    public boolean isUnknown()
    {
        return (commandWord == CommandWord.UNKNOWN);
    }

    
    
    /**
     * boolean operation to check if second word was blank, as in player entered Go. not Go West.
     * @return only retuns value if secondword was blank.
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}

