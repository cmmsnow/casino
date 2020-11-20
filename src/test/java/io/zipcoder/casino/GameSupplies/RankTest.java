package io.zipcoder.casino.GameSupplies;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RankTest {

    @Test
    public void TestRank(){
//        Card card = new Card();
//        card.setSuit(Suit.DIAMONDS);
//        Rank rank = new Rank(8, 8, "EIGHT");
//        card.setValue(rank);
    }

    @Test
    public void TestGetPrimaryValue(){
        Card card = new Card();
        card.setSuit(Suit.DIAMONDS);
        card.setValue(Rank.EIGHT);
        Rank cardRank = card.getValue();
        int expected = 8;
        int actual = cardRank.getPrimaryValue();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestGetSecondaryValue(){
        Card card = new Card();
        card.setSuit(Suit.DIAMONDS);
        card.setValue(Rank.EIGHT);
        Rank cardRank = card.getValue();
        int expected = 8;
        int actual = cardRank.getSecondaryValue();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestGetThirdValue(){
        Card card = new Card();
        card.setSuit(Suit.DIAMONDS);
        card.setValue(Rank.EIGHT);
        Rank cardRank = card.getValue();
        String expected = "eight";
        String actual = cardRank.getThirdValue();
        Assert.assertEquals(expected, actual);
    }
}
