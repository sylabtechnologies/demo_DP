package playcards;
import java.util.Arrays;

public class FaroShuffle
{
    public static void main(String[] args)
    {
        Card[] deck = new Card[52];
        String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        int deckSize = faces.length * suits.length;
        
        for (int i = 0; i < deckSize; i++)
            deck[i] = new Card(faces[i % faces.length], suits[i / faces.length]);
        
        Card topCard = deck[0];
        Card botCard = deck[51];

        int count = 0;
        boolean first = false, second = false, third = false;
        while ( !(first && second && third) )
        {
            inShuffle(deck);
            count++;
            
            if (count == 7)
            {
                first = true;
                System.out.println("top is " + deck[0]);
            }
            
            if (!second)
            {
                if (deck[51] == topCard)
                {
                    second = true;
                    System.out.println("we did it @" + count);
                }
            }
            
            if (!third)
            {
                for (int i = 0; i < deck.length; i++)
                {
                    if (deck[i] == topCard)
                    {
                        if (i > 0 && deck[i - 1] == botCard)
                        {
                            System.out.println("we did touchdown @" + count);
                            third = true;
                        }
                        else if (i < deck.length - 1 && deck[i + 1] == botCard)
                        {
                            System.out.println("we did touchdown @" + count);
                            third = true;
                        }
                            
                    }
                }
            }
        }
    }

    // https://en.wikipedia.org/wiki/Faro_shuffle
    private static void inShuffle(Card[] deck)
    {
        int len = deck.length / 2;
        Card[] upHalf = Arrays.copyOf(deck, len);
        Card[] loHalf = Arrays.copyOfRange(deck, len, 2*len);
        
        int currPos = 0;
        for (int i = 0; i < len; i++)
        {
            deck[currPos++] = loHalf[i];
            deck[currPos++] = upHalf[i];
        }
    }
}

class Card 
{
   private String face, suit;
   public Card( String cardFace, String cardSuit) { face = cardFace; suit = cardSuit; }
   public String toString() { return face + " of " + suit; }
} 
