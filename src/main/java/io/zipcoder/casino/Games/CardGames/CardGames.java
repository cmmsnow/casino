package io.zipcoder.casino.Games.CardGames;

import io.zipcoder.casino.GameSupplies.Card;
import io.zipcoder.casino.GameSupplies.DeckOfCards;
import io.zipcoder.casino.Games.GameInterface;

import java.util.ArrayList;

public class CardGames extends Card implements GameInterface {

    private DeckOfCards deck;
//    private ArrayList<Card> dealerHand;
//    private ArrayList<Card> playerHand;

    public CardGames() {
        super();
        deck = new DeckOfCards();
//        dealerHand = new ArrayList<Card>();
//        playerHand = new ArrayList<Card>();
    }

    public boolean playGame() {
        return true;
    }

    public boolean endGame() {
        return false;
    }

    // assume that this is a single player game, so we don't need to rotate through several players
//    public void dealHand(int howManyCards) {
//        for (int i = 0; i < howManyCards; i++) {
//            playerHand.add(deck.dealCard());
//            dealerHand.add(deck.dealCard());
//
//        }
//    }

    public DeckOfCards getDeck() {
         return this.deck;
    }

//    public ArrayList<Card> getPlayerHand() {
//        return playerHand;
//    }
//
//    public ArrayList<Card> getDealerHand() {
//        return dealerHand;
//    }



}
