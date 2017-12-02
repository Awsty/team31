package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SpanishDeck extends Deck {

    public SpanishDeck() {
    }

    public void BuildDeck() {
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

    public ArrayList<Card> dealFour() {
        // if (len == 2) {
        ArrayList<Card> two = new ArrayList<Card>(2);
        for (int i = 0; i < 2; i++) {
            two.add(cards.get(i));
            cards.remove(i);
        }
        return two;

//        ArrayList<Card> four = new ArrayList<Card>(4);
//        if (len >= 4) {
//            for(int i = 0; i < 4; i++) {
//                four.add(cards.get(i));
//                cards.remove(i);
//            }
//            return four;
//        }
//        return Collections.emptyList();
    }
}
