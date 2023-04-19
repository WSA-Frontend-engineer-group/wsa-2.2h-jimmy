package game;

import game.showdown.Card;

import java.util.ArrayList;
import java.util.List;

public class Hand<Card extends game.Card> {
    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getCardSize() {
        return cards.size();
    }

    public void setCards(List<Card> newCards) {
        this.cards = newCards;
    }

    public Card playCard(int selectedCardIndex) {
        Card card = cards.get(selectedCardIndex);
        cards.remove(selectedCardIndex);
        return card;
    }

    public void showHandCard() {
        int cardIndex = 0;
        for (Card card : cards) {
            System.out.printf("%d:　%s \n", cardIndex, card.toString());
            cardIndex++;
        }
    }
}
