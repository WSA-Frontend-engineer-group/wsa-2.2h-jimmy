package game.showdown;

public class ExchangeCard {
    private Integer overTurns = 3;
    private Player playerA;
    private Player playerB;

    public ExchangeCard(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        switchHand();
    }

    public void check() {
        if (overTurns == 0) {
            switchHand();
        } else {
            overTurns -= 1;
        }
    }

    private void switchHand() {
        Hand tempHand = playerA.getHand();
        playerA.setHand(playerB.getHand());
        playerB.setHand(tempHand);
    }
}
