package Pontoon;

import java.util.Scanner;

public class GamesPlayed {
    private static boolean playGame;
    private int noGamesPlayed;

    public GamesPlayed() {
    }

    public GamesPlayed(boolean playGame, int noGamesPlayed) { // setter
        this.playGame = playGame;
        this.noGamesPlayed = noGamesPlayed;
    }

    public boolean getPlayGame() {
        return playGame;
    }

    public int getNoGamesPlayed() {
        return noGamesPlayed;
    }

    public static int numberGamesPlayed(int gamesPlayed) {
        gamesPlayed++;
        return (gamesPlayed);
    }

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
        }
        return playGame;
    }


    /*public static void main(String[] args) {
        int gamesPlayed = 1;
        GamesPlayed game = new GamesPlayed(playerContinue(gamesPlayed), numberGamesPlayed(gamesPlayed));

        System.out.println(game.getPlayGame());
        System.out.println(game.getNoGamesPlayed());

    }
     */
}
