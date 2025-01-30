import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {

    Card currentCard = new Card();

    Player player1; // User's player
    Player player2;
    Player player3;
    Player player4;
    private final ArrayList<Player> players;
    private boolean direction; // Goes in order if true and reverse if false
    private int currentPlayerIndex;

    private Player winner;

    public Game() {
        this.player1 = new Player(1); // User player
        this.player2 = new Player(2);
        this.player3 = new Player(3);
        this.player4 = new Player(4);
        this.players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        this.currentPlayerIndex = 0;

        this.direction = true;
    }

    public boolean isCardValid(Card currentCard, Card newCard) {
        return true;
    }

    public void playerAction(HashMap<String, String> action, Player player) { // Handle player move
        switch(action.get("Action")) {
            case "Draw":
                player.addCard();
            case "Skip":
                System.out.printf("Player %d skipped.", player.getId());
                currentPlayerIndex += direction ? 1 : -1;
            case "Place card":
                boolean valid = isCardValid(currentCard, player.getHand().get(  // Use user input to get index of card to place
                        Integer.parseInt(
                                action.get("Card")
                        )));
            default:
                break;
        }
     }

     public boolean isHandPlayable(Card currentCard, Player player) { // This function checks if a card from the player's hand is playable
        for (Card card : player.getHand()) {
            if (card.getColor().equals(currentCard.getColor()) || card.getValue().equals(currentCard.getValue())) {
                return true;
            }
        }
        return false;
    }

    public void playerTurn() {
        PlayerController playerController = new PlayerController(players.getFirst());
        do {
            for (int i = 1; i < players.size(); ++i) { // Print how many cards each computer player has
                System.out.printf("Player %d has %d cards\n", players.get(i).getId(), players.get(i).getHand().size());
            }
            showCurrentCard();

            // Player enter next move
            boolean valid = false;

            Scanner scanner = new Scanner(System.in); // Get user input
            HashMap<String, String> action = new HashMap<>();
            playerController.showHand();
            String input = playerController.getPlayerInput();

        } while(true);
    }

    public void showCurrentCard() {
        System.out.printf("The current card is: %s %s%n\n", currentCard.getColor(), currentCard.getValue());
    }

    public void start() {
        while (winner == null) {
            if (currentPlayerIndex == 0) {
                playerTurn();
            }
        }
    }
}
