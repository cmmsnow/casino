package io.zipcoder.casino.GameSupplies;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class DeckOfCardsTest {

    @Test
    public void getDeckTest() {
        DeckOfCards deck = new DeckOfCards();
        Stack actual = deck.getDeck();
        Assert.assertNotNull(actual);
    }

    @Test
    public void shuffleDeckTest() {
        DeckOfCards deck = new DeckOfCards();
        Stack expected = deck;
        Stack actual = deck.shuffleDeck();
        Assert.assertNotSame(expected, actual);
    }

    @Test
    public void dealCardTest() {
        DeckOfCards deck = new DeckOfCards();
        Integer expected = deck.size();
        deck.dealCard();
        Integer actual = deck.size();
        Assert.assertEquals(expected, actual);
    }
    //bad^

    @Test
    public void refreshDeckTest() {
        DeckOfCards deck = new DeckOfCards();
        deck.refreshDeck();
        Assert.assertNotNull(deck);
    }
}