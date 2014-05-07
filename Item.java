/**
 * An Item in the Game.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    private String itemName;
    private int weight;
    //indica si el item puede ser llevado o no
    private boolean taken;

    /**
     * Constructor for objects of class Item
     */
    public Item(String itemName, int weight, boolean taken)
    {
        this.itemName = itemName;
        this.weight = weight;
        this.taken = taken;
    }

    /**
     * Returns the item's name
     */
    public String getItemName(){
        return itemName;
    }
    
    /**
     * Returns the item's weight
     */
    public int getWeight(){
        return weight;
    }
    /**
     * Returns 'true' if the item can be taken of 'false' if not
     */
    public boolean getTaken(){
        return taken;
    }
}   

