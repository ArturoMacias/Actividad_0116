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

    /**
     * Constructor for objects of class Item
     */
    public Item(String itemName, int weight)
    {
        this.itemName = itemName;
        this.weight = weight;
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
}
