package VersionTwo;

/**
 * <h1> House </h1>
 * <p> The house is a player that draws a card from a specific range of values </p>
 *
 * @author Leanne
 * @since 17/10/2021
 * @version 2
 */
public class House extends Player
{
    private int houseTotal;

    public House()
    {

    }


    /**
     * <h1>drawCard</h1>
     *
     * @return returns a random number/card between 16 and 21
     */
    public int drawCard()
    {
        return (int)Math.floor(Math.random()*(21-16+1)+16);
    }
}

