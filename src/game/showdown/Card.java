package game.showdown;

public class Card {

    private Rank rank;

    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Integer getCardWeight() {
        return (Rank.values().length * suit.ordinal()) + rank.ordinal() + 1;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public String showCardInfo() {
        return this.getSuit().name() + "-" + this.getRank().name();
    }
}
