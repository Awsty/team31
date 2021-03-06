package models;

import org.junit.Test;

import java.util.Arrays;
import java.util.ArrayList;


import static org.junit.Assert.*;

public class testGame {

    @Test
    public void testGameCreation(){
        Game g = new Game();
        assertNotNull(g);
    }

    @Test
    public void testGameBuildDeck(){
        Game g = new Game();
        g.deck = new Deck();
        assertEquals(52,g.deck.cards.size());
    }

    @Test
    public void testGameShuffle(){
        Game g1 = new Game();
        g1.deck = new Deck();
        g1.deck.shuffle();
        Game g2 = new Game();
        g2.deck = new Deck();
        g2.deck.shuffle();
        // g1 and g2 could shuffle to the same order, but that chance is approximately 1 in 8*10^67 shuffles
        assertFalse(Arrays.equals(g1.deck.cards.toArray(),g2.deck.cards.toArray()));
    }

    @Test
    public void testGameStart(){
        Game g = new Game();
        g.deck = new Deck();
        g.deck.shuffle();
        g.dealFour();
        assertEquals(1,g.columns.get(0).cards.size());
        assertEquals(1,g.columns.get(1).cards.size());
        assertEquals(1,g.columns.get(2).cards.size());
        assertEquals(1,g.columns.get(3).cards.size());
    }

    @Test
    public void testCustomDeal(){
        Game g = new Game();
        g.deck = new Deck();
        ArrayList<Card> list = new ArrayList<Card>();
        list.add(new Card(0, Suit.Hearts));
        list.add(new Card(3, Suit.Hearts));
        list.add(new Card(6, Suit.Hearts));
        list.add(new Card(9, Suit.Hearts));
        g.customDeal(list);
        assertEquals("0Hearts",g.columns.get(0).cards.get(0).toString());
        assertEquals("3Hearts",g.columns.get(1).cards.get(0).toString());
        assertEquals("6Hearts",g.columns.get(2).cards.get(0).toString());
        assertEquals("9Hearts",g.columns.get(3).cards.get(0).toString());
    }

    @Test
    public void testRemoveFunction(){
        Game g = new Game();
        g.deck = new Deck();
        ArrayList<Card> list = new ArrayList<Card>();
        g.customDeal(list);
        g.remove(1);
        assertEquals(0,g.columns.get(1).cards.size());
    }


    @Test
    public void testColumnHasCards(){
        Game g = new Game();
        g.deck = new Deck();
        g.dealFour();
        assertEquals(false, g.isColumnEmpty(0));
        assertEquals(false, g.isColumnEmpty(1));
        assertEquals(false, g.isColumnEmpty(2));
        assertEquals(false, g.isColumnEmpty(3));
    }

    @Test
    public void testIsColumnEmpty(){
        Game g = new Game();
        g.deck = new Deck();
        g.dealFour();
        assertEquals(false, g.isColumnEmpty(0));
        assertEquals(false, g.isColumnEmpty(1));
        assertEquals(false, g.isColumnEmpty(2));
        assertEquals(false, g.isColumnEmpty(3));
    }



}
