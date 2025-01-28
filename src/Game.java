import java.util.ArrayList;

public class Game {

    Card currentCard = new Card();

    Player player1; // User's player
    Player player2;
    Player player3;
    Player player4;
    private ArrayList<Player> players;
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

    public void playerTurn() {
        do {
            for (int i = 1; i < players.size(); ++i) { // Print how many cards each computer player hs
                System.out.printf("Player %d has %d cards\n", players.get(i).getId(), players.get(i).getHand().size());
            }
            showCurrentCard();
            PlayerController player = new PlayerController(players.getFirst());
            player.showHand();
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
