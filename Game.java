import java.util.List;

public class Game {

    private final Board board;

    private final List<Player> players;

    private final int numDices;

    private Player winner;

    public Game(Board board, 
                List<Player> players, 
                int numDices) {
        this.board = board;
        this.players = players;
        this.numDices = numDices;
        this.winner = null;            
    }

    public void play() {
        
        System.out.println("STARTING GAME\n");

        while (this.isInProgress()) {
            
            for (Player player : players) {
                
                System.out.println("Current Player: " + player.getName());
                
                int newPosition = board.getNewPosition(player.getCurrentPosition(), player.throwDice(numDices));
                player.moveTo(newPosition);

                if (player.hasWon(board.size())) {
                    winner = player;
                    System.out.println("PLAYER " + player.getName() + " WON!");
                    break;
                }
                
                System.out.println("");
            }
            
            System.out.println("\nNext round \n");

        }
    }

    private boolean isInProgress() {
        return winner == null;
    }
    
}
