import game.showdown.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Showdown showdown = new Showdown(Arrays.asList(
                new AI(),
                new AI(),
                new AI(),
                new AI()
        ), new Deck());
        showdown.startGame();
    }
}