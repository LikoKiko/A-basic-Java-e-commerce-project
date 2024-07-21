public class Article {
    private String code;
    private String name;
    private double price;

    // Constructor
    public Article(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    // Getters
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Override toString for better printing
    @Override
    public String toString() {
        return String.format("Article{code='%s', name='%s', price=%.2f}", code, name, price);
    }
}
