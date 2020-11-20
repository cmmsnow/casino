package io.zipcoder.casino.Players;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class ChoHanPlayerTest {
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void constructorTest() {
        Player playa = new Player(50.0, "Banana");
        ChoHanPlayer chPlayer = new ChoHanPlayer(playa);
        Assert.assertNotNull(chPlayer);
    }

    @Test
    public void getNameTest() {
        String name = "Banana";
        Player playa = new Player(50.0, name);
        ChoHanPlayer chPlayer = new ChoHanPlayer(playa);
        String actual = chPlayer.getName();
        Assert.assertEquals(name, actual);
    }
}