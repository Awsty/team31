package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SpanishDeck extends Deck {

    public void buildDeck() {
        int i;
        for (i = 1; i < 10; i++) {
            cards.add(new Card(i, Suit.Oros));
            cards.add(new Card(i, Suit.Bastos));
            cards.add(new Card(i, Suit.Copas));
            cards.add(new Card(i, Suit.Espadas));
        }
        for (i = 11; i < 14; i++) {
            cards.add(new Card(i, Suit.Oros));
            cards.add(new Card(i, Suit.Bastos));
            cards.add(new Card(i, Suit.Copas));
            cards.add(new Card(i, Suit.Espadas));
        }

        cards.add(new Card(15, Suit.Comodines));
        cards.add(new Card(15, Suit.Comodines));
    }
}
