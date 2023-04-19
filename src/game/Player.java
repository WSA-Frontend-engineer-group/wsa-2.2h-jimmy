package game;

public abstract class Player<Card extends game.Card> {
    private String name;
    private Hand<Card> hand = new Hand<>();

    public abstract void nameHimself();

    public abstract Card takeTurn();

    public void drawCard(Card card) {
        this.hand.addCard(card);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }
}
