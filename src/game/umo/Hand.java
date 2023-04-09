package game.umo;

import java.util.ArrayList;
import java.util.List;

import static game.umo.Uno.MAX_HAND_CARD_SIZE;

public class Hand {
    private List<Card> cards = new ArrayList<>();

    public Hand() {
    }

    public void addCard(Card card) {
        if (this.cards.size() >= MAX_HAND_CARD_SIZE) {
            throw new IllegalStateException("Cannot add more card into hand.");
        }
        cards.add(card);
    }

    public Integer getCardSize() {
        return cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
