package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testColumn {
    @Test
    public void testColumns(){
	int id=0;
        SpanishDeck sd = new SpanishDeck();
        assertEquals(50,sd.cards.size());
    }
}
