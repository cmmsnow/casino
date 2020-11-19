package io.zipcoder.casino.Games.CardGames;

import io.zipcoder.casino.GameSupplies.Card;
import io.zipcoder.casino.Games.GamblingGameInterface;
import io.zipcoder.casino.Players.BlackJackPlayer;
import io.zipcoder.casino.utilities.Input;
import io.zipcoder.casino.utilities.Output;

import java.util.ArrayList;
import java.util.InputMismatchException;


public class BlackJack extends CardGames implements GamblingGameInterface {

    private BlackJackPlayer blackJackPlayer;
    private ArrayList<Card> dealersHand;
    private Integer playerTotal = 0;
    private Integer dealerTotal = 0;
    private boolean powerOn = true;
    private boolean hitCheck = true;
    private double currentWager = 0;


    public BlackJack(BlackJackPlayer blackJackPlayer) {
        this.blackJackPlayer = blackJackPlayer;
        this.dealersHand = new ArrayList<Card>();
    }

    @Override
    public void playGame() {
        Output.printToScreen("\nWelcome to Blackjack " + blackJackPlayer.getName() + "!!!");

        while(powerOn) {
            Output.printToScreen("\nPlease select from the following options:\n" +
                    "1 - Play a game of Blackjack\n" +
                    "2 - See how much is in your wallet\n" +
                    "3 - Quit Blackjack\n" +
                    "---------------------------------\n");

            int input = Input.getIntInput("Enter choice here -> ");
            try {
                switch (input) {
                    case 1:
                        takeBet();
                        dealHand(2);
                        handSum(); // BlackJackPlayer now has a hand of cards, need to evaluate the hand and then decide what to do
                        firstShow(); // Show results of the first round of cards
                        hitOrStand();

                        break;
                    case 2:
                        Output.printToScreen("Your current wallet balance is: " + blackJackPlayer.getWallet());
                        break;
                    case 3:
                        Output.printToScreen("\n" + "Thank you for visiting!");
                        powerOn = false;
                        break;
                    default:
                        Output.printToScreen("\n" + "Incorrect option chosen, please choose one of the menu options below.");
                        break;
                }
            } catch (InputMismatchException e) {
                Output.printToScreen("\n" + "Incorrect option chosen, please choose one of the menu options below.");
            }
        }
    }

    public void handSum() {
        playerTotal += sum(blackJackPlayer.getBlackJackPlayerHand());
        dealerTotal += sum(getDealersHand());
    }

    public int sum(ArrayList<Card> hand) {
        Integer count = 0;

        for (Card card : hand) {
            count += card.getValue().getSecondaryValue();
        }
        return count;
    }

//    public void winConditions() {
//        if (playerTotal > 21) {
//            Output.printToScreen("DEALER WINS");
//            Output.printToScreen("PLAYER BUSTS");
//
//        }
//    }


    // see what your hand totals and see the dealer's face up card
    public void firstShow() {
        Output.printToScreen("\nPLAYER: " + displayHand(blackJackPlayer));
        Output.printToScreen("\nPLAYER: " + playerTotal);
        Output.printToScreen("\n-----------------");
        Output.printToScreen("\nDEALER: " + getDealersHand().get(0));
        Output.printToScreen("\nDEALER: " + getDealersHand().get(0).getValue().getSecondaryValue());
    }

    public String displayHand(BlackJackPlayer blackJackPlayer) {
        String answer = "";

        for (int i = 0; i < blackJackPlayer.getBlackJackPlayerHand().size(); i++) {
                    Card card = blackJackPlayer.getBlackJackPlayerHand().get(i);
                    answer += card.toString();
            }

        return answer;
    }

    // hit or stand
    public void hitOrStand() {
        if (getStateOfGame().equals(stateOfGame.UNDER)) {
            Output.printToScreen("\nDo you want to 'hit' or 'stand'?");
            String answer = Input.getStringInput("Type answer -> ");

            if (answer.equals("hit")) {
                blackJackPlayer.getBlackJackPlayerHand().add(getDeck().dealCard());
                displayHand(blackJackPlayer);
                hitOrStand();
            } else {
                displayHand(blackJackPlayer);
                // ***** need to evaluate player total against dealer total
            }

        } else if (getStateOfGame().equals(stateOfGame.BLACKJACK)) {
            Output.printToScreen("\nPlayer wins!");
            blackJackPlayer.setWallet(blackJackPlayer.getWallet() + (2 * getCurrentWager()));
        } else {
            Output.printToScreen("\nPlayer loses...");
            displayHand(blackJackPlayer);
        }
    }

    public stateOfGame getStateOfGame() {
        if (sum(blackJackPlayer.getBlackJackPlayerHand()) > 21) {
            return stateOfGame.BUST;
        } else if (sum(blackJackPlayer.getBlackJackPlayerHand()) < 21) {
            return stateOfGame.UNDER;
        } else {
            return stateOfGame.BLACKJACK;
        }
    }

    public enum stateOfGame {
        UNDER, BLACKJACK, BUST
    }

    public void dealHand(int howManyCards) {
        for (int i = 0; i < howManyCards; i++) {
            dealersHand.add(getDeck().dealCard());
            blackJackPlayer.getBlackJackPlayerHand().add(getDeck().dealCard());
        }
    }


    @Override
    public boolean endGame() {
        return false;
    }


    public void takeBet() {
        double betInput = 0.0;
        betInput = Input.getDoubleInput("\nEnter the amount you would like to bet here -> ");
        if (betInput > blackJackPlayer.getWallet()) {
            Output.printToScreen("\nYou do not have enough to cover that bet.");
            takeBet();
        } else {
            Output.printToScreen("Your bet is: $" + betInput);
            blackJackPlayer.setWallet(blackJackPlayer.getWallet() - betInput);
            setCurrentWager(betInput);
        }
    }

    public void setCurrentWager(double wager) {
        this.currentWager = wager;
    }

    public double getCurrentWager() {
        return this.currentWager;
    }

    public ArrayList<Card> getDealersHand() {
        return dealersHand;
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