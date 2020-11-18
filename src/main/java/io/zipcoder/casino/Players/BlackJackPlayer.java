package io.zipcoder.casino.Players;

import io.zipcoder.casino.GameSupplies.Card;

import java.util.ArrayList;

public class BlackJackPlayer implements GamblingPlayerInterface{
    private String name;
    private Player player;
    private double wallet;
    private ArrayList<Card> hand;

    public BlackJackPlayer(Player player) {
        this.player = player;
        this.name = player.getName();
        this.wallet = player.getWallet();
        this.hand = new ArrayList<Card>();
    }

    public double getWallet() {
        return 0;
    }

    public void setWallet() {

    }

    public double placeBet() {
        return 0;
    }

    public String getName() {
        return this.name;
    }
}
