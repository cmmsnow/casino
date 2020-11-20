package io.zipcoder.casino.Games.CardGames;
import io.zipcoder.casino.GameSupplies.Card;
import io.zipcoder.casino.GameSupplies.DeckOfCards;
import io.zipcoder.casino.Games.GameInterface;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.Players.Player;
import io.zipcoder.casino.utilities.Input;
import io.zipcoder.casino.utilities.Output;

import java.io.PrintStream;
import java.util.*;

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
    private Input input = new Input(System.in, System.out);
    private int handIndex = 0;
    //who's turn: ture = player, false = dealer;
    private boolean playerTurn;
    private int caughtFish;
    private Card drawnCard;


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
                running = false;
        }
    }

//    public void playGame () {
//        //Deal starting hands, 7 cards each.
//        for (int i = 0; i < 7; i++) {
//            draw(playerHand);
//            draw(dealerHand);
//        }
//
//        while (running) {
//
//            //Check coinToss boolean, if true playerTurn first.
//            if (coinToss()) {
//                playerTurn();
//            } else dealerTurn();
//
//
//        }
//
//    }


    public void playerTurn() {
        playerTurn = true;
        boolean askAgain;
        Card askingCard;

        do {
            askAgain = false;

            //Display hand and ask which card to go fishing for.
            printHand(playerHand);
            System.out.println("Which card would you like to fish for?");
            if (in.nextInt() > playerHand.size() || in.nextInt() == 0) {
                System.out.println("Please make an appropriate choice.");
                printHand(playerHand);
                System.out.println("Again...Which card would you like to fish for?");
            }
            askingCard = playerHand.get(in.nextInt()-1);

            //Fishing method sets caughtFish and prints return statement of how many fish caught
            System.out.printf("You politely ask: Do you have any %ss", askingCard.getValue().getThirdValue());
            fishing(askingCard, playerTurn);

            //If tIf caughtFish=zero player draws from deck and if they draw a fish askAgain = true, else
            if(caughtFish > 0) {
                askAgain = true;
                System.out.println("Looks like you caught some fishies, have another go!");
                pause();
            }
            else {
                System.out.println("Dealer Says: Go Fish Bitch!!!");
                pause();
                drawnCard = draw(playerHand);
                if (drawnCard.getValue().getThirdValue().equals(askingCard.getValue().getThirdValue())) {
                    askAgain = true;
                    System.out.printf("Noice, you drew a %s, you get to go again!", drawnCard.getValue().getThirdValue());
                }
            }


        }
        while(!askAgain);
    }

    public void dealerTurn() {
        boolean askAgain = false;
    }

    public PrintStream fishing(Card askingCard, boolean turn) {
        caughtFish = 0;
        if (turn) {
            for (Card c : dealerHand) {
                if (c.equals(askingCard)) {
                    dealerHand.remove(c);
                    playerHand.add(c);
                    caughtFish++;
                }
            }
        }
        else {
            for (Card c : playerHand) {
                if (c.equals(askingCard)) {
                    playerHand.remove(c);
                    dealerHand.add(c);
                    caughtFish++;
                }
            }

        }
        return System.out.printf("Your opponent had %d %ss",
                caughtFish, askingCard.getValue().getThirdValue());
    }

    public void printHand(ArrayList<Card> hand) {

        for (Card c : hand) {
            System.out.printf((handIndex+1) +": %s of %s\n", c.getValue().getThirdValue(), c.getSuit());
            handIndex++;
        }
    }

    public Card draw(ArrayList<Card> hand) {
        Card drawn = deck.dealCard();
        hand.add(drawn);
        return drawn;
    }

    public boolean coinToss() {
        Input input = new Input(System.in, System.out);
        int toss = (int) (Math.floor(Math.random()*2));
        int choice = input.getIntegerInput("\n\nChoose heads or tails:\n" +
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

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        hold.nextLine();
    }

    //Incomplete
    public boolean checkGameOver() {
        if (deckCardsLeft() == 0 || playerHand.size() == 0 || dealerHand.size() == 0) {
            gameOver = true;
        }
        return gameOver;
    }

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

    public void checkBooks(ArrayList<Card> hand) {

        ArrayList<String> names = new ArrayList<String>(hand.size());
        ArrayList<String> amount = new ArrayList<String>();

        for (Card c : hand) {
            names.add(c.getValue().getThirdValue());
        }

        for (String name : names) {
            int count = Collections.frequency(names, name);
            amount.add("name" + count);
        }

        /*
        Set<Card> books = new HashSet<Card>(hand);
        for (Card c : books) { }


        Map<String, Integer> books = new HashMap<String, Integer>();
        for (Card c : hand) {
            Integer count = books.get(c.getValue().getThirdValue());
            books.put(c.getValue().getThirdValue(), (count==null) ? 1 : count+1);
        }

        for (int i = 0; i < books.size(); i++) {

        }

         */



    }






    public void incrementPlayerBooks() {
        this.playerBooks++;
    }

    public void incrementDealerBooks() {
        this.dealerBooks++;
    }




}
