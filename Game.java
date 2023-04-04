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

    public void start() {
        
        System.out.println("STARTING GAME\n");

        System.out.println("\nNew round \n");
        while (this.isInProgress()) {
            
            for (var player : players) {
                
                System.out.println("Current Player: " + player.getName());
                
                var newPosition = board.getNewPosition(player.getCurrentPosition(), player.throwDice(numDices));
                player.moveTo(newPosition);

                if (player.hasWon(board.size())) {
                    winner = player;
                    System.out.println("\nPLAYER " + player.getName() + " WON!\n");
                    break;
                }
                
                System.out.println("");
            }
            
        }
    }

    private boolean isInProgress() {
        return winner == null;
    }
    
}
