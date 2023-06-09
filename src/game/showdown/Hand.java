package game.showdown;

import java.util.ArrayList;
import java.util.List;

import static game.showdown.Showdown.MAX_HAND_CARD_SIZE;

public class Hand extends game.Hand<Card> {
    private List<Card> cards = new ArrayList<>();

    public Hand() {
    }

    public void addCard(Card card) {
        if (this.cards.size() >= MAX_HAND_CARD_SIZE) {
            throw new IllegalStateException("Cannot add more card into hand.");
        }
        cards.add(card);
    }

    public int getCardSize() {
        return cards.size();
    }

//    public List<Card> getCards() {
//        return cards;
//    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
