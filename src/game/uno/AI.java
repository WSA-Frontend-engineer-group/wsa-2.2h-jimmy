package game.uno;

public class AI extends UnoPlayer {
    public AI() {
        super();
    }

    @Override
    public void nameHimself() {
        String name = "AI" + getRandomNumber(10000);
        System.out.printf("My name is %s \n", name);
        this.setName("AI" + name);
    }

    @Override
    public Card takeTurn() {
        if (this.getHand().getCards().size() == 0) {
            return null;
        }

        Integer selectedCardIndex = getRandomNumber(this.getHand().getCardSize());
        return (Card) this.getHand().playCard(selectedCardIndex);
    }


    private int getRandomNumber(int size) {
        return (int) Math.floor(Math.random() * size);
    }
}
