import java.util.Stack;
import java.util.ArrayList;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{

    private Room currentRoom;
    private Stack<Room> previousRooms;
    private ArrayList<Item> playerItems;
    //peso máximo que puede llevar el jugador
    public static final int MAX_WEIGHT = 4;

    /**
     * Constructor for objects of class Player
     */
    public Player(Room currentRoom)
    {
        this.currentRoom = currentRoom;
        previousRooms = new Stack<>();
        playerItems = new ArrayList<>();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    public void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            previousRooms.push(currentRoom);
            currentRoom = nextRoom;
            printLocationInfo();
            System.out.println();
        }
    }

    public void goBack(){
        if (previousRooms.empty()){
            System.out.println("You haven't moved yet, you can´t go back");
        }
        else{
            currentRoom = previousRooms.pop();
        }
        printLocationInfo();
        System.out.println();
    }

    public void printLocationInfo(){
        System.out.println(currentRoom.getLongDescription());
    }
}
