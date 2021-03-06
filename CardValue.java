package Version3;

/**
 * <h1> CardValue enum<h1>
 *<p>This enum holds the card values for the deck</p>
 * @author Leanne
 * @since 24/10/2021
 **/

public enum CardValue {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private int cardValue;

    private CardValue(int value) {
        this.cardValue = value;
    }

    public int getCardValue() {
        return cardValue;
    }

}
