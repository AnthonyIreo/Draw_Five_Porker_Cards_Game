public class Card{
    private String value;
    private String suit;
    
    public Card( String theValue, String theSuit ){
        value = theValue;
        suit = theSuit;
    }
    
    public String getValue(){
        return value;
    }
    
    public String getSuit(){
        return suit;
    }
    
    public String toString(){
        return "[" + value + suit + "]";
    }
}
