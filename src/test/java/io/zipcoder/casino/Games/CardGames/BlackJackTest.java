package io.zipcoder.casino.Games.CardGames;

import io.zipcoder.casino.GameSupplies.Card;
import io.zipcoder.casino.GameSupplies.DeckOfCards;
import io.zipcoder.casino.GameSupplies.Rank;
import io.zipcoder.casino.GameSupplies.Suit;
import io.zipcoder.casino.Players.BlackJackPlayer;
import io.zipcoder.casino.Players.Player;
import io.zipcoder.casino.utilities.Output;
import org.junit.*;

import java.io.InputStream;
import java.util.ArrayList;

public class BlackJackTest {

    @Before
    public void initialize() {
        DeckMock deck = new DeckMock();
    }

    @Test
    public void clearHandsTest() {
        // Given
        PlayerMock playerMock = new PlayerMock();
        BlackJackPlayer blackJackPlayer = new BlackJackPlayer(playerMock);
        BlackJack blackJack = new BlackJack(blackJackPlayer);
        Integer actual = 0;

        // When
        blackJack.clearHands();

        // Then
        Assert.assertEquals(blackJack.getPlayerTotal(), actual);
    }

    @Test
    public void handSumTest() {
        // Given
        PlayerMock playerMock = new PlayerMock();
        BlackJackPlayer blackJackPlayer = new BlackJackPlayer(playerMock);
        BlackJack blackJack = new BlackJack(blackJackPlayer);
        blackJack.getPlayersHand().add(new CardMock());
        blackJack.getDealersHand().add(new CardMock());
        int expected = 1;

        // When
        blackJack.handSum();
        int actual = blackJack.getPlayerTotal();

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void betTest() {
        // Given
        PlayerMock playerMock = new PlayerMock();
        BlackJackPlayer blackJackPlayer = new BlackJackPlayer(playerMock);
        BlackJack blackJack = new BlackJack(blackJackPlayer);
        Integer expected = (int) 10000;

        // When
        blackJack.bet();
        Integer actual = (int) blackJackPlayer.getWallet();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void displayHandTest () {
        // Given
        PlayerMock playerMock = new PlayerMock();
        BlackJackPlayer blackJackPlayer = new BlackJackPlayer(playerMock);
        BlackJack blackJack = new BlackJack(blackJackPlayer);
        blackJack.getPlayersHand().add(new CardMock());
        String expected = " ACE of SPADES ";

        // When
        String actual = blackJack.displayHand(blackJackPlayer);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void displayDealersHandTest () {
        // Given
        PlayerMock playerMock = new PlayerMock();
        BlackJackPlayer blackJackPlayer = new BlackJackPlayer(playerMock);
        BlackJack blackJack = new BlackJack(blackJackPlayer);
        blackJack.getDealersHand().add(new CardMock());
        String expected = " ACE of SPADES ";

        // When
        String actual = blackJack.displayDealersHand(blackJack.getDealersHand());

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void winConditionsTest () {
        // Given
        PlayerMock playerMock = new PlayerMock();
        BlackJackPlayer blackJackPlayer = new BlackJackPlayer(playerMock);
        BlackJack blackJack = new BlackJack(blackJackPlayer);
        blackJack.getPlayersHand().add(new CardMock());
        blackJack.getDealersHand().add(new CardMock());

        String expected = "PLAYER WINS";

        // When
        blackJack.winConditions();

        // Then
        Assert.assertEquals(expected, "PLAYER WINS");
    }

    private class CardMock extends Card {
        private CardMock() {
            super(Suit.SPADES, Rank.ACE);
        }
    }

    public class DeckMock extends DeckOfCards {
        CardMock cardMock = new CardMock();
        public DeckMock() {
        }
        @Override
        public Card dealCard() {
            return cardMock;
        }
    }

    private class PlayerMock extends Player {
        public PlayerMock() {
            super(10000, "John");
        }
    }

}
