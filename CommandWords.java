import java.util.HashMap;
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes+
 * @version 2011.07.31
 */

public class CommandWords
{
    // a constant array that holds all valid command words
    private HashMap<String,Option> validCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        validCommands = new HashMap<>();
        validCommands.put("ir", Option.GO);
        validCommands.put("salir", Option.QUIT);
        validCommands.put("ayuda", Option.HELP);
        validCommands.put("mirar", Option.LOOK);
        validCommands.put("comer", Option.EAT);
        validCommands.put("volver", Option.BACK);
        validCommands.put("coger", Option.TAKE);
        validCommands.put("dejar", Option.DROP);
        validCommands.put("objetos", Option.ITEMS);
        //ver que no ponemos en el hashmap el UNKNOWN, realmente no es un comando
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {   
        //si encuentra un valor para esa key, ser� distinto de null y devolver� true
        return validCommands.get(aString) != null;
    }

    /**
     * Print all valid commands to System.out
     */
    public void showAll(){
        System.out.println(validCommands.keySet());
    }

    /**
     * Return the Option associated with a word.
     * @param commandWord The word to look up (as a string).
     * @return The Option correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public Option getCommandWord(String commandWord){
        Option option;
        if(isCommand(commandWord)){
            option = validCommands.get(commandWord);
        }else{
            option = Option.UNKNOWN;
        }
        return option;
    }
        
        
}
