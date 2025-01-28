import java.util.Random;

public class Card {
    private final String color;
    private final String value;

    Random random = new Random();

    public Card() {
        String[] colors = {"Red", "Blue", "Yellow", "Green"};
        String[] types = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "Reverse"};
        this.value = types[random.nextInt(types.length)];
        this.color = colors[random.nextInt(colors.length)];
    }

    public String getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }
}
