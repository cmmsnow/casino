package io.zipcoder.casino.Players;

abstract class GamblingPlayer implements GamblingPlayerInterface {
    private String name;
    private double wallet;

    public GamblingPlayer(String name, double wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getWallet() {
        return wallet;
    }


}
