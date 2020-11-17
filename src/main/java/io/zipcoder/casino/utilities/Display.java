package io.zipcoder.casino.utilities;

public class Display {
    Integer selection;
    Double betAmount;

    /**
     * Need a menu for each separate game? Likely.
     */

    public Integer welcomeMenu(){

        return selection;
    }

    public Double getBetAmount(){return betAmount;}

    public Integer blackJackOptions(){return selection;}

    public Integer goFishOptions(){return selection;}

    public Integer crapsOptions(){return selection;}

    public Integer otherDiceGameOptions(){return selection;}
}
