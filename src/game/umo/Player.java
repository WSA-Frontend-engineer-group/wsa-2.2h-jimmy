package game.umo;

import java.util.List;

public abstract class Player {

    private String name;

    private Integer point = 0;

    private Hand hand;

    private ExchangeCard exchangeCard;

    public Player() {
        this.setHand(new Hand());
    }

    abstract void nameHimself();
    abstract Card show();
    abstract void exchangeHands(List<Player> assignedPlayer);

    public Card takeTurn(List<Player> players) {
        if (this.getExchangeCard() == null) {
            // 詢問是否要將換牌，若已經換過就不問
            this.exchangeHands(players);
        } else {
            this.getExchangeCard().check();
        }
        return this.show();
    }

    public void gainPoint(Integer addedPoint) {
        this.setPoint(this.point + addedPoint);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Hand getHand() {
        return hand;
    }

    public ExchangeCard getExchangeCard() {
        return exchangeCard;
    }

    public Integer getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public void setExchangeCard(ExchangeCard exchangeCard) {
        this.exchangeCard = exchangeCard;
    }
}
