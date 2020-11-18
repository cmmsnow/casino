package io.zipcoder.casino.Players;
import io.zipcoder.casino.GameSupplies.Card;
import java.util.ArrayList;

public class GoFishPlayer {
    private String name;
    private Player player;
    private ArrayList<Card> hand;

    public GoFishPlayer(Player player) {
        this.player = player;
        this.name = player.getName();
        this.hand = new ArrayList<Card>();
    }
}
