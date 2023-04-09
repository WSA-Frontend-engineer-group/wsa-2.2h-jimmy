package game.umo;

public class Card {

    private Rank rank;

    private Color color;

    public Card(Rank rank, Color color) {
        this.rank = rank;
        this.color = color;
    }

    public Integer getCardWeight() {
        return (Rank.values().length * color.ordinal()) + rank.ordinal() + 1;
    }

    public Rank getRank() {
        return rank;
    }

    public Color getSuit() {
        return color;
    }

    public String showCardInfo() {
        return this.getSuit().name() + "-" + this.getRank().name();
    }
}
