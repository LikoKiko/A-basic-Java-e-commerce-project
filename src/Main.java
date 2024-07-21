public class Main {
    public static void main(String[] args) {
        // Create store and add initial articles
        Store store = new Store();
        store.addArticle(new Article("A001", "Laptop", 899.99));
        store.addArticle(new Article("A002", "Smartphone", 499.99));
        store.addArticle(new Article("A003", "Headphones", 79.99));

        // Create order manager
        OrderManager orderManager = new OrderManager(store);

        // User interactions (you may want to improve the user interface)
        orderManager.checkAvailability("Laptop");
        orderManager.addToBasket("Laptop", 2);
        orderManager.addToBasket("Smartphone", 1);
        orderManager.priceOrder();
        orderManager.completeOrder();
    }
}
