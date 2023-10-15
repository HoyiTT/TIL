package 소프트웨어설계.Observer;

import java.util.Random;

import java.util.Iterator;

public class FairDiceGame extends DiceGame {

    private Random random = new Random();

    @Override
    public void play() {
        int diceNumber = random.nextInt(6) + 1;
        System.out.println("주사위 던졌다~" +   diceNumber);
        

        Iterator<Player> iter = playerList.iterator();
        while(iter.hasNext()) {
            iter.next().update(diceNumber);
        }
    }
    
}
