package game.uno;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Human extends UnoPlayer {

    private static final Scanner scanner = new Scanner(System.in);
    public Human() {
        super();
    }

    @Override
    public void nameHimself() {
        System.out.println("請幫自己取名稱:");

        String inputName = scanner.next();
        this.setName(inputName);
    }

    @Override
    public Card takeTurn() {

        if (this.getHand().getCards().size() == 0) {
            return null;
        }
        System.out.println("請選擇要出的牌:");
        getHand().showHandCard();

        AtomicInteger selectedCardIndex = new AtomicInteger(scanner.nextInt());
        while (selectedCardIndex.get() < 0 || selectedCardIndex.get() >= this.getHand().getCardSize()) {
            System.out.println("超出手牌範圍，請重新選擇要出的牌:");
            selectedCardIndex.set(scanner.nextInt());
        }

        return (Card) this.getHand().playCard(selectedCardIndex.get());
    }

}
