package io.zipcoder.casino.Games.CardGames;

import io.zipcoder.casino.GameSupplies.Card;
import io.zipcoder.casino.GameSupplies.DeckOfCards;
import io.zipcoder.casino.Games.GameInterface;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.Players.Player;
import io.zipcoder.casino.utilities.Input;
import io.zipcoder.casino.utilities.Output;

import java.util.*;

public class GoFish extends CardGames implements GameInterface {

    private final GoFishPlayer goFishPlayer;
    private final Stack<Card> deck;
    private final ArrayList<Card> playerHand;
    private final ArrayList<Card> dealerHand;
    private Integer playerBooks = 0;
    private Integer dealerBooks = 0;
    private boolean gameOver = false;
    private boolean running = true;
    private final Input io = new Input(System.in, System.out);
    private boolean playerTurn;
    private int caughtFish;
    private Card drawnCard;


    public GoFish(GoFishPlayer goFishPlayer) {
        this.goFishPlayer = goFishPlayer;
        Player dealer = new Player(0.0, "Dealer");
        this.deck = new DeckOfCards().getDeck();
        this.dealerHand = dealer.getHand();
        this.playerHand = goFishPlayer.getPlayer().getHand();
    }

    //TODO figure out run loop and breaking out.
    public boolean playGame() {

        while (running) {
            preamble();
        }
        return running;
    }

    public void preamble() {
        int choice = io.getIntegerInput(

                "\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                        "~~~~~~~~~~~~~~~~~~~~~~~~~~~Welcome to the Go Fish Table~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + goFishPlayer.getName() + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                        "\n" +
                        "************************************MENU********************************************\n\n" +
                        "1: Play Go Fish!\n2: Back to Games Menu\n");


        while (choice < 1 || choice > 2) {
            choice = io.getIntegerInput("\n\nPlease select one of the given options.\n" +
                    "\n~~~~~~~~~~~~~~~~~~~~Menu~~~~~~~~~~~~~~~~~~~\n\n" +
                    "1: Play Go Fish!\n2: Back to Games Menu.");
        }

        try {
            switch (choice) {
                case 1:
                    startingDeal();
                    coinToss();
                    break;
                case 2:
                    running = false;
                    break;
            }
        } catch (InputMismatchException e) {
            io.getInput().nextInt();
            io.getOutput().println("\n" + "Sorry! Please try again and choose a valid option.");
        }
    }


    public void startingDeal() {
        //Deal starting hands, 7 cards each.
        for (int i = 0; i < 7; i++) {
            draw(playerHand);
            draw(dealerHand);
        }

    }

    public void playerTurn() {
        playerTurn = true;
        boolean askAgain = true;
        int choice = 0;
        String askingCard = "";
        io.getOutput().println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Your Turn~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        io.getOutput().print(deckCardsLeft());
        io.getOutput().printf("Player has: %d books\nDealer has: %d books\n", playerBooks, dealerBooks);

        while (askAgain) {
            askAgain = false;

            //Display hand, check for book from deal and ask which card to go fishing for.
            printHand(playerHand);
            bookFound("Nice you formed a book!");

            choice = io.getIntegerInput("Which card would you like to fish for?");

            while (choice > playerHand.size() || choice == 0) {
                io.getOutput().println("Please make an appropriate choice.");
                printHand(playerHand);
                choice = io.getIntegerInput("Which card would you like to fish for?");
            }

            askingCard = playerHand.get(choice - 1).getValue().getThirdValue();

            //Fishing method sets caughtFish and prints return statement of how many fish caught
            io.getOutput().printf("You politely ask: Do you have any %ss\n", askingCard);
            pause();
            io.getOutput().println(playerFishing(askingCard));

            //checkBook;
            bookFound("Nice you formed a book!\n");
            io.getOutput().printf("Player has: %d books\nDealer has: %d books\n", playerBooks, dealerBooks);

            //If caughtFish>0 askAgain=true, else player draws
            // from deck and if they draw a fish askAgain = true
            if (caughtFish > 0) {
                askAgain = true;
                io.getOutput().println("Looks like you caught some fishies, have another go!");

                bookFound("Nice you formed a book!");
                pause();
            } else {
                io.getOutput().println("Dealer Says: Go Fish!");
                pause();
                drawnCard = draw(playerHand);
                io.getOutput().printf("You drew a %s\n\n", drawnCard.getValue().getThirdValue());
                if (drawnCard.getValue().getThirdValue().equals(askingCard)) {
                    askAgain = true;
                    io.getOutput().printf("Since, you drew a %s, you get to go again!", askingCard);
                }
            }
            dealerTurn();
        }
    }

    private void bookFound(String s) {
        if (checkBooks(playerHand)) {
            io.getOutput().printf("%s\nPlayer has: %d books\nDealer has: %d books\n",
                    s, playerBooks, dealerBooks);
            playerBooks++;
            printHand(playerHand);
        }
    }

