package Pontoon;

import java.util.Scanner;

public class Pontoon {

    public static int getRandomNumber() {
        return (int) (Math.random() * 10 + 1);
    }

    public static int calcTotal(int card1, int card2) {
        return (card1 + card2);
    }

    public static boolean getResult(int total, int house) {
        if (total > house && total <= 21)
            return (true);
        else
            return (false);
    }

    public static boolean busted(int total) {
        if (total > 21)
            return (true);
        else
            return (false);
    }

    public static int houseTotal(int x) {
        int dealer = 0;
        while (dealer < x)
            dealer = calcTotal(getRandomNumber(), getRandomNumber());
        return (dealer);
    }

    public static void displayCards(int cardsDrawn[]) {
        System.out.print("Cards drawn: ");
        for (int x = 1; x < 10; x++) {
            if (cardsDrawn[x] != 0)
                if (x == 1)
                    System.out.print(cardsDrawn[x]);
                else
                    System.out.print("," + cardsDrawn[x]);
        }
        System.out.println();
    }

    /*public static boolean numberGamesPlayed(String c, int gamesPlayed) {
        if (c.equalsIgnoreCase("y")) { // loop to play another game and record games played
            return (true); // set to true to remain in do/while loop
        } else {
            System.out.println("You have played " + gamesPlayed + " games thats the max, Bye!");
            return (false);
        }
    }*/
}
