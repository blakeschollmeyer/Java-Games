//Name: Blake Schollmeyer
//Username: bas76530
//700no: 700517653
//Assignment Number: a6
//Folder Name: LinkedWar
//Due: 3/15/16

public class Card {

    /*Number or face of this card.*/
    private int rank;

    /*Suit of this card.*/
    private int suit;

    /*Initialize the rank and suit.*/
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /*Return the rank of this card.*/
    public int getRank() {
        return rank;
    }

    /*Set the rank of the card*/
    public void setRank(int x) {
        rank = x;
    }

    /*Return the suit of this card.*/
    public int getSuit() {
        return suit;
    }

    /*set suit of card*/
    public void setSuit(int x) {
        suit = x;
    }

    /*Return true if that card has the same rank as this one.*/
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }

        if (that == null) {
            return false;
        }

        if (getClass() != that.getClass()) {
            return false;
        }

        Card thatCard = (Card) that;
        return rank == thatCard.rank;
    }

    public String toString() {
        return "" + "--23456789TJQKA".charAt(rank) + "shdc".charAt(suit);
    }

    /* Spades*/
    public static final int SPADES = 0;

    // *Hearts*/
    public static final int HEARTS = 1;

    /* Diamonds*/
    public static final int DIAMONDS = 2;

    /* Clubs*/
    public static final int CLUBS = 3;

    public static final int TWO = 2;

    /* Rank of Ace*/
    public static final int ACE = 14;

    /* Rank of Jack*/
    public static final int JACK = 11;

    /* Rank of Queen*/
    public static final int QUEEN = 12;

    /* Rank of King*/
    public static final int KING = 13;

}
