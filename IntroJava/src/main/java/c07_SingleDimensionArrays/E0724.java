package c07_SingleDimensionArrays;

// creating a deck of cards
public class E0724 {
    public static void main(String [] args) {

        // creating 3 arrays, one for cards, two other for annotating the cards.
        int[] deck = new int[52];
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        int[] suitsCount = new int[4];
        String[] ranks = {"Ace", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        // initiating deck
        for (int i =0; i < deck.length; i++) {
            deck[i] = i;
        }
        //shuffle(deck);

        // To get fours cards from each suit
        int pickTimes = 0;
        while (suitsCount[0] * suitsCount[1] * suitsCount[2] * suitsCount[3] == 0) {
            pickTimes++;
            int card = pickCards(deck);
            readCards(card, suits, ranks);
            assignSuit(card, suitsCount);
        }
        System.out.println("Number of picks: " + pickTimes);
    }

    // pick a card
    public static int pickCards(int[] deck) {
        return (int)(Math.random() * deck.length);
    }

    //read the card
    public static void readCards(int card, String[] suits, String[] ranks) {
        String suit = suits[card / 13];
        String rank = ranks[card % 13];
        System.out.println(rank + " of " + suit);
    }

    // Count the appearance of card's suit
    public static void assignSuit(int card, int[] suitsCount) {
        suitsCount[card / 13]++;
    }  
}
