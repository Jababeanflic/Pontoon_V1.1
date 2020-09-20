package Pontoon;

import java.util.Scanner;

public class NewGame {

    public static void newGame() {

        Scanner kboard = new Scanner(System.in);
        int[][] totalCardsDrawn = new int[11][1]; // Array in Array, 1st index holds card second number of times its been drawn
        String choice;
        boolean PlayGame;
        int card1;
        int card2;
        int newCard;
        int total;
        int dealer;
        int cardCount = 2;
        int gamesPlayed = 1; //To record number of games played
        int gamesWon = 0;
        int[][] totalCards = new int[0][];


        do {  // Player can choose to play again

            int[] cardsDrawn = new int[10]; // moved inside loop to reset the array
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

            while (choice.equalsIgnoreCase("y")) {
                newCard = Pontoon.getRandomNumber();
                cardsDrawn[cardCount++] = newCard;
                System.out.print("You have drawn a " + newCard);
                total = Pontoon.calcTotal(total, newCard);
                System.out.println("\nYour total is " + total);
                if (Pontoon.busted(total)) {
                    System.out.println("Your bust with " + total);
                    Statistics.cardsDrawn(cardsDrawn, totalCardsDrawn);
                    break; // Ends the game and program
                }// end if
                System.out.println("Do you want to draw another card y/n?");
                choice = kboard.next();
            } // end while

            if (Pontoon.getResult(total, dealer)) {
                System.out.println("You have won with a total of " + total + " Dealer has " + dealer);
                gamesWon++; // track games one
            } else {
                System.out.println("You have lost with a total of " + total + " Dealer has " + dealer);
            }

            totalCards = Statistics.cardsDrawn(cardsDrawn, totalCardsDrawn);
            GamesPlayed game = new GamesPlayed(GamesPlayed.playerContinue(gamesPlayed), GamesPlayed.numberGamesPlayed(gamesPlayed));
            gamesPlayed = game.getNoGamesPlayed();
            PlayGame = game.getPlayGame();

            /*if (gamesPlayed < 5) {
                System.out.println("Number of games played " + gamesPlayed + ", do you want to play again y/n?");
                choice = kboard.next();
                if (choice.equalsIgnoreCase("y")) { // loop to play another game and record games played
                    //PlayGame = Pontoon.numberGamesPlayed(choice, gamesPlayed); // set to true to remain in do/while loop
                    gamesPlayed++;
                }// end if
            }// end if/else

             */

        } while (PlayGame);// Game will loop if boolean PlayGame is true

        Statistics.statistic(gamesWon, gamesPlayed);//call method statistics to calculate win percent pass gamesWon and games played total
        Statistics.totalCards(totalCards);//call method total number of cards drawn for all games and pass array of cards already drawn
    }// end main method
}// end class


