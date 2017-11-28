package logic;

import java.util.HashMap;

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class CommandWords
{
    
    
    /**
     * ?? Hashes a string input, and checks for each word, if the given is not an unknown command.
     * no too sure, please revise.
     */
    private HashMap<String, CommandWord> validCommands;

    public CommandWords()
    {
        validCommands = new HashMap<String, CommandWord>();
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    
    
    /**
     * New method for commandword, in string fromat
     * Takes one parameter; commandWord, and puts that value into command variable. Only if the commandWord is a known command word.
     * this is checked by validCommands.
     * if the commandword is not a recognized command, this method will return unknown command.
     * if the commandword is a recognized type, this method will return the command, for use.
     * @param commandWord
     * @return command
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
    
    
    /**
     * This method check the command input, and sees if it contains a keyword.
     * This is possible because of the string hashing in validCommands.
     * @param aString
     * @return key words.
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }

    
    
    
    /**
     * This method prints all valid commands, where a keyword has been specified.
     * prints a blank line below it.
     */
    public void showAll() 
    {
        for(String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
