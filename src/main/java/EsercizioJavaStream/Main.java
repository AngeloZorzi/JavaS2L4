package EsercizioJavaStream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Product p1 = new Product(1L,"Geronimo Stilton 1st ed","Books",150.25);
        Product p2 = new Product(2L,"World at war","Books",75.0);
        Product p3 = new Product(3L,"A DRG Story","Books",275.0);
        Product p4 = new Product(4L,"MachineGun","Boys",100.0);
        Product p5 = new Product(5L,"Fobal","Boys",15.0);
        Product p6 = new Product(6L,"How to survive against squirrels/Doom-Pack","Boys",975.0);
        Product p7 = new Product(7L,"Silencer","Baby",55.0);
        Product p8 = new Product(8L,"How To Make your baby cry","Baby",9.0);
        Product p9 = new Product(9L,"Baby-Monitor","Baby",250.0);

        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p6);
        products.add(p7);
        products.add(p8);
        products.add(p9);

        List<Product> over100 = products.stream().filter(product -> product.getCategory().equals("Books")&&product.getPrice()>100).collect(Collectors.toList());
        System.out.println("Books that costs as my grandpa would say 'Più di una gamba'");
        over100.forEach(System.out::println);
        System.out.println();

        Customer c1 = new Customer(1L, "Laa-la", 1);
        Customer c2 = new Customer(2L, "Po", 2);
        Customer c3 = new Customer(3L, "Tinky-Winky", 2);

        Order o1 = new Order(1L, "Shipped", LocalDate.of(2021, 1, 10), LocalDate.of(2021, 1, 15),
                List.of(p1, p4,p2), c1);
        Order o2 = new Order(2L, "Delivered", LocalDate.of(2021, 2, 20), LocalDate.of(2021, 2, 28),
                List.of(p7, p8), c2);
        Order o3 = new Order(3L, "Processing", LocalDate.of(2021, 3, 5), LocalDate.of(2021, 3, 10),
                List.of(p3, p5, p4,p9), c3);
        Order o4 = new Order(4L, "Delivered", LocalDate.of(2021, 3, 25), LocalDate.of(2021, 4, 1),
                List.of(p6, p9,p1), c2);

        List<Order> orders = List.of(o1, o2, o3, o4);

        List<Order> babyOrders = orders.stream().filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equals("Baby"))).collect(Collectors.toList());
        System.out.println("Baby orders from Teletubbies: ");
        babyOrders.forEach(System.out::println);
        System.out.println();

        List<Product> boysDiscount = products.stream().filter(product -> product.getCategory().equals("Boys")).map(product -> new Product(product.getId(), product.getName(), product.getCategory(), product.getPrice()*0.9)).collect(Collectors.toList());
        System.out.println("Boys' products on sale:");
        boysDiscount.forEach(System.out::println);
        System.out.println();

        LocalDate start = LocalDate.of(2021, 2, 1);
        LocalDate end = LocalDate.of(2021, 4, 1);

        List<Order> premiumAccountsOrders = orders.stream().filter(order -> order.getCustomer().getTier() == 2).filter(order -> !order.getOrderDate().isBefore(start) && !order.getOrderDate().isAfter(end)).collect(Collectors.toList());
        System.out.println("Tier 2 orders:");
        premiumAccountsOrders.forEach(System.out::println);
        System.out.println("<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-< exe1");

        System.out.println("Esercizio 1: Ordini raggruppati per cliente");
        Map<Customer, List<Order>> ordersByCustomer = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));
        ordersByCustomer.forEach((customer, customerOrders) -> {
            System.out.println(customer.getName() + ": " + customerOrders);
        });
        System.out.println();
        System.out.println("<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-< exe2");
        System.out.println("Esercizio 2: Totale vendite per cliente");
        Map<Customer, Double> totalSalesByCustomer = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer,
                        Collectors.flatMapping(order -> order.getProducts().stream(), Collectors.summingDouble(Product::getPrice))));
        totalSalesByCustomer.forEach((customer, total) -> {
            System.out.println(customer.getName() + ": €" + total);
        });
        System.out.println();
        System.out.println("<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-< exe4");
        System.out.println("Esercizio 4: Media importi ordini");
        double averageOrderValue = orders.stream()
                .mapToDouble(order -> order.getProducts().stream().mapToDouble(Product::getPrice).sum())
                .average()
                .orElse(0.0);
        System.out.println("Valore medio ordini: €" + averageOrderValue);
        System.out.println();




    }
}
