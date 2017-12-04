package models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.*;

public class testDeck {

    @Test
    public void testBuildDeck(){
        Deck ad = new Deck();
        assertEquals(52,ad.cards.size());

        Deck sd = new SpanishDeck();
        assertEquals(50,sd.cards.size());
    }

    @Test
    public void testShuffle(){
        Deck ad1 = new Deck();
        Deck ad2 = new Deck();
        assertFalse(Arrays.equals(ad1.cards.toArray(), ad2.cards.toArray()));
        SpanishDeck sd1 = new SpanishDeck();
        SpanishDeck sd2 = new SpanishDeck();
        assertFalse(Arrays.equals(sd1.cards.toArray(), sd2.cards.toArray()));
    }

    @Test
    public void testDealFour() {
        Game g = new Game();
        g.deck.buildDeck();
        for (int i = 0; i < 52; i++) {
            g.deck.dealFour();
        }
        assertEquals(0, g.deck.cards.size());
    }
}
