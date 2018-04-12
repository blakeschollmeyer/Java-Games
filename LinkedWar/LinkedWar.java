//Name: Blake Schollmeyer
//Username: bas76530
//700no: 700517653
//Assignment Number: a6
//Folder Name: LinkedWar
//Due: 3/15/16

import java.util.Scanner;

public class LinkedWar {

    public static final Scanner INPUT = new Scanner(System.in);

    private Queue<Card> hand1;

    private Queue<Card> hand2;

    private int round = 0;

    /*deal all the cards out to the players*/
    public LinkedWar() {
        hand1 = new LinkedQueue<Card>();
        hand2 = new LinkedQueue<Card>();
        Deck deck = new Deck();
        while (!(deck.isEmpty())) {
            hand1.add(deck.deal());

            hand2.add(deck.deal());
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to War.");
        LinkedWar game = new LinkedWar();
        game.play();
    }

    public void play() {
        while (!(hand1.isEmpty() || hand2.isEmpty())) {

            round++;

			System.out.println("\n****************************************");
            System.out.print("\nHit return to play round: ");
            INPUT.nextLine();
            playRound();


			System.out.print("Player 1 has " + hand1.size());
            System.out.print("\nPlayer 2 has " + hand2.size());

            if (hand1.isEmpty()) {
                System.out.println("Player 2 wins !");
            }
            if (hand2.isEmpty()) {
                System.out.println("Player 1 wins !");
            }

        }
    }

    public void playRound() {

        System.out.print("Round = " + round + "\n");

        Queue<Card> queue1 = new LinkedQueue<Card>();
        Queue<Card> queue2 = new LinkedQueue<Card>();
        queue1.add(hand1.remove());
        queue2.add(hand2.remove());
        do {
            Card card1 = queue1.peek();
            Card card2 = queue2.peek();
            System.out.println(card1 + " " + card2);
            Queue<Card> winner = null;
            if (card1.getRank() > card2.getRank()) {
                winner = hand1;
            }
            if (card1.getRank() < card2.getRank()) {
                winner = hand2;
            }
            if (winner != null) {
                give(queue1, queue2, winner);
                return;
            }

        } while (!settledByWar(queue1, queue2));
    }

    public boolean settledByWar(Queue queue1, Queue queue2) {
        System.out.println("War!");
        for (int i = 0; i < 4; i++) {
            if (hand1.isEmpty()) {
                give(queue1, queue2, hand2);
                return true;
            }
            queue1.add(hand1.remove());

            if (hand2.isEmpty()) {
                give(queue1, queue2, hand1);
                return true;
            }
            queue2.add(hand2.remove());
        }
        return false;
    }

    public void give(Queue<Card> queue1, Queue<Card> queue2, Queue<Card> winner) {

        if (winner == hand1) {
            System.out.println("Player 1 gets the cards");

        } else {
            System.out.println("Player 2 gets the cards");
        }

        while (!(queue1.isEmpty())) {
            winner.add(queue1.remove());
            }
        while (!(queue2.isEmpty())) {
            winner.add(queue2.remove());
            }

        }
 }
