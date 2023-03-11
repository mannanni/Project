
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
public class Game {

    private static Card draw() {
        
        return null;
        
    }

    private static int deckSize() {
        
        return 0;
        
    }

    private static void main(String[] args) {
    }
    
    public Game() {
    }


    public void setUp() throws Exception {
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