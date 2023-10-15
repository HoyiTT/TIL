package 소프트웨어설계.Observer;

public class OddBettingPlayer extends Player{
    public OddBettingPlayer(String name){
        super(name);
    }

    @Override
    public void update(int diceNumber){
        if(diceNumber % 2 == 1) {
            System.out.println(getName() + "win!");
        }
    }
}