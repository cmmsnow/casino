package io.zipcoder.casino.Players;

import io.zipcoder.casino.GameSupplies.Card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player {

    private double wallet;
    private String name = "";
    private final ArrayList<Card> hand;

    public Player(double wallet, String name) {
        this.wallet = wallet;
        this.name = name;
        hand = new ArrayList<Card>();
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
}

