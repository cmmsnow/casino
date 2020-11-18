package io.zipcoder.casino.Players;
import io.zipcoder.casino.GameSupplies.Card;


public class ChoHanPlayer  {
    private String name;
    private Player player;

    public ChoHanPlayer(Player player) {
        this.name = player.getName();
        this.player = player;
    }

    public String getName() {
        return this.name;
    }
}
