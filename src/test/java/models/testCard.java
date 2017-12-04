package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testCard {
    @Test
    public void testGetSuit(){
        Card c = new Card(5,Suit.Clubs);
        assertEquals(Suit.Clubs,c.getSuit());
    }

    @Test
    public void testToString(){
        Card c = new Card(5,Suit.Clubs);
        assertEquals("5Clubs",c.toString());

        Card c1 = new Card(12,Suit.Hearts);
        assertEquals("12Hearts",c1.toString());

        Card c2 = new Card(13,Suit.Spades);
        assertEquals("13Spades",c2.toString());

        Card c3 = new Card(14,Suit.Diamonds);
        assertEquals("14Diamonds",c3.toString());

        Card c4 = new Card(5,Suit.Oros);
        assertEquals("5Oros",c4.toString());

        Card c5 = new Card(5,Suit.Copas);
        assertEquals("5Copas",c5.toString());

        Card c6 = new Card(5,Suit.Espadas);
        assertEquals("5Espadas",c6.toString());

        Card c7 = new Card(0,Suit.Comodines);
        assertEquals("0Comodines",c7.toString());

    }

    @Test
    public void testMoveCard(){
        Game g = new Game();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertEquals(0,g.columns.get(2).cards.size());
        g.move(0,2);
        assertEquals(1,g.columns.get(2).cards.size());
        assertEquals(0,g.columns.get(0).cards.size());
    }


}