    public void dealerTurn() {
        playerTurn = false;
        boolean askAgain = true;
        String askingCard;
        printHand(playerHand);
        io.getOutput().println("\"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Dealer Turn~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\"");
        io.getOutput().println(deckCardsLeft()+"\n");
        io.getOutput().printf("Player has: %d books\nDealer has: %d books\n", playerBooks, dealerBooks);

        while (askAgain) {

            //check for dealerBook from deal and ask player for card before taking it
            if (checkBooks(dealerHand)) {
                io.getOutput().println("Dealer formed a book!");
                dealerBooks++;
            }
            askingCard = dealerAsk();

            //Fishing method sets caughtFish and prints return statement of how many fish caught
            io.getOutput().printf("Dealer asks: Got any %ss?\n", askingCard);
            pause();
            io.getOutput().println(dealerFishing(askingCard));

            if (checkBooks(dealerHand)) {
                io.getOutput().println("Dealer formed a book!");
                dealerBooks++;
            }

            if (caughtFish > 0) {
                askAgain = true;
                io.getOutput().println("Looks like Dealer caught some fishies, they get to have another go!");
                pause();
            } else {
                io.getOutput().println("You Say: you will have to go fishing sir.");
                pause();
                drawnCard = draw(dealerHand);
                io.getOutput().printf("Dealer drew a %s\n\n", drawnCard.getValue().getThirdValue());
                if (drawnCard.getValue().getThirdValue().equals(askingCard)) {
                    askAgain = true;
                    io.getOutput().printf("Dealer drew a %s, dealer gets to go again!", drawnCard.getValue().getThirdValue());
                } else {
                    askAgain = false;
                }
            }
            io.getOutput().print(deckCardsLeft());
        }
        playerTurn();
    }

    public String dealerAsk() {
        Random random = new Random();
        return dealerHand.get
                (random.nextInt(dealerHand.size()))
                .getValue().getThirdValue();
    }

    public String playerFishing(String askingCard) {
        caughtFish = 0;
        Iterator<Card> it = dealerHand.iterator();

        while (it.hasNext()) {
            Card c = it.next();
            if (c.getValue().getThirdValue().equals(askingCard)) {
                it.remove();
                playerHand.add(c);
                caughtFish++;
            }
        }
        return String.format("Your opponent had %d %ss",
                caughtFish, askingCard);
    }

    public String dealerFishing(String askingCard) {
        caughtFish = 0;
        Iterator<Card> it = playerHand.iterator();
        while (it.hasNext()) {
            Card c = it.next();
            if (c.getValue().getThirdValue().equals(askingCard)) {
                it.remove();
                dealerHand.add(c);
                caughtFish++;
            }
        }
        return String.format("You gave your opponent %d %ss",
                caughtFish, askingCard);
    }

    public void printHand(ArrayList<Card> hand) {
        int handIndex = 0;
        for (Card c : hand) {
            io.getOutput().printf((handIndex + 1) + ": %s of %s\n", c.getValue().getThirdValue(), c.getSuit());
            handIndex++;
        }
    }

    public Card draw(ArrayList<Card> hand) {
        Card drawn = this.deck.pop();
        hand.add(drawn);
        return drawn;
    }


    public String deckCardsLeft() {
        return String.format("\nThere are %d cards left in the deck.\n\n", deck.size());
    }

    public void pause() {
        io.getOutput().println("\nPress Enter to continue...");
        io.getInput().nextLine();
    }

    public boolean checkBooks(ArrayList<Card> hand) {
        Integer count;
        boolean bookFound = false;
        String found = "";
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (Card c : hand) {
            count = map.get(c.getValue().getThirdValue());
            map.put(c.getValue().getThirdValue(), count == null ? 1 : count + 1);

            if (count != null && count == 4) {
                found = c.getValue().getThirdValue();
                bookFound = true;
            }
        }

        if (!found.equals("")) {
            for (Iterator<Card> it = hand.iterator(); it.hasNext(); ) {
                Card c = it.next();
                if (c.getValue().getThirdValue().equals(found)) {
                    it.remove();
                }

            }
        }
        return bookFound;
    }

    public boolean checkGameOver() {
        if (getDeck().size() == 0 && playerHand.size() == 0 && dealerHand.size() == 0) {
            io.getOutput().println("All the cards are gone...finally, let's check who won.\n");
            checkWinner();
            gameOver = true;
        }
        return gameOver;
    }

    public void checkWinner() {
        if (playerBooks > dealerBooks) {
            io.getOutput().printf("You have %d books and dealer has %d books.\n" +
                    "Looks like you won this game!!!\n...Ya simple bitch!!!", playerBooks, dealerBooks);
        } else if (dealerBooks > playerBooks) {
            io.getOutput().printf("You have %d books and dealer has %d books.\n" +
                    "Looks like you lost this game!!!\n...Ya simple bitch!!!", playerBooks, dealerBooks);
        } else {
            io.getOutput().printf("You have %d books and dealer has %d books.\n" +
                    "Looks like a tie game!!!\n...Thanks for wasting my time.", playerBooks, dealerBooks);
        }
    }


    public void incrementPlayerBooks() {
        this.playerBooks++;
    }

    public void incrementDealerBooks() {
        this.dealerBooks++;
    }

    public void coinToss() {

        int toss = (int) (Math.floor(Math.random() * 2));
        int choice = io.getIntegerInput("\n\nChoose heads or tails:\n" +
                "1: Heads\n2: Tails\n");

        if (choice - 1 == toss) {
            Output.printToScreen("\n\nYou won the coin toss, you get first turn.\n");
            pause();
            playerTurn();
        } else {
            Output.printToScreen("\n\nThe dealer won the coin toss, they get first turn.\n");
            pause();
            dealerTurn();
        }
    }

}