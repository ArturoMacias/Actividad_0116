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
    //peso m�ximo que puede llevar el jugador
    private int maxWeight;
    //nivel de vida
    private int lifeLevel;
    private static final int MAX_WEIGHT_DEFAULT = 4;
    private static final int LIFE_DEFAULT = 10;
    
    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        previousRooms = new Stack<>();
        playerItems = new ArrayList<>();
        maxWeight = MAX_WEIGHT_DEFAULT;
        lifeLevel = LIFE_DEFAULT;
    }
    public void setCurrentRoom(Room newRoom){
        currentRoom=newRoom;
    }
    
    public void eat(){
        System.out.println("You have eaten now and you are not hungry any more");
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
            System.out.println("You haven't moved yet, you can�t go back");
        }
        else{
            currentRoom = previousRooms.pop();
        }
        printLocationInfo();
        System.out.println();
    }
    
    /**
     * Take a Item from the current room,
     * Return 'true' if the game finishes
     */
    public boolean takeItem(Command command){
            
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what to take...
            System.out.println("take what?");
           return false;
        }
        //indica si el juego termina. Fijarse que ahora takeItem devuelve boolean   
        boolean finished = false;
        String itemName = command.getSecondWord();
        //En un principio pens� en recorrer desde aqu� el ArrayList de la clase Room, pero era privado, por lo
        //que se me ocurri� hacerle un get para devolverlo.OJOOO, No ser�a correcto porque para eso es privado.
        //Por ello la soluci�n m�s coherente es crear un m�todo en la clase Room, que devuelva el item con ese nombre
        Item item = currentRoom.getItem(itemName);
        if(item == null){
            System.out.println("The item " + itemName +" doesn�t exist");
            return false;
        }
        if (!item.getTaken()){
            System.out.println("This item can�t be taken");
        }else if(item.getWeight() + totalWeight() >= maxWeight){
            System.out.println("You can�t take this item, it's too heavy");
        }
        else if(item.getMagic()){
            System.out.println("Hey!! you have found the magic item, you have won!!");
            finished = true;
        }
        else if((lifeLevel + item.getAffection()<=0)){
            System.out.println("You lost your life..-Try Again");
            finished = true;
        }
        else{
            lifeLevel += item.getAffection();
            if (item.getHarmful()){
                System.out.println("Hey, take care about what you touch, you have taken a dangerous "+ item.getItemName());
            }else{
                System.out.println("Umm, you are a lucky person," +item.getItemName() + 
                " has increased your life in "+ item.getAffection()+" points");
            }
            System.out.println("Now you have a "+lifeLevel +" of life");
             //A�ade al ArrayList el item que cogemos
            playerItems.add(item);
            //Llama al m�todo creado en Room para eliminar
            currentRoom.removeItem(item);
            System.out.println("Hey, now you have a marvellous " + item.getItemName() +" with you"); 
        }
        return finished;
    }
    
    /**
     * Leave an item in the currentRoom
     */
    public void dropItem(Command command){
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what to drop...
            System.out.println("drop what?");
            return;
        }

        String itemName = command.getSecondWord();
    
        int index = 0;
        boolean found = false;
        while (index<playerItems.size() && !found){
            Item itemDesc = playerItems.get(index);
            if (itemDesc.getItemName().equals(itemName)){
                playerItems.remove(itemDesc);
                currentRoom.addItem(itemDesc);
                found = true;
            }else{
                index++;
            }
        }
        if(found == false){
            System.out.println("Hey, you don�t have a great " + itemName+ " with you");
        }
    }
    /**
     * Print player's list of items
     */
  
    public void showItems(){
        String listOfItems = "";
        if(playerItems.size()>0){
          listOfItems = "You have these items with you: ";
            for(Item item:playerItems){
            listOfItems += item.getItemName() +"// ";
          }  
        }else{
            listOfItems = "You haven't got any items yet.";
        }
        System.out.println(listOfItems);
    }

    public void printLocationInfo(){
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Devuelve el peso total de lo que lleva el jugador
     * OJO!!!!!! ver que hago un if para comprobar si hay alg�n item en el ArrayList que lleva el jugador. Realmente 
     * no har�a falta. Si se pone el bucle for, y no hay nada en el ArrayList, pues directamente no har�a nada, y el peso total
     * ser�a cero
     */
    public int totalWeight(){
        int totalWeight = 0;
        if (playerItems.size()>0){
            for(Item item: playerItems){
                totalWeight += item.getWeight();
            }
        }
        return totalWeight;
    }  
    
    public int getLifeLevel(){
        return lifeLevel;
    }
}
