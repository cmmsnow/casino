package io.zipcoder.casino.Games.CardGames;
import io.zipcoder.casino.GameSupplies.Card;
import io.zipcoder.casino.GameSupplies.DeckOfCards;
import io.zipcoder.casino.Games.GameInterface;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.Players.Player;
import io.zipcoder.casino.utilities.Input;
import io.zipcoder.casino.utilities.Output;

import java.util.ArrayList;
import java.util.Scanner;

public class GoFish extends CardGames implements GameInterface {

    private GoFishPlayer player;
    private Player dealer;
    private final DeckOfCards deck;
    private final ArrayList<Card> playerHand;
    private final ArrayList<Card> dealerHand;
    private Integer playerBooks;
    private Integer dealerBooks;
    private final Scanner in = new Scanner(System.in);
    public Scanner hold = new Scanner(System.in);
    private boolean gameOver;
    private boolean running;


    public GoFish (GoFishPlayer player) {
        this.player = player;
        this.dealer = new Player(10000000.00, "Dealer");
        this.deck = new DeckOfCards();
        this.dealerHand = dealer.getHand();
        this.playerHand = this.player.getHand();
        this.playerBooks = 0;
        this.dealerBooks = 0;
        this.gameOver = false;
        this.running = true;
    }




        public void preamble () {
        int choice;

        Output.printToScreen("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "~~~~~~~~~~~~~~~~~~Welcome to the Go Fish Table~~~~~~~~\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~Ya Simple Bitch!!~~~~~~~~~~~~~~~\n\n");
        Output.printToScreen("\n\n~~~~~~~~~~~~~~~~~~~~Menu~~~~~~~~~~~~~~~~~~~\n\n" +
                "1: Play Go Fish!\n2: Read Rules.\n3: Back to Games Menu.");

        choice = in.nextInt();

        while (choice < 1 || choice > 3) {
            Output.printToScreen("\n\nPlease select one of the given options.\n" +
                    "\n~~~~~~~~~~~~~~~~~~~~Menu~~~~~~~~~~~~~~~~~~~\n\n" +
                    "1: Play Go Fish!\n2: Read Rules.\n3: Back to Games Menu.");
            choice = in.nextInt();
        }

        switch (choice) {
            case 1:
                playGame();
                break;
            //add rules
            case 2:
                Output.printToScreen("Rules.....");
                break;
            //How are we handling exiting?
            case 3:
        }
    }

        public void playGame () {
        //Deal starting hands, 7 cards each.
        //Is it necessary to delete cards pulled out of deck from deck?
        for (int i = 0; i < 7; i++) {
            draw(playerHand);
            draw(dealerHand);
        }

        while (running) {

            //Check coinToss boolean, if true playerTurn first.
            if (coinToss()) {
                playerTurn();
            } else dealerTurn();


        }

    }

    //Where you left off.
    public void playerTurn() {
        String drawnCard = null;
        boolean askAgain = false;
        int askingCard;

        do {
            askAgain = false;
            printHand(playerHand);
            System.out.println("Which card would you like to fish for?");
            askingCard = in.nextInt();
            fishing(askingCard);


        }
        while(!askAgain);


    }

    public void fishing(int cardChoice) {

    }
    public void dealerTurn() {
        boolean askAgain = false;
    }

    public void printHand(ArrayList<Card> hand) {
        for (Card c : hand) {
            System.out.printf("1: %s of %s\n", c.getValue().getThirdValue(), c.getSuit());
        }
    }

    public void draw(ArrayList<Card> hand) {
        hand.add(deck.dealCard());
    }

    public boolean coinToss() {

        int toss = (int) (Math.floor(Math.random()*2));
        int choice = Input.getIntInput("\n\nChoose heads or tails:\n" +
                "~~~~~~~~~~~~~~1: Heads\n2: Tails");

        if (choice - 1 == toss) {
            Output.printToScreen("\n\nYou won the coin toss, you get first turn.\n");
            return true;
        }
        else Output.printToScreen("\n\nThe dealer won the coin toss, they get first turn.\n");
                return false;
    }

    public int deckCardsLeft() {
        return deck.size();
    }

    public boolean checkGameOver() {
        if (deckCardsLeft() == 0 || playerHand.size() == 0 || dealerHand.size() == 0) {
            gameOver = true;
        }
        return gameOver;
    }

    //Incomplete
    public void checkWinner() {
        if (playerBooks > dealerBooks) {
            //player won message
        }
        else if (dealerBooks > playerBooks) {
            //dealer won message
        }
        else {
            //Tie game message
        }
    }

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        hold.nextLine();
    }




    /**
     * These may not be necessary.
     *
     */
    public GoFishPlayer getPlayer() {
        return player;
    }

    public void incrementPlayerBooks() {
        this.playerBooks++;
    }

    public void incrementDealerBooks() {
        this.dealerBooks++;
    }




}
