package io.zipcoder.casino.Games.CardGames;
import io.zipcoder.casino.GameSupplies.Card;
import io.zipcoder.casino.GameSupplies.DeckOfCards;
import io.zipcoder.casino.Games.GameInterface;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.Players.Player;
import io.zipcoder.casino.utilities.Input;
import io.zipcoder.casino.utilities.Output;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class GoFish extends CardGames implements GameInterface {

    private GoFishPlayer player;
    private Player dealer;
    private DeckOfCards deck;
    private ArrayList<Card> playerHand;
    private ArrayList<Card> dealerHand;
    private Integer playerBooks;
    private Integer dealerBooks;
    private Input in = new Input();
    private boolean win;
    private boolean running;

    public GoFish (GoFishPlayer player) {
        this.player = player;
        this.dealer = new Player(100000.00, "Dealer");
        this.deck = new DeckOfCards();
        this.dealerHand = dealer.getHand();
        this.playerHand = this.player.getHand();
        this.playerBooks = 0;
        this.dealerBooks = 0;
        this.win = false;
        this.running = true;
    }

    public void preamble() {
        int choice;

        Output.printToScreen("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                                   "~~~~~~~~~~~~~~~~~~Welcome to the Go Fish Table~~~~~~~~\n" +
                                   "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
        choice = Input.getIntInput("\n\n~~~~~~~~~~~~~~~~~~~~Menu~~~~~~~~~~~~~~~~~~~\n\n" +
                                    "1: Play Go Fish!\n2: Read Rules.\n3: Back to Games Menu.");

        while (choice < 1 || choice > 3) {
            Output.printToScreen("\n\nPlease select one of the given options.\n");
            choice = Input.getIntInput("\n\n~~~~~~~~~~~~~~~~~~~~Menu~~~~~~~~~~~~~~~~~~~\n\n" +
                    "1: Play Go Fish!\n2: Read Rules.\n3: Back to Games Menu.");
        }

        switch (choice) {
            case 1: playGame();
                    break;
            //add rules
            case 2: Output.printToScreen("Rules.....");
                    break;
            //add exit
            case 3:
        }
    }


    public void playGame() {

        while(running) {


        }



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
