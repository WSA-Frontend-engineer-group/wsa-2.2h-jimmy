package game;

import game.uno.Card;

import java.util.Collections;
import java.util.List;

public class Deck<Card> {

    private List<Card> cards;
    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.size() == 0) {
            throw new IllegalStateException("No card can draw");
        }
        return cards.remove(0);
    };

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void reshuffle(List<Card> cards) {
        this.setCards(cards);
        this.shuffle();
    }
}
