package Pontoon;
/**
 * Pontoon
 * @author 18025316
 * Scott Kinsmnan
 * 24/09/2020
 */
public class Pontoon { // class to generate/print to screen random numbers/cards drawn and check total

    /**
     * @return
     */
    public static int getRandomNumber() {
        return (int) (Math.random() * 10 + 1);
    }

    /**
     * @param card1
     * @param card2
     * @return
     */
    public static int calcTotal(int card1, int card2) {
        return (card1 + card2);
    }

    /**
     * @param total
     * @param house
     * @return
     */
    public static boolean getResult(int total, int house) {
        if (total > house && total <= 21)
            return (true);
        else
            return (false);
    }

    /**
     * @param total
     * @return
     */
    public static boolean busted(int total) {
        if (total > 21)
            return (true);
        else
            return (false);
    }

    /**
     * @param x
     * @return
     */
    public static int houseTotal(int x) {
        int dealer = 0;
        while (dealer < x)
            dealer = calcTotal(getRandomNumber(), getRandomNumber());
        return (dealer);
    }
}
