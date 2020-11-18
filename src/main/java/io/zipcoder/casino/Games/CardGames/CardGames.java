package io.zipcoder.casino.Games.CardGames;

import io.zipcoder.casino.GameSupplies.Card;
import io.zipcoder.casino.GameSupplies.DeckOfCards;
import io.zipcoder.casino.Games.GameInterface;

import java.util.ArrayList;

public class CardGames implements GameInterface {
    /**
     * every card game has a deck of cards
     * every hard game has a player hand and a house hand
     */
    private DeckOfCards deck;
//    private ArrayList<Card> houseHand;
//    private ArrayList<Card> playerHand;

    public CardGames() {
        deck = new DeckOfCards();
//        houseHand = new ArrayList<Card>();
//        playerHand = new ArrayList<Card>();
    }

    public void playGame() {

    }

    public boolean endGame() {
        return false;
    }

    // assume that this is a single player game, so we don't need to rotate through several players
//    public void dealHand(int howManyCards) {
//        for (int i = 0; i < howManyCards; i++) {
//            houseHand.add(deck.dealCard());
//            playerHand.add(deck.dealCard());
//        }
//    }

//    public ArrayList<Card> getPlayerHand() {
//        return playerHand;
//    }

//    public ArrayList<Card> getHouseHand() {
//        return houseHand;
//    }



}
