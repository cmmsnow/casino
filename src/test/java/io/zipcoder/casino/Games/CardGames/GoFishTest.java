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
    private Player dealer;

    @BeforeEach
    void setUp() {
        goFishPlayer = new GoFishPlayer(new Player(0.0, "player"));
        goFish = new GoFish(goFishPlayer);
        player = goFishPlayer.getPlayer();
        playerHand = goFish.getPlayerHand();
        deck = new DeckOfCards().getDeck();
        dealer = goFish.getDealer();
        dealerHand = goFish.getDealerHand();
    }

    @Test
    void coinToss() {
    }

    @Test
    void startingDeal() {
    }

    @Test
    void playerFishing() {
        //Given
        goFish.getDealerHand().add(new Card(Suit.SPADES, Rank.FIVE));
        goFish.getDealerHand().add(new Card(Suit.HEARTS, Rank.FIVE));
        goFish.getPlayerHand().add(new Card(Suit.DIAMONDS, Rank.FIVE));
        goFish.getPlayerHand().add(new Card(Suit.CLUBS, Rank.FIVE));
        int playerHandSize = goFish.getPlayerHand().size();
        int dealerHandSize = goFish.getDealerHand().size();
        String expected = "Your opponent had 2 fives";

        //When
        String actual = goFish.playerFishing("five");

        //Then
        assertTrue(playerHandSize < goFish.getPlayerHand().size());
        assertTrue(dealerHandSize > goFish.getDealerHand().size());
        assertEquals(expected, actual);
    }

    @Test
    void dealerFishing() {
        //Given
        goFish.getDealerHand().add(new Card(Suit.SPADES, Rank.FIVE));
        goFish.getDealerHand().add(new Card(Suit.HEARTS, Rank.FIVE));
        goFish.getPlayerHand().add(new Card(Suit.DIAMONDS, Rank.FIVE));
        goFish.getPlayerHand().add(new Card(Suit.CLUBS, Rank.FIVE));
        int playerHandSize = goFish.getPlayerHand().size();
        int dealerHandSize = goFish.getDealerHand().size();
        String expected = "You gave your opponent 2 fives";

        //When
        String actual = goFish.dealerFishing("five");

        //Then
        assertTrue(playerHandSize > goFish.getPlayerHand().size());
        assertTrue(dealerHandSize < goFish.getDealerHand().size());
        assertEquals(expected, actual);
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
        //Given
        Integer expected = 4;
        playerHand.add(new Card(Suit.SPADES, Rank.FIVE));
        playerHand.add(new Card(Suit.DIAMONDS, Rank.FIVE));
        playerHand.add(new Card(Suit.HEARTS, Rank.FIVE));
        playerHand.add(new Card(Suit.CLUBS, Rank.FIVE));

        //When
        Integer actual = goFish.printHand(playerHand);

        //Then
        assertEquals(expected, actual);
    }

    @Test
    void draw() {
        //Given
        playerHand.add(new Card(Suit.SPADES, Rank.FIVE));
        playerHand.add(new Card(Suit.DIAMONDS, Rank.FIVE));
        playerHand.add(new Card(Suit.HEARTS, Rank.FIVE));
        playerHand.add(new Card(Suit.CLUBS, Rank.FIVE));
        Integer expected = playerHand.size() + 1;

        //When
        Card drawn = goFish.draw(playerHand);
        Integer actual = playerHand.size();

        //Then
        assertEquals(drawn, playerHand.get(playerHand.size()-1));
        assertEquals(expected, actual);
    }

    @Test
    void deckCardsLeft() {
        //Given
        deck = new DeckOfCards().getDeck();

        //When
        String expected = String.format("\nThere are %d cards left in the deck.\n\n", deck.size());
        String actual = goFish.deckCardsLeft();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    void dealerAsk() {
        //Given
        goFish.getDealerHand().add(new Card(Suit.SPADES, Rank.FIVE));
        goFish.getDealerHand().add(new Card(Suit.HEARTS, Rank.FIVE));
        goFish.getDealerHand().add(new Card(Suit.DIAMONDS, Rank.FIVE));
        goFish.getDealerHand().add(new Card(Suit.CLUBS, Rank.FIVE));

        //When
        String expected = "five";
        String actual = goFish.dealerAsk();

        //Then
        assertEquals(expected, actual);
    }
}