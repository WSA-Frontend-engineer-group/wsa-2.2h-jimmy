package game.umo;

import java.util.List;
import java.util.stream.IntStream;

public class AI extends Player {
    public AI() {
        super();
    }

    @Override
    void nameHimself() {
        String name = "AI" + getRandomNumber(10000);
        System.out.printf("My name is %s \n", name);
        this.setName("AI" + name);
    }

    @Override
    Card show() {
        if (this.getHand().getCards().size() == 0) {
            return null;
        }

        Integer selectedCardIndex = getRandomNumber(this.getHand().getCardSize());

        Card selectedCard = this.getHand().getCards().get(selectedCardIndex);
        List<Card> newCards = IntStream.range(0, this.getHand().getCardSize())
                .filter(i -> i != selectedCardIndex)
                .mapToObj(i -> this.getHand().getCards().get(i))
                .toList();
        this.getHand().setCards(newCards);
        return selectedCard;
    }

    @Override
    void exchangeHands(List<Player> players) {
        if (this.getExchangeCard() != null) {
            throw new IllegalStateException("Already exchanged, you cannot do it again.");
        }

        if (getRandomNumber(2) == 1) {
            Player selectedPlayer = players.get(getRandomNumber(players.size()));

            System.out.printf("%s exchange hand:  %s \n", this.getName(), selectedPlayer.getName());
            this.setExchangeCard(new ExchangeCard(this, selectedPlayer));
        }
    }

    private int getRandomNumber(int size) {
        return (int) Math.floor(Math.random() * size);
    }
}
