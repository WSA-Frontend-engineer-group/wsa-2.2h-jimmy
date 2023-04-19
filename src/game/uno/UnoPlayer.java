package game.uno;


public abstract class UnoPlayer extends game.Player<Card> {
    public abstract void nameHimself();

    public abstract Card takeTurn() ;
}
