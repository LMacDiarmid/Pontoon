package VersionTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <h1> Game</h1>
 * <p> The game</p>
 *
 * @author Leanne
 * @since 17/10/2021
 * @version 2
 */
public class Game
{
    private int gameLimit;
    private int gamesWon;



    public Game()
    {
        String[] statistics = new String[10];
        Arrays.fill(statistics,"");
        setGameLimit();

        House h1 = new House();
        User u1 = new User();

        for(int game =0; game < gameLimit; game++)
        {
            int houseTotal = h1.drawCard();

            int card1 = u1.drawCard();
            int card2 = u1.drawCard();
            int newCard;
            ArrayList<Integer> drawnCards = new ArrayList<>();

            int total = calcTotal(card1,card2);
            drawnCards.add(card1);
            drawnCards.add(card2);

            System.out.println("Game: "+(game + 1));

            System.out.println("You drew "+card1+" and "+card2);

            addStatistic(card1,statistics);
            addStatistic(card2,statistics);

            while (u1.askQuestion("Would you like to draw another, y/n?"))
            {
                newCard = u1.drawCard();

                drawnCards.add(newCard);

                addStatistic(newCard,statistics);
                System.out.println("You drew "+ newCard);
                total = calcTotal(total, newCard);

            }
            System.out.println("Your total is :"+total);

            displayResults(total,houseTotal,drawnCards);

            //Closing message

            if (game == gameLimit - 1) {
                System.out.println("Thanks for playing \n");
            } else if (!u1.askQuestion("Do you wish to continue playing, y/n?"))
            {
                System.out.println("Thanks for playing \n");
                break;
            }

        }
        displayStatistics(gamePercentage(),statistics);
    }

    /**
     * <h1>setGameLimit</h1>
     * <p>Asks the user how many games they want to play</p>
     */
    private void setGameLimit()
    {
        Scanner kboard = new Scanner(System.in);
        System.out.println("How many games would you like to play?");
        gameLimit = kboard.nextInt();

    }

    /**
     * <h1> calcTotal</h1>
     * <p>adds the two parameters together and returns the total</p>
     * @param x  first card
     * @param y  second card
     * @return the sum of the parameters
     */
    public int calcTotal(int x, int y) {
        return x + y;

    }

    /**
     * <h1>addStatistic</h1>
     * <p>adds the statistic together</p>
     * @param cardValue
     * @param statistic
     * @return
     */
    public String[] addStatistic(int cardValue, String[] statistic) {
        statistic[cardValue - 1] = statistic[cardValue - 1] + "*";
        return statistic;
    }

    /**
     * <h1>getResult</h1>
     * <p>Gets the result of the game and returns true or false</p>
     * @param z total
     * @param y house total
     * @return if z is more than y and less than 21 returns true if not returns false
     */
    public boolean getResult(int z, int y) {
        //If loop to figure out if the player won or not
        return z > y && z <= 21;
    }

    /**
     * <h1>busted</h1>
     * <p>checks to see if the parameter is more then 21</p>
     * @param z
     * @return if the param is more then 21 return true
     */
    public boolean busted(int z) {
        return z > 21;
    }

    /**
     * <h1>gamePercentage</h1>
     * <p>calculates the percentage of games won</p>
     * @return
     */
    public double gamePercentage()
    {
        return ((100/gameLimit)*gamesWon);
    }

    public void displayStatistics(double gamePercentage, String[] statistics)
    {
        System.out.println("Number of games won: " + gamePercentage + "%");

        System.out.println("Histogram showing frequency of each card drawn");

        for (int i = 0; i < statistics.length; i++) {
            System.out.println(i + 1 + " " + statistics[i]);

        }


    }

    public void displayResults(int total, int houseTotal, ArrayList<Integer> drawnCards)
    {
        if (getResult(total, houseTotal) && total > houseTotal) {
            System.out.println("You have won! Congratulations!");
            gamesWon++;
        } else if (busted(total)) {
            System.out.println("Busted! Your cards total " + total + " which is over 21");

        } else System.out.println("You have lost with " + total + " the house has " + houseTotal + "!");

        System.out.println("Cards drawn: " + drawnCards);

    }




}
