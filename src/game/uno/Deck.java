package game.uno;

import java.util.ArrayList;
import java.util.List;

public class Deck extends game.Deck<Card> {
    public Deck() {
        List<Card> newCards = new ArrayList<>();
        for (Color color : Color.values()) {
            for (Number rank : Number.values()) {
                newCards.add(new Card(rank, color));
            }
        }
       this.setCards(newCards);
    }
}
