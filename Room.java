import java.util.HashMap;
import java.util.ArrayList;
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
 * @author  Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> map;
    private ArrayList<Item> items;

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
        items = new ArrayList<>();
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor The room in the given direction.
     */
    public void setExit(String direction, Room neighbor){
        map.put (direction, neighbor);
    }

    public void addItem(String description, int weight, boolean taken){
        items.add(new Item(description,weight,taken));
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

    public String getItemsInfo(){
        String description = null;
        if (items.size()>0){
            description = "Available objects: ";
            for (Item item: items){
                description += "//Name: "+item.getItemName() + "; Weight: " + item.getWeight() + "//" + "\n"; 
            }
        }else{
            description = "No items in this room";
        }
        return description;
    }

    /**
     * Devuelve un item si su nombre coincide con el que le pasamos por la descripción
     */
    public Item getItem(String description){
        Item item = null;
        int index=0;
        boolean found= false;
        while(index<items.size() && !found){
            Item itemDesc = items.get(index);
            if (itemDesc.getItemName().equals(description)){
                item= itemDesc;
                found = true;
            }else{
                index++;
            }     
        }
        return item;
    }

    /**
     * Elimina un item de la habitación
     */
    public void removeItem(Item itemToRemove){
        int index=0;
        boolean found = false;
        while (index<items.size() && !found){
            if (items.get(index)==itemToRemove){
                items.remove(itemToRemove);
                found = true;
            }else{
                index ++;
            }
        }
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

    /**
     * Return a long description of this room, of the form:
     *     You are in the 'name of room'
     *     Exits: north west southwest
     * @return A description of the room, including exits.
     */
    public String getLongDescription(){

        String longDescription = "You are in the " + getDescription() + "\n" + getExitString()+ "\n" 
            + getItemsInfo();
        return longDescription;
    }
}
