import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Article> inventory;

    // Constructor
    public Store() {
        this.inventory = new ArrayList<>();
    }

    // Getters
    public List<Article> getInventory() {
        return inventory;
    }

    // Adds an article to the store's inventory
    public void addArticle(Article article) {
        inventory.add(article);
    }

    // Finds an article in the inventory by name
    public Article findArticle(String articleName) throws ArticleNotFoundException {
        for (Article article : inventory) {
            if (matches(article.getName(), articleName)) {
                return article;
            }
        }
        throw new ArticleNotFoundException("Article not found: " + articleName);
    }

    // Helper method to check if two strings match with ? and *
    private boolean matches(String pattern, String text) {
        // Implement your matching logic here (using ? and *)
        return true;
    }
}
