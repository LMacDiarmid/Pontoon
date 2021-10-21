package VersionTwo;

import java.util.Scanner;

/**
 * <h1> User </h1>
 * <p> description </p>
 *
 * @author Leanne
 * @since 18/10/2021
 */
public class User extends Player
{

    public User()
    {

    }
    /**
     * <h1>drawCard</h1>
     * @return returns a random number between 0 and 10
     */
    public int drawCard() {
        return (int)Math.ceil(Math.random()*10);
    }


    /**
     * <h1>drawAnother</h1>
     * <p>Asks the player a yes or no question</p>
     * @param question
     * @return returns true or false depending on whether the answer is yes or no
     */
    public boolean askQuestion(String question)
    {
        Scanner kboard = new Scanner(System.in);
        System.out.println(question);
        return kboard.next().equalsIgnoreCase("y");
    }

}
