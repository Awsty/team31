package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SpanishGame extends Game {

    public SpanishDeck deck = new SpanishDeck();

    public java.util.List<Column> columns = new ArrayList<Column>();

    public SpanishGame() {
        this.deck.BuildDeck();
        this.deck.shuffle();
        java.util.List<Card> initD = this.deck.dealFour();
        for(int i = 0; i < initD.size(); i++) {
            columns.add(new Column());
            columns.get(i).cards.add(initD.get(i));
        }
    }

    public void remove(int columnNumber) {
        if(columnHasCards(columnNumber)) {
            Card c = getTopCard(columnNumber);
            boolean removeCard = false;
            for (int i = 0; i < 4; i++) {
                if (i != columnNumber) {
                    if (columnHasCards(i)) {
                        Card compare = getTopCard(i);
                        if (compare.getSuit() == c.getSuit()) {
                            if(compare.getValue() == 14) {
                                System.out.println("Ace card detected! Can remove.  ");
                                removeCard = true;
                            }
                            else {
                                System.out.println("Cannot remove a non-ace card! ");
                                removeCard = false;
                            }
//                            if (compare.getValue() > c.getValue()) {
//                                removeCard = true;
//                            }
                        }
                    }
                }
            }
            if (removeCard) {
                this.columns.get(columnNumber).cards.remove(this.columns.get(columnNumber).cards.size() - 1);
            }
        }
    }

    private boolean columnHasCards(int columnNumber) {
        if (this.columns.get(columnNumber).cards.size()>0) {
            return true;
        }
        return false;
    }

    private Card getTopCard(int columnNumber) {
        return this.columns.get(columnNumber).cards.get(this.columns.get(columnNumber).cards.size()-1);
    }

    public void dealFour() {
        ArrayList<Card> deal = deck.dealFour();
        for (int i = 0; i < deal.size(); i++) {
            Card c = deal.get(i);
            columns.get(i).cards.add(c);
        }
    }

    public void move(int columnFrom, int columnTo) {
        Card cardToMove = getTopCard(columnFrom);
        this.removeCardFromCol(columnFrom);
        this.addCardToCol(columnTo,cardToMove);
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        columns.get(columnTo).cards.add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.columns.get(colFrom).cards.remove(this.columns.get(colFrom).cards.size()-1);
    }
}
