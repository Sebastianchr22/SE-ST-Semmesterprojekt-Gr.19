


//Imports the Scanner class:
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Parser 
{
    //Makes new CommandWords class called commands:
    private CommandWords commands;
    //MAkes new scanner for later use:
    private Scanner reader;

    
    /**
     * Initializes the scanner and the commands class.
     */
    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    
    /**
     * Creates three Strings, inputLine, word1, word2, for later use.
     * Prints ">". and takes an input from the previously created Scanner class called reader.
     * Creates a new Scanner called tokenizer, used to check which words the payer has put in. tokenizer takes the input from
     * inputLine.
     * if:
     * If the user has entered something, it puts that String value into word1, and again check if there was more, and puts that
     * into word2.
     * it then calls the method Command, from Command.java, which takes to variables CommandWord commandWord, String secondWord
     * which in this case is word1 and word2
     * it also check to see if the commandword1, (word1) contains a known comamnd, otherwise it returns an unknown command error.
     * this is done by calling the getCommandWord method from CommandWords.java and passing word1 through.
     * @return 
     */
    public Command getCommand() 
    {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }

        return new Command(commands.getCommandWord(word1), word2);
    }

    
    /**
     * Creates new method, showCommands();
     * This calls the showAll() from CommandWords.java which will print out the command entered after it has been check for errors
     * and for what it contains.
     */
    public void showCommands()
    {
        commands.showAll();
    }
}
