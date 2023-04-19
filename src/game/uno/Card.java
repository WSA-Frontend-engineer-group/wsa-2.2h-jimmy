package game.uno;

public class Card extends game.Card {

    private Number number;

    private Color color;

    public Card(Number rank, Color color) {
        this.number = rank;
        this.color = color;
    }

    public Number getNumber() {
        return number;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return this.getColor().name() + "-" + this.getNumber().name();
    }

}
