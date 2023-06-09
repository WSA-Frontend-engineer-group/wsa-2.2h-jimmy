package game.showdown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck extends game.Deck<Card> {
    public Deck() {
        List<Card> newCards = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(rank, suit);
                newCards.add(card);
            }
        }

       this.setCards(newCards);
    }
}
