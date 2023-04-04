import java.util.Map;

public class Board {
    
    private final int size;

    private Map<Integer, Integer> snakes;

    private Map<Integer, Integer> ladders;

    public Board(int width, 
                 Map<Integer, Integer> snakes,
                 Map<Integer, Integer> ladders) {
        this.size = width*width;
        this.snakes = snakes;
        this.ladders = ladders; 
    }

    public int size() {
        return size;
    }

    public int getNewPosition(int currentPosition, int diceValue) {
        int newPosition = currentPosition + diceValue;
        
        if (newPosition > size) {
            System.out.println("Cannot cross the board. Staying at " + currentPosition);
            return currentPosition;
        }

        if (snakes.containsKey(newPosition)) {
            System.out.println("Moving down the snake from " + newPosition + " to " + snakes.get(newPosition));
            newPosition = snakes.get(newPosition);
        } 
        
        if (ladders.containsKey(newPosition)) {
            System.out.println("Moving up the ladder from " + newPosition + " to " + ladders.get(newPosition));
            newPosition = ladders.get(newPosition);
        }

        System.out.println("Moving to " + newPosition);
        return newPosition;
    }

}
