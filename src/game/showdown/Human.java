package game.showdown;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Human extends Player{

    private static final Scanner scanner = new Scanner(System.in);
    public Human() {
        super();
    }

    @Override
    void nameHimself() {
        System.out.println("請幫自己取名稱:");

        String inputName = scanner.next();
        this.setName(inputName);
    }

    @Override
    Card show() {
        if (this.getHand().getCards().size() == 0) {
            return null;
        }
        System.out.println("請選擇要出的牌:");

        int cardIndex = 0;
        for (Card card : this.getHand().getCards()) {
            System.out.printf("%d:　%s \n", cardIndex, card.showCardInfo());
            cardIndex++;
        }

        AtomicInteger selectedCardIndex = new AtomicInteger(scanner.nextInt());
        while (selectedCardIndex.get() < 0 || selectedCardIndex.get() >= this.getHand().getCardSize()) {
            System.out.println("超出手牌範圍，請重新選擇要出的牌:");
            selectedCardIndex.set(scanner.nextInt());
        }

        Card selectedCard = this.getHand().getCards().get(selectedCardIndex.get());

        List<Card> newCards = IntStream.range(0, this.getHand().getCardSize())
                .filter(i -> i != selectedCardIndex.get())
                .mapToObj(i -> this.getHand().getCards().get(i))
                .toList();
        this.getHand().setCards(newCards);
        return selectedCard;
    }

    @Override
    void exchangeHands(List<Player> players) {
        if (this.getExchangeCard() != null) {
            throw new IllegalStateException("Already exchanged, you cannot do it again.");
        }

        System.out.println("是否要交換手牌: Y/N");
        String inputExchanged = scanner.next();
        if ("Y".equals(inputExchanged)) {
            int playerIndex = 0;
            for (Player player : players) {
                System.out.printf("%d:　%s \n", playerIndex, player.getName());
                playerIndex++;
            }

            int selectedPlayerIndex = scanner.nextInt();

            while (selectedPlayerIndex < 0 || selectedPlayerIndex >= players.size()) {
                System.out.println("找不到指定的選手，請重新選擇:");
                selectedPlayerIndex = scanner.nextInt();
            }
            Player selectedPlayer = players.get(selectedPlayerIndex);

            System.out.printf("%s exchanges hand:  %s \n", this.getName(), selectedPlayer.getName());
            this.setExchangeCard(new ExchangeCard(this, selectedPlayer));
        }
    }
}
