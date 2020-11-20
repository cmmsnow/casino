package io.zipcoder.casino.Players;

import io.zipcoder.casino.GameSupplies.Card;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BlackJackPlayerTest {

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void constructor() {
        Player playa = new Player(50.0, "Alien");
        BlackJackPlayer bjPlayer = new BlackJackPlayer(playa);
        Assert.assertNotNull(bjPlayer);
    }

    @Test
    public void getBlackJackPlayerHand(){
        Player playa = new Player(50.0, "Alien");
        ArrayList<Card> hand = new ArrayList<Card>();
        BlackJackPlayer bjPlayer = new BlackJackPlayer(playa);
        ArrayList<Card> actual = bjPlayer.getBlackJackPlayerHand();
        Assert.assertEquals(hand, actual);
    }

    @Test
    public void getWallet() {
        Double expected = 50.0;
        Player playa = new Player(expected, "Alien");
        BlackJackPlayer bjPlayer = new BlackJackPlayer(playa);
        Double actual = bjPlayer.getWallet();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setWallet() {
        Double original = 50.0;
        Player playa = new Player(original, "Alien");
        BlackJackPlayer bjPlayer = new BlackJackPlayer(playa);
        Double expected = original + 25.0;
        bjPlayer.setWallet(expected);
        Double actual = bjPlayer.getWallet();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void placeBet() {
        Double expected = 0.0;
        Player playa = new Player(50.0, "Alien");
        BlackJackPlayer bjPlayer = new BlackJackPlayer(playa);
        Double actual = bjPlayer.placeBet();
        Assert.assertEquals(expected, actual);
    }
}