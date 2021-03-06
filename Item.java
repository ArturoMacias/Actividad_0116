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
    //indica si el item es da�ino o no
    private boolean harmful;
    //indica si es el elemento que permite ganar la partida
    private boolean magic;
    //indica el grado en el que el elemento es da�ino o beneficioso
     private int affection;
    

    /**
     * Constructor for objects of class Item
     */
    public Item(String itemName, int weight, boolean taken, boolean harmful,boolean magic)
    {
        this.itemName = itemName;
        this.weight = weight;
        this.taken = taken;
        this.harmful=harmful;
        this.magic= magic;
        if(harmful){
            affection = -2;
        }else{
            affection = 1;
        }
        
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
    
    /**
     * Returns 'true' if the item is harmful
     */
    public boolean getHarmful(){
        return harmful;
    }
    
    /**
     * Returns 'true' if the item is the magic item
     */
     public boolean getMagic(){
        return magic;
        }
    /**
     * Returns the item's affection
     */
    public int getAffection(){
        return affection;
    }
    
}   

