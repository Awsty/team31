package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

// Created by Daniel Lee
public class Deck {

  //  Creates an array of size 52 of the Card object
    public java.util.List<Card> gameDeck = new ArrayList<Card>(52);

/*    Adding new cards into the deck. We are just adding the values of the cards and since Aces are considered high,
      we will start with 2. Aces will be value '15'.
 */
    public Deck(){
      for(int i=2; i<=15; i++){
        gameDeck.add(new Card(i, Suit.Hearts));
        gameDeck.add(new Card(i, Suit.Diamonds));
        gameDeck.add(new Card(i, Suit.Spades));
        gameDeck.add(new Card(i, Suit.Clubs));
      }
    }

    public void shuffle(){
//    Collections is a utility class in java that allows us to re-aarange the array in a random order
      Collections.shuffle(gameDeck);
    }

/*  This function will be called after every deal. This will check to see if the deck has been played its last card.
    If so, that means that the user has won the game.
*/
    public boolean deckEmpty(){
        if(gameDeck.size()<=0){
            return true;
        }
        else{
            return false;
        }
    }
}
