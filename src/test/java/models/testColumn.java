package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testColumn {
    @Test
    public void testColumns(){
        SpanishDeck sd = new SpanishDeck();
        assertEquals(50,sd.cards.size());
    }
}
