package EsercizioJavaStream;

public class Product {
    Long id;
    String name;
    String category;
    Double price;

    public Product(Long id, String name, String category, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getCategory() { return category; }
    public Double getPrice() { return price; }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setPrice(Double price) { this.price = price; }
    public String toString() {
        return name + " (" + category + ", €" + price + ")";
    }
}
