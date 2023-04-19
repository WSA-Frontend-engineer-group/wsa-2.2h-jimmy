package game;

import java.util.List;

public abstract class Game<Player extends game.Player<Card>, Card extends game.Card> {

    private List<Player> players;
    private Deck<Card> deck;

    private Player gameWinner;

    private int turn = 0;
    private int round = 0;

    public Game(List<Player> players, Deck<Card> deck) {
        this.players = players;
        this.deck = deck;
    }

    public void startGame() {
        playerNaming();
        shuffle();
        drawingCard();
        prepareTable();
        playGame();
        showGameWinner();
    }

    private void playGame() {
        this.turn = getFirstTurnPlayerIndex();
        // 開始遊戲
        while (!stopGameCriteria()) {
            Player player = players.get(turn % players.size());
            turn += 1;

            if (startNewRoundCriteria()) {
                round += 1;
                startNewRound();
            }
            takeTurn(player);
        }
    }

    private void drawingCard() {
        // 發牌
        System.out.println("Drawing Card");
        int count = 0;
        while (stopDrawCardCriteria(count)) {
            count++;
            for (Player player : this.players) {
                Card card = deck.drawCard();
                player.drawCard(card);
            }
        }
    }

    private void shuffle() {
        // 洗牌
        System.out.println("Shuffle");
        this.deck.shuffle();
    }

    private void playerNaming() {
        // 每個玩家取名
        for (Player player : players) {
            player.nameHimself();
        }
    }

    protected abstract void takeTurn(Player player);

    protected int getFirstTurnPlayerIndex() {
        return 0;
    }

    protected boolean startNewRoundCriteria() {
        return false;
    }

    protected void startNewRound() {}

    protected void prepareTable() {};

    protected abstract boolean stopDrawCardCriteria(int count);
    protected abstract boolean stopGameCriteria();

    protected abstract void showGameWinner();

    public List<Player> getPlayers() {
        return players;
    }

    public void setGameWinner(Player gameWinner) {
        this.gameWinner = gameWinner;
    }

    public Player getGameWinner() {
        return gameWinner;
    }

    public int getRound() {
        return round;
    }

    public Deck<Card> getDeck() {
        return deck;
    }
}
