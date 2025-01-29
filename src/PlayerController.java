import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class PlayerController {

    private final Player player;
    private final Scanner scanner = new Scanner(System.in);

    public PlayerController(Player player) {
        this.player = player;
    }

    public int chooseCard() {
        return 1;
    }


    public HashMap<String, String> validateUserInput(String input) { // Parse user input to determine action
        HashMap<String, String> action = new HashMap<>();
        if (input.equalsIgnoreCase("d")) {
            action.put("Action", "Draw");
        }
        else if (input.equalsIgnoreCase("s")) {
            action.put("Action", "Skip");
        }
        else if (input.isEmpty()) {
            return null;
        }
        else {
            try {
                int num = Integer.parseInt(input);
                if (num >= player.getHand().size()) {
                    throw new NumberFormatException("Input number exceeds the size of the player's hand.");
                }
                action.put("Action", "Place card");
                action.put("Card", input);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        return action;
    }

    public void showHand() {
        ArrayList<Card> hand = player.getHand();
        System.out.printf("Your hand (%d cards) is:\n", hand.size());
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.get(i);
            System.out.printf("%d: %s %s\n", i, card.getColor(), card.getValue());
        }
        System.out.println("Draw: d\nSkip: s");
    }
}
