
package Game;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Annie Mann
 * @author Partap Singh 
 * @author Amanpreet Singh
 * @author Naman Khurana
 * @author Swati Sharma
 * @author Ajay Bookal
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple card game where the goal is to draw the highest card from a shuffled deck.
 */
public class Game {

    private final List<Card> deck;

    /**
     * Creates a new Game object with a shuffled deck of 52 standard playing cards.
     */
    public Game() {
        deck = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                deck.add(new Card(rank, suit));
            }
        }
        Collections.shuffle(deck);
    }

    /**
     * Draws the top card from the deck and removes it from the deck.
     *
     * @return the Card object representing the top card of the deck.
     * @throws IllegalStateException if the deck is empty.
     */
    public Card draw() {
        if (deck.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return deck.remove(0);
    }

    /**
     * Returns the number of cards remaining in the deck.
     *
     * @return the number of cards remaining in the deck.
     */
    public int deckSize() {
        return deck.size();
    }

    /**
     * Plays a game of cards where each player draws one card and the player with the highest card wins.
     * In case of a tie, the game is a draw.
     *
     * @param numPlayers the number of players in the game.
     * @return the index of the winning player (1-indexed), or 0 for a draw.
     * @throws IllegalArgumentException if numPlayers is less than 2.
     */
    public int play(int numPlayers) {
        if (numPlayers < 2) {
            throw new IllegalArgumentException("Must have at least 2 players");
        }

        int winningPlayer = 0;
        int highestRank = -1;
        for (int i = 0; i < numPlayers; i++) {
            Card card = draw();
            if (card.getRank().getValue() > highestRank) {
                highestRank = card.getRank().getValue();
                winningPlayer = i + 1;
            } else if (card.getRank().getValue() == highestRank) {
                winningPlayer = 0;
            }
        }
        return winningPlayer;
    }


    /**
     * Test of draw method, of class Game.
     */
  
    public void testDraw() {
        System.out.println("draw");
        Card expResult = null;
        Card result = Game.draw();
        assertEquals(expResult, result);
    }

    /**
     * Test of deckSize method, of class Game.
     */
    
    public void testDeckSize() {
        System.out.println("deckSize");
        int expResult = 0;
        int result = Game.deckSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Game.
     */
    
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Game.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private void fail(String the_test_case_is_a_prototype) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertEquals(int expResult, int result) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertEquals(Card expResult, Card result) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
