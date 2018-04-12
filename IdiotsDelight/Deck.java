//Name: Blake Schollmeyer
//UserId: bas76530
//700no: 700517653
//Assignment Number: a4
//Folder Name: IdiotsDelight

// Standard deck of 52 playing cards.
public class Deck {

	// The cards in this deck.
	private Card[] cards;

	// Number of cards currently in this deck.
	private int size;

	// Create all 52 cards, in order.
	public Deck() {
		cards = new Card[52];
		size = 0;
		for (int suit = Card.SPADES; suit <= Card.CLUBS; suit++) {
			for (int rank = Card.TWO; rank <= Card.ACE; rank++) {
				cards[size] = new Card(rank, suit);
				size += 1;
			}
		}
	}

	// Remove one card from the deck and return it.
	public Card deal() {
		size--;
		return cards[size];
	}

	// Return true if the deck contains no cards.
	public boolean isEmpty() {
		return size == 0;
	}

	// Randomly rearrange the cards in the deck.
	public void shuffle() {
		for (int i = size - 1; i > 0; i--) {
			swap(i, (int)(Math.random() * (i + 1)));
		}
	}

	// Return the number of cards currently in the deck.
	public int size() {
		return size;
	}

	// Swap the cards at indices i and j.
	protected void swap(int i, int j) {
		Card temp = cards[i];
		cards[i] = cards[j];
		cards[j] = temp;
	}
}