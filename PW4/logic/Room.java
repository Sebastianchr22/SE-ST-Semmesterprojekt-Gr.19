package logic;

import java.util.Set;
import java.util.HashMap;


/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Room 
{
    private String name;
    private String description;
    private String helpText;
    private HashMap<String, Room> exits;

    public Room(String name, String description, String helpText) 
    {
        this.name = name;
        this.description = description;
        this.helpText = helpText;
        exits = new HashMap<String, Room>();
    }
    
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

	private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    public String getNameBackend()
    {
        return name.toUpperCase();
    }
    
    public String getHelpText(){
        return this.helpText;
    }
}

