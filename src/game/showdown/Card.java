package game.showdown;

public class Card extends game.Card{

    private Rank rank;

    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getCardWeight() {
        return (Suit.values().length * rank.ordinal()) + rank.ordinal();
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
    @Override
    public String toString() {
        return this.getSuit().name() + "-" + this.getRank().name();
    }
}
