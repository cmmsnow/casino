package io.zipcoder.casino.Games.CardGames;

import io.zipcoder.casino.Games.GamblingGameInterface;
import io.zipcoder.casino.Players.BlackJackPlayer;
import io.zipcoder.casino.Players.GamblingPlayerInterface;
import io.zipcoder.casino.utilities.Input;
import io.zipcoder.casino.utilities.Output;

import java.util.InputMismatchException;
import java.util.Scanner;


public class BlackJack extends CardGames implements GamblingGameInterface {

    private BlackJackPlayer blackJackPlayer;
    private Integer playerTotal = 0;
    private Integer dealerTotal = 0;
    private boolean powerOn = true;
    private boolean hitCheck = true;

    public BlackJack(BlackJackPlayer blackJackPlayer) {
        this.blackJackPlayer = blackJackPlayer;
    }

    Scanner scanner = new Scanner(System.in);

    public double bet(double betVal) {
        return betVal;
    }

    //Override this
    public void play() {

//        Console.println("\nWelcome to Blackjack " + blackJackPlayer.getName() + "!!!");
//
//        while(powerOn) {
//            Console.println("\nPlease select from the following options:\n" +
//                    "1 - Play a game of Blackjack\n" +
//                    "2 - Quit Blackjack\n" +
//                    "---------------------------------\n");
//
//            Console.getNextInt("Enter choice here -> ");
//
//            try {
//
//            } catch (InputMismatchException e) {
//                scanner.next();
//                Console.println("\n" + "Incorrect option chosen, please choose one of the menu options below.");
//
//            }
//
//
//        }



    }










    public Integer getPlayerTotal() {
        return playerTotal;
    }

    public void setPlayerTotal(Integer playerTotal) {
        this.playerTotal = playerTotal;
    }

    public Integer getDealerTotal() {
        return dealerTotal;
    }

    public void setDealerTotal(Integer dealerTotal) {
        this.dealerTotal = dealerTotal;
    }

    public boolean isPowerOn() {
        return powerOn;
    }

    public void setPowerOn(boolean powerOn) {
        this.powerOn = powerOn;
    }

    public boolean isHitCheck() {
        return hitCheck;
    }

    public void setHitCheck(boolean hitCheck) {
        this.hitCheck = hitCheck;
    }

    public double bet() {
        return 0;
    }

    public double payOut() {
        return 0;
    }
}


/*

private BlackJackPlayer blackJackPlayer;
private Integer playerHandTotal;
private Integer houseHandTotal;


public BlackJack(Player blackjackPlayer) {
    this.blackjackPlayer = blackjackPlayer)
}

public void clearAllHands(){
}

public void hitOrStay() {
}

public double bet() {
}

public double payout() {
}

public void play() {
}

public String getPlayerDealerResponse() { // hit or stay
}

public void winConditions() {
}





 */