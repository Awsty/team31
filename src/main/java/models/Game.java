package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);

    public java.util.List<Card> discard;


    public Game(){
        // initialize a new game such that each column can store cards
        buildDeck();
        shuffle();

        // Initialize four empty array lists to store cards
        for (int i = 0; i < cols.size(); i++) {
            cols.add(deck);
        }

        // Initialize discard pile
        discard =  new ArrayList<Card>();
    }

    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }

    // Function by Johnny Po
    public void shuffle() {
        // shuffles the deck so that it is randomized
        Collections.shuffle(deck);
        System.out.print("Shuffle function called. ");

    }

    public void dealFour() {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns

    }

    //Function by Daniel Lee
    public void remove(int columnNumber) {
        // remove the top card from the indicated column
        //Checks to see if there are other cards in the game with the same suit
        int canRem = 0;

        for(int i=0; i<4; i++){
            if(i != columnNumber) {
                if(getTopCard(i).getSuit() != getTopCard(columnNumber).getSuit()){
                    canRem = 0;
                }
                else{
                    canRem = 1;
                    break;
                }
            }
        }

        if(canRem == 1){
            removeCardFromCol(columnNumber);
        }

    }

    private boolean columnHasCards(int columnNumber) {
        // Function by Brandon Mei
        // check indicated column for number of cards; if no cards return false, otherwise return true
        if(this.cols.get(columnNumber).size() != 0) {
            return false;
        }
        else {
            return true;
        }
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public void move(int columnFrom, int columnTo) {
        // Function by Brandon Mei
        // remove the top card from the columnFrom column, add it to the columnTo column
        if(columnHasCards(columnFrom)) {
            addCardToCol(columnTo, getTopCard(columnFrom));
            removeCardFromCol(columnFrom);
        }
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}
