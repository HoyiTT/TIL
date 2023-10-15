package 소프트웨어설계.Observer;

import java.util.LinkedList;

public abstract class DiceGame {
    protected LinkedList<Player> playerList = new LinkedList<Player>();

    public void addPlayer(Player player){
        playerList.add(player);
    }

    public abstract void play();
}
