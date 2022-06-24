package learning.controlFlow;

import java.util.Random;

/**
 * A stripped down single player version of Blackjack.
 */
public class BlackJack {
    private final static String[] cards = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "king", "queen", "jack", "ace"};

    public static void main(String[] args) {
//        BlackJack.startGame();
    }

    public String drawCard() {
        Random randomNum = new Random();
        int cardValue = randomNum.nextInt(BlackJack.cards.length);
        return BlackJack.cards[cardValue];
    }

    public static int getCardValue(String card) {
        int cardValue = switch (card) {
            case "king", "queen", "jack" -> 10;
            default -> Integer.parseInt(card);
        };
        return cardValue;
    }

    public static void startGame() {
        BlackJack player1 = new BlackJack();

        int player1CardTotal = 0;

        while (player1CardTotal <= 21) {
            String player1CardPick = player1.drawCard();
            if ("ace".equals(player1CardPick) && player1CardTotal < 11) {
                player1CardTotal += 11;
            } else if ("ace".equals(player1CardPick) && player1CardTotal > 11) {
                player1CardTotal += 1;
            } else {
                player1CardTotal += getCardValue(player1CardPick);
            }
        }

        System.out.println(player1CardTotal);
    }
}
