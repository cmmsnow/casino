package io.zipcoder.casino.GameSupplies;

public class Card {

    private Suit suit;
    private Rank value;

    public Card(Suit suit, Rank value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Rank getValue() {
        return this.value;
    }

    public void setValue(Rank value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.value, this.suit); // can use this.value.getThirdValue() so that the string in the enum is returned
    }

}

// ---- enums ----

enum Suit {
    SPADES, HEARTS, DIAMONDS, CLUBS
}

// Go Fish and Blackjack don't use the joker cards
// created this ranking because ACE can have a value of 1 or 11 and JACK, QUEEN, and KING have the value of 10 also in GoFish you ask for "ace", "seven", etc
enum Rank {

    ACE(1, 11, "ace"),
    TWO(2, 2, "two"),
    THREE(3, 3, "three"),
    FOUR(4, 4, "four"),
    FIVE(5, 5, "five"),
    SIX(6, 6, "six"),
    SEVEN(7, 7, "seven"),
    EIGHT(8, 8, "eight"),
    NINE(9, 9, "nine"),
    TEN(10, 10, "ten"),
    JACK(11, 10, "jack"),
    QUEEN(12, 10, "queen"),
    KING(13, 10, "king");

    private int primaryValue;

    private int secondaryValue;

    private String thirdValue;

    Rank(int primaryValue, int secondaryValue, String thirdValue) {
        this.primaryValue = primaryValue;
        this.secondaryValue = secondaryValue;
        this.thirdValue = thirdValue;
    }

    public int getPrimaryValue() {
        return primaryValue;
    }

    public int getSecondaryValue() {
        return secondaryValue;
    }

    public String getThirdValue() {
        return thirdValue;
    }

}
