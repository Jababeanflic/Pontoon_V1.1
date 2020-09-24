package Pontoon;
/**
 * Pontoon
 * @author 18025316
 * Scott Kinsmnan
 * 24/09/2020
 */
import java.util.Scanner;

import static Pontoon.GamesPlayed.*;

public class NewGame {

    /**
     * NewGame call runs the main code structure
     */
    public static void newGame() {

        Scanner kboard = new Scanner(System.in);
        int[][] totalCardsDrawn = new int[10][1]; // 2D Array, 1st index holds card second number of times its been drawn
        String choice;
        boolean PlayGame;
        int card1;
        int card2;
        int newCard;
        int total;
        int dealer;
        int cardCount = 2;
        int gamesPlayed = 1;
        int gamesWon = 0;
        int[][] totalCards;

        /*
         * Player can choose to play again
         */
        do {

            int[] cardsDrawn = new int[10];     // moved inside loop to reset the array
            card1 = Pontoon.getRandomNumber();
            cardsDrawn[0] = card1;
            card2 = Pontoon.getRandomNumber();
            cardsDrawn[1] = card2;
            dealer = Pontoon.houseTotal(16);
            total = card1 + card2;
            System.out.println("You have drawn " + card1 + " and " + card2);
            System.out.println("Your total is " + total);
            System.out.println("Do you want to draw another card y/n?");
            choice = kboard.next();

            while (choice.equalsIgnoreCase("y")) {  // Loop to draw new cards
                newCard = Pontoon.getRandomNumber();
                cardsDrawn[cardCount++] = newCard;
                System.out.print("You have drawn a " + newCard);
                total = Pontoon.calcTotal(total, newCard);
                System.out.println("\nYour total is " + total);

                if (Pontoon.busted(total))
                {
                    System.out.println("Your bust with " + total);
                    Statistics.cardsDrawn(cardsDrawn, totalCardsDrawn);
                    break;
                }// end if
                System.out.println("Do you want to draw another card y/n?");
                choice = kboard.next();
            } // end while

            if (Pontoon.getResult(total, dealer))
            {
                System.out.println("You have won with a total of " + total + " Dealer has " + dealer);
                gamesWon++; // track games one
            } else {
                System.out.println("You have lost with a total of " + total + " Dealer has " + dealer);
            }// end if

            /*
             * Adds the cards drawn to the 2d array
             */
            totalCards = Statistics.cardsDrawn(cardsDrawn, totalCardsDrawn);

            /*
             * Controls number of games that can be played (Declaration)
             */
            GamesPlayed game = new GamesPlayed(playerContinue(gamesPlayed));

            /*
             * Choose to play again return True/False
             */
            PlayGame = game.getPlayGame();
            gamesPlayed++;

        } while (PlayGame);

        /*
         * calculate win percent pass gamesWon and games played total
         */
        Statistics.statistic(gamesWon, gamesPlayed);

        /*
         * call method total number of cards drawn for all games and pass array of cards already drawn
         */
        Statistics.totalCards(totalCards);
    }// end main method
}// end class


