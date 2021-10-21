package VersionTwo;

/**
 * <h1> Player </h1>
 * <p> Abstract class that user and house inherit from</p>
 *
 * @author Leanne
 * @since 17/10/2021
 * @version 2
 */
public abstract class Player
{
    public Player()
    {

    }

    /**
     * <h1> Abstract class drawCard</h1></hq>
     * <p>All inherited classes must implement drawCard</p>
     * @return the card
     */
    public abstract int drawCard();

}
