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
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;
    private Room southeastExit;
    private Room northwestExit;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
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
            northExit = north;
        if(east != null)
            eastExit = east;
        if(southeast != null)
            southeastExit = southeast;  
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
        if (northwest !=null)
            northwestExit = northwest;
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
        if (direction.equals("north")){
            nextExit= northExit;
        }else if(direction.equals("east")){
            nextExit= eastExit;
        }else if (direction.equals("southeast")){
            nextExit = southeastExit; 
        }else if (direction.equals("south")){
            nextExit=southExit; 
        }else if (direction.equals("west")){
            nextExit=westExit;
        }else if (direction.equals("northwest")){
            nextExit=northwestExit;
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
        String exit = "Exits: ";
        if (northExit != null){
            exit += " north ";
        }
        if (eastExit != null){
            exit += " east ";
        }
        if (southeastExit != null){
            exit += " southeast ";
        }
        if (southExit != null){
            exit += " south ";
        }
        if (westExit != null){
            exit += " west ";
        }
        if (northwestExit !=null){
            exit += " northwest";
        }
        return exit;
    }
}
