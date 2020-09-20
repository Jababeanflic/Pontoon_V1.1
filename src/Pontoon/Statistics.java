package Pontoon;

public class Statistics {

    public static void statistic(int gamesWon, int gamesPlayed) { // Method to calculate win percent

        System.out.println("Games played: " + gamesPlayed);
        System.out.println("Games won: " + gamesWon);
        int winPercent = gamesWon * 100 / gamesPlayed;
        System.out.println("Percentage of games won: " + winPercent + "%");
    }// end method

    public static void totalCards(int[][] cardsDrawn) { // Method to print out each card and the number of times it was drawn

        System.out.println("Frequency of each card drawn");

        for (int i = 1; i < cardsDrawn.length; i++) {// loops number of times equal to length of cards drawn array so 10
            System.out.println("Number of time card number " + i + " was drawn: " + cardsDrawn[i][0]);
        }
        System.out.println();
    }// end method

    public static int[][] cardsDrawn(int[] cardsDrawn, int[][] totalCardsDrawn) // Method to store which cards were drawn
    {
        System.out.print("Cards drawn: ");
        for (int x = 0; x < 10; x++) {
            if (cardsDrawn[x] != 0)
                if (x == 0)
                    System.out.print(cardsDrawn[x]);
                else {
                    System.out.print("," + cardsDrawn[x]);
                }
            totalCardsDrawn[cardsDrawn[x]][0] = totalCardsDrawn[cardsDrawn[x]][0] + 1;
        } // add new card to total cards drawn count so x=the card that was drawn and +1 is added to the "sub array"

        System.out.println();
        return (totalCardsDrawn); // Returns the total card drawn array within array, first index is card number second
    } // end method               // index is the number of time that card was drawn
}
