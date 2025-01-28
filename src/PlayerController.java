import java.util.ArrayList;
import java.util.Scanner;

public class PlayerController {

    private final Player player;
    private final Scanner scanner = new Scanner(System.in);

    public PlayerController(Player player) {
        this.player = player;
    }

    public int chooseCard() {
        return 1;
    }

    public char showHand() {
        ArrayList <Card> hand = player.getHand();
        System.out.printf("Your hand (%d cards) is:\n", hand.size());
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.get(i);
            System.out.printf("%d: %s %s\n", i, card.getColor(), card.getValue());
        }
        System.out.println("Draw: d\nSkip: s");
        String input = scanner.nextLine();

        return input.charAt(0);
    }
}
