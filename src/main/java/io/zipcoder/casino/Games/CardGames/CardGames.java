package io.zipcoder.casino.Games.CardGames;

import io.zipcoder.casino.GameSupplies.Card;
import io.zipcoder.casino.GameSupplies.DeckOfCards;

import java.util.ArrayList;

public class CardGames {
    /**
     * every card game has a deck of cards
     * every hard game has a player hand and a house hand
     */
    private DeckOfCards deck;
//    private ArrayList<Card> playerHand;
    private ArrayList<Card> houseHand;

    public CardGames() {
        deck = new DeckOfCards();
//        playerHand = new ArrayList<Card>();
        houseHand = new ArrayList<Card>();
    }

    // assume that this is a single player game, so we don't need to rotate through several players
    public void dealHand(int howManyCards) {
        for (int i = 0; i < howManyCards; i++) {
//            playerHand.add(deck.dealCard());
            houseHand.add(deck.dealCard());
        }
    }

//    public ArrayList<Card> getPlayerHand() {
//        return playerHand;
//    }

    public ArrayList<Card> getHouseHand() {
        return houseHand;
    }



}
