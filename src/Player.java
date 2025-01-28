import java.util.ArrayList;

public class Player {
    private int id;
    private ArrayList<Card> hand;

    public Player(int id) {
        this.id = id;
        this.hand = new ArrayList<>();
        for (int i=0; i<7; ++i) {
            Card card = new Card();
            addCard(card);
        }
    }

    public int getId() {
        return id;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void removeCard(Card card) {
        hand.remove(card);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
}
