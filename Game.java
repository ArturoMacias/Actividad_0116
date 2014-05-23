
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class Game 
{
    private Parser parser;
    private Player player;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        player = new Player ();
        parser = new Parser();
        createRooms();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, corridor, kitchen, mobile, video;

        // create the rooms
        outside = new Room("outside the main entrance of the mall center");
        corridor = new Room("in the mall center acces area");
        kitchen = new Room("in the kitchen section");
        mobile = new Room("in the mobile section");
        video = new Room("in the video section");
        //add items 
        outside.addItem("lamp", 2, false,false,false);
        outside.addItem("chair",3,true,true,false);
        corridor.addItem("cigarrette",1,true,true,false);
        corridor.addItem("cookie",1,true,false,false);
        mobile.addItem("mobile",1,true,false,true);
        mobile.addItem("table",5,false,false,false);
        kitchen.addItem("knife",1,true,true,false);
        // initialise room exits
        outside.setExit("south",corridor);
        corridor.setExit("north",outside);
        corridor.setExit("south",mobile);
        corridor.setExit("west",kitchen);
        kitchen.setExit("east", corridor);
        kitchen.setExit("southeast",mobile);
        kitchen.setExit("south",video);
        mobile.setExit("north",corridor);
        mobile.setExit("west", video);
        mobile.setExit("northwest",kitchen);
        video.setExit("north",kitchen);
        video.setExit("east", mobile);

        player.setCurrentRoom(outside);

    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;

        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'ayuda' if you need help.");
        System.out.println();
        player.printLocationInfo();
        System.out.println();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        Option commandWord = command.getCommandWord();
        switch(commandWord){
            case HELP:
            printHelp();
            break;
            case GO:
            player.goRoom(command);
            break;
            case QUIT:
            wantToQuit = quit(command);
            break;
            case LOOK:
            player.printLocationInfo();
            break;
            case EAT:
            player.eat();
            break;
            case BACK:
            player.goBack();
            break;
            case TAKE:
            wantToQuit=player.takeItem(command);
            break;
            case DROP:
            player.dropItem(command);
            break;
            case ITEMS:
            player.showItems();
            break;
        }
        
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     * Opción (A)

    private void printHelp() 
    {
    System.out.println("You are lost. You are alone. You wander");
    System.out.println("around at the university.");
    System.out.println();
    System.out.println("Your command words are:");
    parser.getCommandWords().showAll();
    }
     */

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     * Opción (B)
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.printCommandWords();
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

}

