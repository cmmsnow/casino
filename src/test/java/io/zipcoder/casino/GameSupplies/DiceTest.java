package io.zipcoder.casino.GameSupplies;

import org.junit.Assert;
import org.junit.Test;

public class DiceTest {

    @Test
    public void tossAndSumTest(){
        Dice dice = new Dice(2);
        Assert.assertTrue((dice.tossAndSum(2) > 1) && (dice.tossAndSum(2) < 13));
    }

    @Test
    public void getNumOfDiceTest(){
        Integer expected = 2;
        Dice dice = new Dice(2);
        Integer actual = dice.getNumOfDice();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setNumOfDiceTest(){
        Dice dice = new Dice(2);
        Integer expected = 3;
        dice.setNumOfDice(expected);
        Integer actual = dice.getNumOfDice();
        Assert.assertEquals(expected, actual);
    }
}
