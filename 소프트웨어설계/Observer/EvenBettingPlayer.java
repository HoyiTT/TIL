package 소프트웨어설계.Observer;

public class EvenBettingPlayer extends Player{
    public EvenBettingPlayer(String name){
        super(name);
    }

    @Override
    public void update(int diceNumber){
        if(diceNumber % 2 == 0) {
            System.out.println(getName() + "win!");
        }
    }
}