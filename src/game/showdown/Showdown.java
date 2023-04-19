package game.showdown;

import game.Game;

import java.util.*;

public class Showdown extends Game<PokerPlayer, Card> {

    public static final Integer MAX_HAND_CARD_SIZE = 13;

    private Map<PokerPlayer, Card> showedCards = new HashMap<>();


    public Showdown(List<PokerPlayer> players, Deck deck) {
        super(players, deck);
    }

    @Override
    protected boolean startNewRoundCriteria() {
        return showedCards.size() == this.getPlayers().size();
    }

    @Override
    protected void startNewRound() {
        showedCards.entrySet()
                .stream()
                .max(Comparator.comparing((Map.Entry<PokerPlayer, Card> e) -> e.getValue().getCardWeight()))
                .ifPresent(e -> {
                    e.getKey().gainPoint(1);
                });
        showedCards.clear();
    }

    @Override
    protected void takeTurn(PokerPlayer player) {
        Card card = player.takeTurn();
        showedCards.put(player, card);
    }

    @Override
    protected boolean stopDrawCardCriteria(int count) {
        return count < MAX_HAND_CARD_SIZE;
    }

    @Override
    protected boolean stopGameCriteria() {
        return getRound() >= MAX_HAND_CARD_SIZE;
    }

    @Override
    protected void showGameWinner() {
        Optional<PokerPlayer> winner = this.getPlayers()
                .stream()
                .max(Comparator.comparing(PokerPlayer::getPoint));

        if (winner.isPresent()) {
            this.setGameWinner(winner.get());
        }

        for (PokerPlayer player : this.getPlayers()) {
            System.out.printf("Player %s scored %d point(s)\n", player.getName(), player.getPoint());
        }

        if (this.getGameWinner() != null) {
            System.out.printf("Winner is %s\n", this.getGameWinner().getName());
        }
    }
}
