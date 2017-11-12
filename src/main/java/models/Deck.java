package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;

// Created by Daniel Lee
public class Deck {

  //  Creates an array of size 52 of the Card object
    public java.util.List<Card> gameDeck = new ArrayList<Card>(52);

/*    Adding new cards into the deck. We are just adding the values of the cards and since Aces are considered high,
      we will start with 2. Aces will be value '14'.
 */
    public Deck(){
      for(int i=2; i<=14; i++){
        gameDeck.add(new Card(i, Suit.Hearts));
        gameDeck.add(new Card(i, Suit.Diamonds));
        gameDeck.add(new Card(i, Suit.Spades));
        gameDeck.add(new Card(i, Suit.Clubs));
      }
    }

    void shuffle(){

    }

    int getRemainingAmountOfCards(){

    }
}
