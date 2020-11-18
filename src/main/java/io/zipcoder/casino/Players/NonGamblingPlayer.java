package io.zipcoder.casino.Players;

abstract class NonGamblingPlayer {
    private String name;

    public NonGamblingPlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
