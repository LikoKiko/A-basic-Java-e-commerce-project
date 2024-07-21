import java.util.HashMap;
import java.util.Map;

public class Basket {
    private Map<Article, Integer> items;

    // Constructor
    public Basket() {
        this.items = new HashMap<>();
    }

    // Getters
    public Map<Article, Integer> getItems() {
        return items;
    }

    // Adds an article with a specified quantity to the basket
    public void addItem(Article article, int quantity) {
        items.put(article, items.getOrDefault(article, 0) + quantity);
    }
}
