import java.util.Random;

/**
Represents a player in a game.
*/
public class Player {

    /**
    The name of the player.
    */
    private String name;
    
    /**
    The current position of the player on the board.
    */
    private int currentPosition;
    
    /**
    A random number generator used for throwing dice.
    */
    private final Random random;
    
    /**
    The maximum value of a dice.
    */
    private static final int MAX_DICE_VALUE = 6;
    
    /**
    Creates a new player with the given name.
    @param name the name of the player
    */
    public Player(String name) {
    this.name = name;
    this.currentPosition = 0;
    this.random = new Random();
    }

    /**
    Gets the name of the player.
    @return the name of the player
    */
    public String getName() {
    return name;
    }

    /**
    Gets the current position of the player on the board.
    @return the current position of the player
    */
    public int getCurrentPosition() {
    System.out.println("current position = " + currentPosition);
    return currentPosition;
    }

    /**
    Sets the current position of the player on the board.
    @param newPosition the new position of the player
    */
    public void moveTo(int newPosition) {
    this.currentPosition = newPosition;
    }

    /**
    Throws the specified number of dice and returns the total value.
    @param numDice the number of dice to throw
    @return the total value of the dice
    */
    public int throwDice(int numDice) {
    int diceValue = numDice + random.nextInt(MAX_DICE_VALUE * numDice);
    System.out.println("Dice value: " + diceValue);
    return diceValue;
    }
    
    /**
    Checks if the player has won the game.
    @param boardSize the size of the board
    @return true if the player has won the game; false otherwise
    */
    public boolean hasWon(int boardSize) {
        return currentPosition == boardSize;
    }
}