/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael KÃ¶lling and David J. Barnes+
 * @version 2011.07.31
 */

public class CommandWords
{
    private Option[] comandos;//Declaro el Array tradicional

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        comandos = Option.values();//Le asigno lo que devuelve ese método, que es un Array de Option
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {   
        //Se podría haber hecho con un while
        boolean found=false;
        for(int index=0; index<comandos.length && !found;index++){
            Option key =comandos[index];
            if (key != Option.UNKNOWN){//Con esto comprobamos que no es UNKNOWN, ya que si por casualidad le pasamos
                //una cadena vacía como String, nos daría como comando válido, y no lo es. De ahí la comprobación previa
                if (key.getOptionString().equals(aString)){
                   found = true;
                }
            }
        }
        return found;
    }
    /** OPCIÓN CON WHILE
     *  public boolean isCommand(String aString)
    {	
    	boolean command = false;
		int index= 0; 
		while (index<commands.length && !command){
			Option key = commands[index];
			if (key != Option.UNKNOWN){
				if (key.getOptionString().equals(aString)){
					command= true;
				}
				
			}
			index++;
		}

    	return command;

    }
     */

    /**
     * Print all valid commands to System.out
     */
    public void showAll(){
        String commands = "";
        for (Option option : comandos){
            if (option != Option.UNKNOWN){//Esta comparación evita que se imprima UNKNOWN
                commands += " " + option.getOptionString(); 
            }
        }
        System.out.println(commands);
    }

    /**
     * Return the Option associated with a word.
     * @param commandWord The word to look up (as a string).
     * @return The Option correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public Option getCommandWord(String commandWord){
        boolean found = false;
        Option option = null;//Se podría iniciar directamente a UNKNOWN, y quitar el if de abajo, ya que si no lo encuentra
        //de todas todas va a devovler UNKNOWN
        for (int index=0;index<comandos.length && !found;index++){
            if(comandos[index].getOptionString().equals(commandWord)){
                option = comandos[index];
                found = true;
            }
        }
        if (!found){
            option = Option.UNKNOWN;
        }
        return option;
    }
    /**OPCION CON WHILE
     * public Option getCommandWord(String commandWord)
	{
	  	Option comando= Option.UNKNOWN;
	  	boolean encontrado = false;
	  	int index=0;
                while(index<commands.length && !encontrado) {
                	Option key = commands[index];
					if (key != Option.UNKNOWN){
						if (key.getOptionString().equals(commandWord)){
							encontrado = true;
							comando = key;
						}
					}
				    index++;
                }	  
               	return comando;
	}    
    
     */

}

