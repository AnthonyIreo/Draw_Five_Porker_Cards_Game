import java.util.ArrayList;

public class Deck{
    private ArrayList<Card> cards;
    private final String[] VALUES = new String[]{"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private final String[] SUITS = new String[]{"♦","♣","♥","♠"};
    
    public Deck(){
        // initialize the card deck 
        cards = new ArrayList<Card>();
        for ( String value : VALUES ){
            for ( String suit : SUITS ){
                cards.add( new Card( value, suit ) );
            }
        }
    } // end constructor
    
    // shuffle the cards
    public void shuffled( int times ){
        for ( int i = 0; i < times * 10; i++ ){
            int card1 = (int)(Math.random() * 52);
            int card2 = (int)(Math.random() * 52);
            // swap
            Card temp = cards.get( card1 );
            cards.set( card1, cards.get( card2 ) );
            cards.set( card2, temp );
        }
    }
    
    // draw some cards
    public ArrayList<Card> draw( int numberOfCard ){
        ArrayList<Card> newCards = new ArrayList<Card>();
        // draw
        for ( int i = 0; i < numberOfCard; i++){
            newCards.add( cards.remove( cards.size()-1 ) );
        }
        return newCards;
    }
    
    // add cards to the buttom
    public void addCards( ArrayList<Card> addCards ){
        for ( Card card : addCards ){
            cards.add( 0, card );
        }
    }
    
    public String toString(){
        String s = "";
        for ( Card card : cards ){
            s += card.getValue() + card.getSuit() + " ";
        }
        return s;
    }
}
