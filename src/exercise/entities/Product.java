package exercise.entities;

import java.util.Random;

public class Product {
    long id;
    String name;
    String category;
    double price;

    Random random = new Random();

    public Product(String name, String category, double price) {
        this.id = random.nextLong(1000000000000000000L, 9223372036854775807L);
        this.name = name;
        this.category = category;
        this.price = price;
    }


    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}

