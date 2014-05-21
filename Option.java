
/**
 * Enumeration class Option - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Option
{   

    //Hay que poner antes la lista de todos los valores, si no, no compila. Ya después atributo y constructor
    GO("ir"),

    QUIT("salir"), 

    HELP("ayuda"), 

    LOOK("mirar"), 

    EAT("comer"), 

    BACK("volver"), 

    TAKE("coger"),  

    DROP("dejar"), 

    ITEMS("objetos"), 

    UNKNOWN("");

    private String optionString;

    Option (String optionString){
        this.optionString = optionString;
    }

    public String getOptionString(){
        return optionString;
    }
}