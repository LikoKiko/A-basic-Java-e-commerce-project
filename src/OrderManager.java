public class OrderManager {
    private Store store;
    private Basket basket;

    // Constructor
    public OrderManager(Store store) {
        this.store = store;
        this.basket = new Basket();
    }

    // Checks the availability of a specified article
    public void checkAvailability(String articleName) {
        try {
            Article foundArticle = store.findArticle(articleName);
            System.out.println("Article is available: " + foundArticle);
        } catch (ArticleNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // Adds a specified quantity of a found article to the basket
    public void addToBasket(String articleName, int quantity) {
        try {
            Article foundArticle = store.findArticle(articleName);
            basket.addItem(foundArticle, quantity);
            System.out.printf("Added to basket: %s (Quantity: %d)%n", foundArticle.getName(), quantity);
        } catch (ArticleNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // Calculates and displays the price of the items in the basket
    public void priceOrder() {
        double totalPrice = basket.getItems().entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();

        basket.getItems().forEach((article, quantity) ->
                System.out.printf("Item: %s, Quantity: %d, Price: %.2f%n",
                        article.getName(), quantity, article.getPrice() * quantity));

        System.out.printf("Total Price: %.2f%n", totalPrice);
    }

    // Completes the order, updating the store's inventory
    public void completeOrder() {
        basket.getItems().forEach((article, quantity) -> {
            store.getInventory().stream()
                    .filter(invArticle -> invArticle.getName().equals(article.getName()))
                    .findFirst()
                    .ifPresent(invArticle -> store.addArticle(new Article(
                            invArticle.getCode(),
                            invArticle.getName(),
                            invArticle.getPrice())));
        });

        System.out.println("Order Completed. Inventory Updated.");
    }
}
