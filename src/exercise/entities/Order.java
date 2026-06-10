package exercise.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Order {
    Long id;
    String status;
    LocalDate orderDate;
    LocalDate deliveryDate;
    List<Product> products;
    Costumer costumer;

    Random random = new Random();

    public Order(String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Costumer costumer) {
        this.id = random.nextLong(1000000000000000000L, 9223372036854775807L);
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.costumer = costumer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public Costumer getCostumer() {
        return costumer;
    }
}
