package io.zipcoder.casino.Players;
import io.zipcoder.casino.GameSupplies.Card;
import java.util.ArrayList;

public class GoFishPlayer {
    private final String name;
    private final Player player;


    public GoFishPlayer(Player player) {
        this.player = player;
        this.name = player.getName();
    }

    public String getName() {
        return name;
    }

    public Player getPlayer() {
        return player;
    }







}
