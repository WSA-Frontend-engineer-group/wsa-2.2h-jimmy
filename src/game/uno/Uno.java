package game.uno;

import game.Deck;
import game.Game;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class Uno extends Game<UnoPlayer, Card> {

    private Stack<Card> playedCards = new Stack<>();

    public Uno(List<UnoPlayer> unoPlayers, Deck<Card> deck) {
        super(unoPlayers, deck);
    }

    @Override
    protected void takeTurn(UnoPlayer player) {
        Card card = player.takeTurn();
        if (card != null && playedCards.size() != 0 && !isLegal(playedCards.peek(), card)) {
            takeTurn(player);
        } else if (card == null) {
            player.drawCard(getDeck().drawCard());
            if (getDeck().getCards().size() == 0) {
                Card topPlay = playedCards.pop();
                getDeck().reshuffle(playedCards);
                playedCards.clear();
                playedCards.add(topPlay);
            }
        } else {
            playedCards.add(card);
        }
    }

    private boolean isLegal(Card c1, Card c2) {
        return c1.getNumber() == c2.getNumber() || c1.getColor() == c2.getColor();
    }

    @Override
    protected boolean stopDrawCardCriteria(int count) {
        return count < 5;
    }

    @Override
    protected boolean stopGameCriteria() {
        Optional<UnoPlayer> winner = this.getPlayers()
                .stream()
                .filter(player -> player.getHand().getCardSize() == 0)
                .findFirst();
        if (winner.isPresent()) {
            this.setGameWinner(winner.get());
        }
        return winner.isPresent();
    }

    @Override
    protected void showGameWinner() {
        if (this.getGameWinner() != null) {
            System.out.printf("Winner is %s\n", this.getGameWinner().getName());
        }
    }
}
