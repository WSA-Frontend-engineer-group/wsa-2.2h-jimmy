package game.showdown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;

    public Deck() {
        List<Card> newCards = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                newCards.add(new Card(rank, suit));
            }
        }

       this.setCards(newCards);
    }

    public void shuffle() {
        if (cards == null) {
            throw new IllegalStateException("Card doesn't initialize");
        }
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.size() == 0) {
            throw new IllegalStateException("No card can draw");
        }
        return cards.remove(0);
    }

    public void setCards(List<Card> cards) {
        if (cards.size() != 52) {
            throw new IllegalArgumentException("Card size must be 52");
        }
        this.cards = cards;
    }
}
