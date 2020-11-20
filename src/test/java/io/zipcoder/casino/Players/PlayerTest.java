package io.zipcoder.casino.Players;

import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() { }

    @org.junit.jupiter.api.Test
    void getWallet() {
        Double expected = 50.0;
        Player playa = new Player(expected, "SnugglePuff");
        Double actual = playa.getWallet();
        Assert.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void setWallet() {
        Double original = 50.0;
        Player playa = new Player(original, "SnugglePuff");
        playa.setWallet(75.5);
        Double actual = playa.getWallet();
        Assert.assertNotEquals(original, actual);
    }

    @org.junit.jupiter.api.Test
    void getName() {
        String expected = "SnugglePuff";
        Player playa = new Player(50.0, expected);
        String actual = playa.getName();
        Assert.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void setName() {
        String original = "SnugglePuff";
        Player playa = new Player(50.0, original);
        playa.setName("Satan");
        String actual = playa.getName();
        Assert.assertNotEquals(original, actual);
    }
}