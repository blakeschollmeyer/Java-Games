//Name: Blake Schollmeyer
//UserId: bas76530
//700no: 700517653
//Assignment Number: a4
//Folder Name: IdiotsDelight

// A playing card.
public class Card {

	// Spades
	public static final int SPADES = 0;

	// Hearts
	public static final int HEARTS = 1;

	// Diamonds
	public static final int DIAMONDS = 2;

	// Clubs
	public static final int CLUBS = 3;

	public static final int TWO = 2;

	// Rank of Ace
	public static final int ACE = 14;

	// Rank of Jack
	public static final int JACK = 11;

	// Rank of Queen
	public static final int QUEEN = 12;

	// Rank of King
	public static final int KING = 13;

	// Number or face of this card.
	private int rank;

	// Suit of this card.
	private int suit;

	// Initialize the rank and suit.
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}

	// Return true if and only if that card has the same rank as this one.  Suit is ignored.
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

		Card thatCard = (Card)that;
		return rank == thatCard.rank;
	}

	// Return the rank of this card.
	public int getRank() {
		return rank;
	}

	//Return the suit of this card.
	public int getSuit() {
		return suit;
	}

	public String toString() {
		return "" + "--23456789TJQKA".charAt(rank) + "shdc".charAt(suit);
	}
}