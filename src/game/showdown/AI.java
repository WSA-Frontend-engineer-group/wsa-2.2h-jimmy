package game.showdown;

public class AI extends PokerPlayer {

    @Override
    public void nameHimself() {
        String name = "AI" + getRandomNumber(10000);
        System.out.printf("My name is %s \n", name);
        this.setName("AI" + name);
    }


    private int getRandomNumber(int size) {
        return (int) Math.floor(Math.random() * size);
    }


    @Override
    public Card takeTurn() {
        if (this.getHand().getCards().size() == 0) {
            return null;
        }
        return (Card) this.getHand().playCard(getRandomNumber(this.getHand().getCardSize()));
    }
}
