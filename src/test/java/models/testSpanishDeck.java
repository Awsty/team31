package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testSpanishDeck {
    @Test
    public void testBuildDeck(){
        SpanishDeck sd = new SpanishDeck();

        assertEquals(50,sd.cards.size());
    }
}
