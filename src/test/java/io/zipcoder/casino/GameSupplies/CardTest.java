package io.zipcoder.casino.GameSupplies;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void getSuitTest() {
        // Given
        Card card = new Card();
        Suit expected = Suit.DIAMONDS;
        card.setSuit(expected);
        // While
        Suit actual = card.getSuit();
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setSuitTest() {
        // Given
        Card card = new Card();
        Suit expected = Suit.CLUBS;
        card.setSuit(expected);
        // While
        Suit actual = card.getSuit();
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getValueTest() {
        // Given
        Card card = new Card();
        Rank expected = Rank.SEVEN;
        card.setValue(expected);
        // While
        Rank actual = card.getValue();
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setValueTest() {
        // Given
        Card card = new Card();
        Rank expected = Rank.FIVE;
        card.setValue(expected);
        // While
        Rank actual = card.getValue();
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest() {
        // Given
        Card card = new Card();
        card.setSuit(Suit.DIAMONDS);
        card.setValue(Rank.EIGHT);
        String expected = " EIGHT of DIAMONDS ";
        // While
        String actual = card.toString();
        // Then
        Assert.assertEquals(expected, actual);
    }
}