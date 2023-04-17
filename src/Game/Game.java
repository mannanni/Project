
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A simple card game where the goal is to draw the highest card from a shuffled deck.
 */
public class Game {

    private static void main(String[] args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private final List<Card> deck;
    private Object Assertions;

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
    
   /**
     * Test of draw method, of class Game.
     */
    public void testDraw() {
        int initialDeckSize = game.deckSize();
        Card drawnCard = game.draw();
        Assertions.assertNotNull(drawnCard);
        Assertions.assertEquals(initialDeckSize - 1, game.deckSize());
    }

   /**
     * Test of DrawFromEmptyDeck method, of class Game.
     */
    public void testDrawFromEmptyDeck() {
        Game game = new Game();
        for (int i = 0; i < 52; i++) {
            game.draw();
        }
        Assertions.assertThrows(IllegalStateException.class, game::draw);
    }

    /**
     * Test of DeckSize method, of class Game.
     */
    public void testDeckSize() {
        Game game = new Game();
        Assertions.assertEquals(52, game.deckSize());
        for (int i = 0; i < 10; i++) {
            game.draw();
        }
        Assertions.assertEquals(42, game.deckSize());
    }

    /**
     * Test of Play method, of class Game.
     */
    public void testPlay() {
        int numPlayers = 4;
        int winningPlayer = game.play(numPlayers);
        Assertions.assertTrue(winningPlayer >= 0 && winningPlayer <= numPlayers, "winning player index is out of range");
    }

    /**
     * Test of PlayWithTwoPlayers method, of class Game.
     */
    
    public void testPlayWithTwoPlayers() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> game.play(1));
        int winningPlayer = game.play(2);
        Assertions.assertTrue(winningPlayer == 1 || winningPlayer == 2 || winningPlayer == 0, "unexpected winning player index");
    }

   /**
     * Test of PlayWithFiftyPlayers method, of class Game.
     */
    public void testPlayWithFiftyPlayers() {
        int numPlayers = 50;
        int winningPlayer = game.play(numPlayers);
        Assertions.assertTrue(winningPlayer >= 0 && winningPlayer <= numPlayers, "winning player index is out of range");
    }

    /**
     * Test of PlayWithAllPlayers method, of class Game.
     */
    public void testPlayWithAllSameCards() {
        Set<Card> allSameCards = new HashSet<>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                allSameCards.add(new Card(rank, suit));
            }
        }
        Game game = new Game();
        game.deck.clear();
        game.deck.addAll(allSameCards);
        int winningPlayer = game.play(5);
        Assertions.assertEquals(0, winningPlayer, "all same cards but not a draw");
    }

    /**
     * Test of PlayWithAllDifferentCards method, of class Game.
     */
    
    public void testPlayWithAllDifferentCards() {
        Game game = new Game();
        game.deck.clear();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                game.deck.add(new Card(rank, suit));
            }
        }
        int winningPlayer = game.play(5);
        Assertions.assertNotEquals(0, winningPlayer, "all different cards but a draw");
    }

    private void assertEquals(Card expResult, Card result) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertEquals(int expResult, int result) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void fail(String the_test_case_is_a_prototype) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static class game {

        private static int deckSize() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static Card draw() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static int play(int numPlayers) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public game() {
        }
    }
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
