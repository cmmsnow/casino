package io.zipcoder.casino.Players;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CrapsPlayerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void constructor() {
        Player playa = new Player(50.0, "WhyMe");
        CrapsPlayer crapsPlayer = new CrapsPlayer(playa);
        Assert.assertNotNull(crapsPlayer);
    }

    @Test
    public void getWallet() {
        Double expected = 50.0;
        Player playa = new Player(expected, "WhyMe");
        CrapsPlayer crapsPlayer = new CrapsPlayer(playa);
        Double actual = crapsPlayer.getWallet();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setWallet() {
        Player playa = new Player(50.0, "WhyMe");
        CrapsPlayer crapsPlayer = new CrapsPlayer(playa);
        Double expected = 75.0;
        crapsPlayer.setWallet(expected);
        Double actual = crapsPlayer.getWallet();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void placeBet() {
        Double expected = 0.0;
        Player playa = new Player(50.0, "WhyMe");
        CrapsPlayer crapsPlayer = new CrapsPlayer(playa);
        Double actual = crapsPlayer.placeBet();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getName() {
        String expected = "WhyMe";
        Player playa = new Player(50.0, expected);
        CrapsPlayer crapsPlayer = new CrapsPlayer(playa);
        String actual = crapsPlayer.getName();
        Assert.assertEquals(expected, actual);
    }
}