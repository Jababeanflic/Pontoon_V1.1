package Pontoon;
/**
 * Pontoon
 * @author 18025316
 * Scott Kinsmnan
 * 24/09/2020
 */
import java.util.Scanner;

public class GamesPlayed {
    private static boolean playGame;

    /**
     * @param playerContinue
     */
    public GamesPlayed(boolean playerContinue) {
    }

    /**
     * @return
     */
    public boolean getPlayGame() {
        return playGame;
    }

    /**
     * @param gamesPlayed
     * @return
     */
    public static boolean playerContinue(int gamesPlayed) {

        if (gamesPlayed < 5) {
            Scanner kboard = new Scanner(System.in);
            System.out.println("Number of games played " + gamesPlayed + ", do you want to play again y/n?");
            String c = kboard.next();
            if (c.equalsIgnoreCase("y")) { // loop to play another game and record games played
                playGame = true; // set to true to remain in do/while loop
            } else {
                playGame = false;
            }
        } else {
            System.out.println("You have played " + gamesPlayed + " games thats the max, Bye!");
            playGame = false;
        }
        return playGame;
    }
}
