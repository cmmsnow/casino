package io.zipcoder.casino.Players;

import io.zipcoder.casino.GameSupplies.Card;

import java.util.ArrayList;
import java.util.Map;

public class Player {

    public double wallet;
    public String name = "";
    public Map<String, ArrayList<Object>> jackets;

    public Player(double wallet, String name) {
        this.wallet = wallet;
        this.name = name;
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

    public Map<String, ArrayList<Object>> getJackets() {
        return jackets;
    }

    public void setJackets(Map<String, ArrayList<Object>> jackets) {
        this.jackets = jackets;
    }


}

