package game.showdown;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Showdown {

    public static final Integer MAX_HAND_CARD_SIZE = 13;

    private Integer turn = 0;
    private List<Player> players;

    private Deck deck;

    public Showdown(List<Player> players, Deck deck) {
        this.setPlayers(players);
        this.setDeck(deck);
    }


    public void startGame() {
        // 每個玩家取名
        for (Player player : players) {
            // 沒有說是否檢查名稱重複
            player.nameHimself();
        }

        // 洗牌
        System.out.println("Shuffling");
        this.deck.shuffle();

        // 發牌
        System.out.println("Drawing Card");
        int count = 0;
        while (count < MAX_HAND_CARD_SIZE) {
            count++;
            for (Player player : this.players) {
                Card card = deck.drawCard();
                player.getHand().addCard(card);
            }
        }

        // 開始遊戲
        System.out.println("Game start!");
        while (this.turn < MAX_HAND_CARD_SIZE) {
            this.setTurn(this.turn + 1);
            System.out.printf("Turn %d started \n", this.turn);
            List<Card> showedCards = new ArrayList<>();
            for (Player player : players) {
                showedCards.add(player.takeTurn(players.stream().filter(p -> p.getName() != player.getName()).toList()));
            }

            Player turnWinner = null;
            Card maxCard = null;
            for (int i = 0; i < showedCards.size(); i++) {
                if (showedCards.get(i) == null) continue;

                System.out.printf("Player %s showed %s \n", players.get(i).getName(), showedCards.get(i).showCardInfo());
                if (maxCard == null || showedCards.get(i).getCardWeight() > maxCard.getCardWeight()) {
                    maxCard = showedCards.get(i);
                    turnWinner = players.get(i);
                }
            }
            System.out.printf("%s won this turn \n", turnWinner.getName());

            turnWinner.gainPoint(1);
        }

        // 沒有說 分數相同時如何判斷勝利，只好先暴力的取得比較前面的使用者
        Optional<Player> gameWinner = players.stream().max(Comparator.comparing(Player::getPoint));

        if (!gameWinner.isPresent()) {
            throw new IllegalStateException("Nobody!");
        }

        for (Player player : players) {
            System.out.printf("Player %s scored %d point(s) \n", player.getName(), player.getPoint());
        }

        System.out.printf("The winner is %s", gameWinner.get().getName());
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
}
