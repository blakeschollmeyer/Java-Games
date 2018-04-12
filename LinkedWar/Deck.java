//Name: Blake Schollmeyer
//Username: bas76530
//700no: 700517653
//Assignment Number: a6
//Folder Name: LinkedWar
//Due: 3/15/16

import java.io.*;
import java.util.Scanner;

public class Deck {

    private Card[] cards;

    private int size;

    // Create all 52 cards, in order.
    public Deck() {

        try {
            File cardFile = new File("Cards");
            Scanner input = new Scanner(cardFile);

            cards = new Card[52];
            size = 0;
            char r, s;
            int rank = 0;
            int suit = 0;

            size = 52;
            for (int i = 0; i < 52; i++) {
                String str = input.nextLine();
                r = str.charAt(0);
                s = str.charAt(1);
                rank = "--23456789TJQKA".indexOf(r);
                suit = "shdc".indexOf(s);
                cards[i] = new Card(rank, suit);
            }
        } catch (FileNotFoundException e) {
            System.out.print("");
            //return 0;
        }

    } // end method deck

    // Return true if the deck contains no cards.
    public boolean isEmpty() {
        return size == 0;
    } // end isEmpty()

    // Gives the  number of cards currently in the deck.
    public int size() {
        return size;
    }

    // Remove one card from the deck and return it.
    public Card deal() {
        size--;
        return cards[size];
    }

/*    // Shuffles the deck.
    public void shuffle() {
        for (int i = size - 1; i > 0; i--) {
            swap(i, (int) (Math.random() * (i + 1)));
        }
    }*/

    // Swap the cards at indices i and j.
    protected void swap(int i, int j) {
        Card temp = cards[i];
        cards[i] = cards[j];
        cards[j] = temp;
    }

}
