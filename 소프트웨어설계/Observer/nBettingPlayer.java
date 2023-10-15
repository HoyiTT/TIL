package 소프트웨어설계.Observer;

public class nBettingPlayer extends Player{
    public nBettingPlayer(String name){
        super(name);
    }

    @Override
    public void update(int diceNumber){
        if(diceNumber == 1) {
            System.out.println(getName() + "win!");
        }
    }
}
