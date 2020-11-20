package io.zipcoder.casino.Players;

import io.zipcoder.casino.GameSupplies.Card;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GoFishPlayerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void constructorTest() {
        Player playa = new Player(50.0, "Dolphin");
        GoFishPlayer gfPlayer = new GoFishPlayer(playa);
        Assert.assertNotNull(gfPlayer);
    }

    @Test
    public void getNameTest() {
        String expected = "Dolphin";
        Player playa = new Player(50.0, expected);
        GoFishPlayer gfPlayer = new GoFishPlayer(playa);
        String actual = gfPlayer.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPlayerTest() {
        Player playa = new Player(50.0, "Dolphin");
        GoFishPlayer gfPlayer = new GoFishPlayer(playa);
        Player actual = gfPlayer.getPlayer();
        Assert.assertEquals(playa, actual);
    }

    @Test
    public void getHandTest() {
        Player playa = new Player(50.0, "Dolphin");
        ArrayList<Card> hand = new ArrayList<Card>();
        GoFishPlayer gfPlayer = new GoFishPlayer(playa);
        ArrayList<Card> actual = gfPlayer.getHand();
        Assert.assertEquals(hand, actual);
    }
}