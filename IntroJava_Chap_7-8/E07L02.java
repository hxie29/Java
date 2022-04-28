// creating a deck of cards
public class E07L02 {
    public static void main(String [] args) {

        // creating 3 arrays, one for cards, two other for annotating the cards.
        int[] deck = new int[52];
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        // initiating deck
        for (int i =0; i < deck.length; i++) {
            deck[i] = i;
        }

        // shuffle the deck, be careful not to have the same number twice in the deck!
        for (int i = 0; i < deck.length; i++) {
            int j = (int)(Math.random() * deck.length);
            deck [i] = deck [j];
        }

        // draw four cards on the top and display result
        for (int i = 0; i < 4; i++) {
            String suit = suits[deck [i] / 13 - 1];
            String rank = ranks[deck [i] % 13];
            System.out.println("The card you draw is " + rank + " of " + suit);
        }
    }   
}
