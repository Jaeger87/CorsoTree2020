
import java.util.Objects;

public class Product {
    private String id;
    private String name, description;
    private double price;
    private int stockAvailability;

    public Product(String id, String name, String description,
                   double price, int stockAvailability) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockAvailability = stockAvailability;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStockAvailability() {
        return stockAvailability;
    }

    public void decreaseStockAvailability(int quantity) {
        stockAvailability -= quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return name + " - " + description;
    }
}
