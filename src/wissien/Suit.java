package wissien;

public class Suit {

    private Deck hearts;
    private Deck diamonds;
    private Deck clubs;
    private Deck spades;

    public static Deck compareCard(Deck card1, Deck card2) {
        return card1.getValue() > card2.getValue() ? card1 : card2;
    }
}
