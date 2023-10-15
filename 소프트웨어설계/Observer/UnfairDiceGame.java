package 소프트웨어설계.Observer;

import java.util.Iterator;
import java.util.Random;

public class UnfairDiceGame extends DiceGame{

    private Random random = new Random();
    
    @Override
    public void play() {
        int unfairList[] = {1, 2, 2, 3, 3, 3,4, 5, 6};
        int serachNumber = random.nextInt(9);
        int diceNumber = unfairList[serachNumber];

        System.out.println("주사위 던졌다~" + diceNumber);
        

        Iterator<Player> iter = playerList.iterator();
        while(iter.hasNext()) {
            iter.next().update(diceNumber);
        }
    }
}
