import java.util.Scanner;
import java.util.ArrayList;

public class PokerGame
{
    public static void main(String[] args) {
        // clean up the table and set up the deck
        Deck deck = new Deck();
        // System.out.println(deck);
        // shuffle
        deck.shuffled( 10 ); 
        // System.out.println(deck);
        System.out.println("draw 5 cards:");
        
        // deck is ready, game starts ============================
        
        // define cards in player's hand 
        PokerHand hands = new PokerHand();
        // System.out.println("hands are: " + hands);
        // player draws 5 cards from the deck 
        hands.draw( deck.draw( 5 ) );
        // check hands
        System.out.println("Your hands are:\n" + hands);
        // System.out.println("deck:\n" + deck);
        System.out.println("\n\n");
        
        // first draw ============================================
        
        // instantiate a Scanner object to record input
        Scanner scan = new Scanner(System.in);
        // ask for cards to exchange
        System.out.println("Please enter the card you want to exchange:");
        System.out.println(hands);
        System.out.println("     1               2               3               4               5");
        System.out.println("\nPlease enter the cards in the following format:");
        System.out.println("\nIf you want to exchange the cards in position [ 1, 2, 5 ] as shown above, input 125.");
        System.out.println("If no card need to be exchanged, hit enter to contiue.");
        // record the input
        int exchangedCardsInt = scan.nextInt();
        ArrayList<Integer> exchangedCards = new ArrayList<Integer>();
        
        // put the position numbers into the array list 
        while ( exchangedCardsInt > 0 ){
            exchangedCards.add( exchangedCardsInt % 10 );
            exchangedCardsInt /= 10;
        }
        // remove the cards from hands, and add it into deck 
        deck.addCards( hands.removeCards( exchangedCards ) );
        hands.draw( deck.draw( exchangedCards.size() ) );
        System.out.println( "hands are:\n" + hands);

        // hand is ready, calc the score ==========================
        
        int score = hands.getScore();
        System.out.println("Your score is: " + score );
    }
}
