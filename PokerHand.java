import java.util.ArrayList;
import java.util.HashMap;

public class PokerHand{
    private ArrayList<Card> hands;
    
    public PokerHand(){
        hands = new ArrayList<Card>();
    }
    
    // draw nubmer of cards
    public void draw( ArrayList<Card> cards ){
        for ( Card card : cards ){
            hands.add( card );
        }
    }
    
    // remove cards from hands
    public ArrayList<Card> removeCards( ArrayList<Integer> cardsToRemove ){
        ArrayList<Card> cardsToDeck = new ArrayList<Card>();
        
        // temp array to store hands 
        Card[] temp = new Card[5];
        
        // temp to record the index of cards to remove 
        for ( int i = 0; i < hands.size(); i++ ){
            temp[ i ] = hands.get(i);
        }
        
        // add the cards to remove list 
        for ( Integer i : cardsToRemove ){
            cardsToDeck.add( temp[ i-1 ] );
            temp[ i-1 ] = null;
        }
        
        // update the hands depends on the temp
        hands.clear();
        for ( int i = 0; i < temp.length; i++ ){
            if ( temp[i] != null ){
                hands.add( temp[i] );
            }
        }
        
        return cardsToDeck;
    }
    
    // calc the score 
    public int getScore(){
        int score = 0;
        
        // array used to count pairs, three of a kind, straight, full house, four of a kind.
        int[] arr = new int[13];
        // add cards into array 
        for ( Card card : hands ){
            if ( card.getValue().equals( "1" )) arr[0]++;
            else if ( card.getValue().equals( "2" )) arr[1]++;
            else if ( card.getValue().equals( "3" )) arr[2]++;
            else if ( card.getValue().equals( "4" )) arr[3]++;
            else if ( card.getValue().equals( "5" )) arr[4]++;
            else if ( card.getValue().equals( "6" )) arr[5]++;
            else if ( card.getValue().equals( "7" )) arr[6]++;
            else if ( card.getValue().equals( "8" )) arr[7]++;
            else if ( card.getValue().equals( "9" )) arr[8]++;
            else if ( card.getValue().equals( "10" )) arr[9]++;
            else if ( card.getValue().equals( "J" )) arr[10]++;
            else if ( card.getValue().equals( "Q" )) arr[11]++;
            else if ( card.getValue().equals( "K" )) arr[12]++;
        }
        // check pair, three of a kind, four of a kind and full house
        int fullHouse1 = 0;
        int fullHouse2 = 0;
        for ( int i : arr ){
            
            if ( i > 1){
                if ( i == 2 ) fullHouse2++;
                else if ( i > 2){
                    if ( i > 3){
                        score++;
                    }
                    fullHouse1++;
                    score++;
                }
                score++;
            }
        }// end for loop
        if ( fullHouse1 == 1 && fullHouse2 == 1 )   score++;
        // check straight
        int ifStraight = 0;
        for ( int i = 0; i < 13; i++ ){
            if ( arr[i] > 0 ){
                ifStraight++;
                if ( ifStraight == 5 ){
                    score++;
                    break;
                }
            }
            else{
                ifStraight = 0;
            }
        } // end for loop 
        
        // count flush, straight flush
        int[] arr2 = new int[4];
        for ( Card card : hands ){
            if ( card.getSuit().equals("♦") ) arr[0]++;
            else if ( card.getSuit().equals("♣") ) arr[1]++;
            else if ( card.getSuit().equals("♥") ) arr[2]++;
            else if ( card.getSuit().equals("♠") ) arr[3]++;
        }
        // check flush and straight flush
        for ( int i : arr2 ){
            if ( i == 5 ){
                if ( ifStraight == 5 ){
                    score++;
                }
                score++;
                break;
            }
        }
        
        return score;
    }
    
    public String toString(){
        // System.out.println("┌─────────┐"); 
        // System.out.println("│         │"); 
        // System.out.println("│         │"); 
        // System.out.println("│         │"); 
        // System.out.println("└─────────┘"); 
        
        String s = "┌─────────┐\t┌─────────┐\t┌─────────┐\t┌─────────┐\t┌─────────┐\n";
        for ( Card card : hands ){
            if ( card.getValue().equals("10") ){
                s += "│ " + card.getValue() + "    " + card.getSuit() + " │\t";
            }
            else{
                s += "│ " + card.getValue() + "     " + card.getSuit() + " │\t";
            }
        }
        for ( int i = 0; i < 2; i++ ){
            s += "\n│         │\t│         │\t│         │\t│         │\t│         │\t";
        }
        s += "\n└─────────┘\t└─────────┘\t└─────────┘\t└─────────┘\t└─────────┘";
        return s;
    }
}
