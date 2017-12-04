package models;

import controllers.ApplicationController;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

public class Game {
    int gameMode; /* 0 - Normal, 1 - Spanish */

    public Deck deck;
    public java.util.List<Column> columns = new ArrayList<>();

    public Game(){
        columns.add(new Column(1));
        columns.add(new Column(2));
        columns.add(new Column(3));
        columns.add(new Column(4));

        deck = new Deck();
        this.gameMode = 0;
        deck.shuffle();
    }

    public Game(int gameMode){
        columns.add(new Column(1));
        columns.add(new Column(2));
        columns.add(new Column(3));
        columns.add(new Column(4));

        if(gameMode == 0) {
            System.out.println("Regular game mode! ");
            deck = new Deck();
        }
        else if(gameMode == 1) {
            System.out.println("Spanish game mode! ");
            deck = new SpanishDeck();
        }

        this.gameMode = gameMode;
        deck.shuffle();
    }

    public void dealFour() {
        ArrayList<Card> deal = deck.dealFour();
        for (int i = 0; i < deal.size(); i++) {
            Card c = deal.get(i);
            columns.get(i).cards.add(c);
        }
    }

    //customDeal to setup game for testing purposes (i.e. shuffled cards are random and hard to test)
    public void customDeal(int c1, int c2, int c3, int c4) {
        columns.get(0).cards.add(deck.cards.get(c1));
        deck.cards.remove(c1);
        columns.get(1).cards.add(deck.cards.get(c2));
        deck.cards.remove(c2);
        columns.get(2).cards.add(deck.cards.get(c3));
        deck.cards.remove(c3);
        columns.get(3).cards.add(deck.cards.get(c4));
        deck.cards.remove(c4);
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

    public boolean columnHasCards(int columnNumber) {
        return this.columns.get(columnNumber).cards.size() != 0;
    }

    private Card getTopCard(int columnNumber) {
        return this.columns.get(columnNumber).cards.get(this.columns.get(columnNumber).cards.size() - 1);
    }

    public boolean isColumnEmpty(int columnNumber) {
        return this.columns.get(columnNumber).cards.size() == 0;
    }

    public void move(int columnFrom, int columnTo) {
        if (isColumnEmpty(columnFrom)) {
            System.out.println("Error the column" + columnFrom + " is empty.");
        } else if (columnHasCards(columnTo)) {
                System.out.println("Its not an empty space in column " + columnTo +".");
            } else {
                this.addCardToCol(columnTo, getTopCard(columnFrom));
                this.removeCardFromCol(columnFrom);
                System.out.println("Moved from " + columnFrom + ", to " + columnTo + ".");
            }
        }

    private void addCardToCol(int columnTo, Card cardToMove) {
        columns.get(columnTo).cards.add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.columns.get(colFrom).cards.remove(this.columns.get(colFrom).cards.size() - 1);
    }

}