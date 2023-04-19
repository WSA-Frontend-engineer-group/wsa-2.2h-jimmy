package game.uno;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Uno uno = new Uno(Arrays.asList(
                new AI(),
                new AI(),
                new AI(),
                new AI()
        ), new Deck());
        uno.startGame();
    }
}