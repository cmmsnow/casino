package io.zipcoder.casino.Games.CardGames;

import io.zipcoder.casino.GameSupplies.Card;
import io.zipcoder.casino.GameSupplies.DeckOfCards;
import io.zipcoder.casino.GameSupplies.Rank;
import io.zipcoder.casino.GameSupplies.Suit;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.Players.Player;
import io.zipcoder.casino.utilities.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class GoFishTest {
    private GoFish goFish;
    private Player player;
    private GoFishPlayer goFishPlayer;
    private Stack<Card> deck;
    private ArrayList<Card> playerHand;
    private ArrayList<Card> dealerHand;
    private Integer playerBooks = 0;
    private Integer dealerBooks = 0;
    private boolean playerTurn;
    private int caughtFish;
    private Card drawnCard;

    @BeforeEach
    void setUp() {
        goFishPlayer = new GoFishPlayer(new Player(0.0, "player"));
        goFish = new GoFish(goFishPlayer);
        player = goFishPlayer.getPlayer();
        playerHand = new ArrayList<Card>();

    }

    @Test
    void coinToss() {
    }

    @Test
    void startingDeal() {
    }

    @Test
    void playerFishing() {
    }

    @Test
    void dealerFishing() {
    }

    @Test
    void checkBooks() {
        //Given
        playerHand.add(new Card(Suit.SPADES, Rank.FIVE));
        playerHand.add(new Card(Suit.DIAMONDS, Rank.FIVE));
        playerHand.add(new Card(Suit.HEARTS, Rank.FIVE));
        playerHand.add(new Card(Suit.CLUBS, Rank.FIVE));

        //When
        boolean actual = goFish.checkBooks(playerHand);
        //Then
        assertTrue(actual);
    }

    @Test
    void printHand() {
    }

    @Test
    void draw() {
    }

    @Test
    void deckCardsLeft() {
    }


    @Test
    void dealerAsk() {
    }
}