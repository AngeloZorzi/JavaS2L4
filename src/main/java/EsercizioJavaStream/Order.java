package EsercizioJavaStream;

import java.time.LocalDate;
import java.util.List;

public class Order {
    Long id;
    String status;
    LocalDate orderDate;
    LocalDate deliveryDate;
    List<Product> products;
    Customer customer;

    public Order(Long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }
    public LocalDate getOrderDate() { return orderDate; }
    public List<Product> getProducts() { return products; }
    public Customer getCustomer() { return customer; }
    public String toString() {
        return "Order " + id + " by " + customer.getName() + ": " + products;
    }
}
