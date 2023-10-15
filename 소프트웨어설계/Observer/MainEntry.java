package 소프트웨어설계.Observer;

public class MainEntry {
    public static void main(String[] args) {
        DiceGame dicegame = new UnfairDiceGame();

        Player player1 = new EvenBettingPlayer("옥자");
        Player player2 = new OddBettingPlayer("순자");
        Player player3 = new nBettingPlayer("윤자");
        
        dicegame.addPlayer(player1);
        dicegame.addPlayer(player2);
        dicegame.addPlayer(player3);

        for (int i = 0; i < 5; i++){
            dicegame.play();
            System.out.println();
        }
        
    }
}
