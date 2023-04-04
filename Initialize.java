import java.util.List;
import java.util.Map;

public class Initialize {

    public static void main(String[] args) {
        
        var snakes = Map.of(11, 2);
        var ladders = Map.of(7, 23);
        var width = 10;
        var board = new Board(width, snakes, ladders);

        var players = List.of(
            new Player("A"),
            new Player("B"),
            new Player("C"),
            new Player("D")
        );
        
        var numDices = 2;

        var game = new Game(board, players, numDices);
        game.start();

    }
 
}
