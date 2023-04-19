package game.uno;

import java.util.ArrayList;
import java.util.List;

public class Hand extends game.Hand<Card> {
    private List<Card> cards = new ArrayList<>();

    public Hand() {
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getCardSize() {
        return cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
