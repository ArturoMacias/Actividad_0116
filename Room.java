import java.util.HashMap;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> map;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        map = new HashMap<>();
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The southeast east.
     * @param southeast The southeast exit.
     * @param south The south exit.
     * @param west The west exit.
     * @param northwest The northwest exit.
     */
    public void setExits(Room north, Room east,Room southeast, Room south,Room west, Room northwest) 
    {
        if(north != null)
            map.put("north", north);
        if(east != null)
            map.put("east", east);
        if(southeast != null)
            map.put("southeast", southeast);
        if(south != null)
            map.put("south", south);
        if(west != null)
            map.put("west", west);
        if (northwest !=null)
            map.put("northwest", northwest);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    public Room getExit(String direction){

        Room nextExit;
        if (map.containsKey(direction)){
            nextExit=map.get(direction);
        }
        else{
            nextExit= null; 
        }
        return nextExit;
    }

    /**
     * Return a description of the room's exits.
     * For example: "Exits: north east west"
     *
     * @ return A description of the available exits.
     */
    public String getExitString(){
        String exit = "Exits: " + map.keySet();
        return exit;
    }
}
