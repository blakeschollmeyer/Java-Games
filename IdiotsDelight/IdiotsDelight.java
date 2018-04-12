//Name: Blake Schollmeyer
//UserId: bas76530
//700no: 700517653
//Assignment Number: a4
//Folder Name: IdiotsDelight

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.*;

/** The solitaire card game Idiot's Delight. */
public class IdiotsDelight {

  /** For reading from the console. */
  public static final Scanner INPUT = new Scanner(System.in);

  /** The four stacks of Cards. */
  private Stack<Card>[] stacks;

  /** The Deck of Cards. */
  private Deck deck;

  /** Create and shuffle the Deck.  Deal one Card to each Stack. */
  public IdiotsDelight() {
    deck = new Deck();
    deck.shuffle();
    stacks = new Stack[4]; // This causes a compiler warning
    for (int i = 0; i < 4; i++) {
      stacks[i] = new ArrayStack<Card>();
    }
    try {
      deal();
    } catch (IllegalMoveException e) {
		System.out.println("No cards left to deal.");
    }
  }

  /**
   * Deal one Card from the Deck onto each Stack.
   * @throws IllegalMoveException if the Deck is empty.
   */
  public void deal() throws IllegalMoveException {
    if (deck.isEmpty()) {
      throw new IllegalMoveException();
    }
    for (Stack<Card> s : stacks) {
      s.push(deck.deal());
    }
  }

  /** Play the game. */
  public void play() {
    while (true) {
      try {
        // Print game state
        System.out.println("\n" + this);
        // Check for victory
        boolean done = true;
        for (Stack<Card> s : stacks) {
          if (!(s.isEmpty())) {
            done = false;
            break;
          }
        }
        if (done) {
          System.out.println("You win!");
          return;
        }
        // Get command
        System.out.print("Your command (pair, suit, deal, move, or quit)? ");
        String command = INPUT.nextLine();
        // Handle command
        if (command.equals("pair")) {
          removePair();
        } else if (command.equals("suit")) {
          removeLowCard();
        } else if (command.equals("deal")) {
          deal();
	 } else if (command.equals("move")) {
		  moveCard();
        } else if (command.equals("quit")){
		System.exit(0);
	}else {command.equals("pair");
        }
      } catch (IllegalMoveException e) {
        System.out.println("I'm sorry, that's a legal move.");
      } catch (InputMismatchException e) {
		System.out.println("I'm sorry, please enter an integer");
		INPUT.nextLine();
	  } catch (ArrayIndexOutOfBoundsException e) {
		System.out.println("I'm sorry, you entered an incorrect number");
		INPUT.nextLine();
	  } catch (SameStackException e) {
		System.out.println("I'm sorry, That is an illegal move");
	  } catch (EmptyStructureException e) {
		System.out.println("I'm sorry. thats illegal");
	}
    }
  }

  /**
   * Remove the lower of two Cards of the same suit, as specified by
   * the user.
   * @throws IllegalMoveException if the low card is not of the same
   * suit as, and of lower rank than, the high card.
   */
  public void removeLowCard() throws IllegalMoveException, InputMismatchException, ArrayIndexOutOfBoundsException, SameStackException {
    System.out.print("Location (1-4) of low card? ");
    int i = INPUT.nextInt();
    Card lowCard = stacks[i - 1].peek();
    System.out.print("Location (1-4) of high card? ");
    int j = INPUT.nextInt();
    INPUT.nextLine();// To clear out input
    Card highCard = stacks[j - 1].peek();
    if (i==j) throw new SameStackException();
    if ((lowCard.getSuit() != highCard.getSuit())
        || ( lowCard.getRank() > highCard.getRank())) {
      throw new IllegalMoveException();
    }
    stacks[i - 1].pop();
  }

  /**
   * Remove two Cards of the same rank, as specified by the user.
   * @throws IllegalMoveException if the cards are not of the same
   * rank.
   */
  public void removePair() throws IllegalMoveException, InputMismatchException, ArrayIndexOutOfBoundsException, SameStackException {
    System.out.print("Location (1-4) of first card of pair? ");
    int i = INPUT.nextInt();
    Card card1 = stacks[i - 1].peek();
    System.out.print("Location (1-4) of second card of pair? ");
    int j = INPUT.nextInt();
    INPUT.nextLine(); // To clear out input
    Card card2 = stacks[j - 1].peek();
    if (i==j) throw new SameStackException();
	if (!(card1.equals(card2))) {
      throw new IllegalMoveException();
    }
    stacks[i - 1].pop();
    stacks[j - 1].pop();
  }

  public void moveCard() throws IllegalMoveException, InputMismatchException, ArrayIndexOutOfBoundsException, SameStackException {
    System.out.print("Location (1-4) of card to be moved? ");
    int i = INPUT.nextInt();
    Card moveCard = stacks[i - 1].peek();
    System.out.print("Location (1-4) of place to put card? ");
    int j = INPUT.nextInt();
    INPUT.nextLine();// To clear out input
    if (!(stacks[j-1].isEmpty())) throw new IllegalMoveException();
    if (i==j) throw new SameStackException();
    stacks[i - 1].pop();
    stacks[j-1].push(moveCard);
  }


  public String toString() {
	int stackSum = 0;
    String result = "";
    System.out.println("\n--------------------------------------------------\n");
    for(int x = 0;x < 4;x++){
		stackSum += stacks[x].getSize();
	}
    System.out.println("Score: " + (52 - (deck.size() + stackSum)));
    result += "Stack Size:    ";
    for (int i = 0; i < 4; i++)
		if( stacks[i].getSize()>9) {
			result += stacks[i].getSize() + " ";
		} else {
        result += stacks[i].getSize() + "  ";
	}
	result += "\n";

    result += "Top of Stack:  ";
    for (int i = 0; i < 4; i++) {
      if (stacks[i].isEmpty()) {
        result += "-- ";
      } else {
        result += stacks[i].peek() + " ";
      }
    }
    result += "\n";
    result += "Stack Number:  1  2  3  4";
    return result + "\n" + deck.size() + " cards left in the deck";
  }

  /** Create and play the game. */
  public static void main(String[] args) {
    System.out.println("Welcome to Idiot's Delight.");
    IdiotsDelight game = new IdiotsDelight();
    game.play();
  }

}
