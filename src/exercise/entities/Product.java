package exercise.entities;

import java.util.Random;

public class Product {
    private final long id;
    private final String name;
    private final String category;
    private final double price;

    Random random = new Random();

    public Product(String name, String category, double price) {
        this.id = random.nextLong(1000000000000000000L, 9223372036854775807L);
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "\nPRODOTTO:" + "\n" +
                "id: " + id + "\n" +
                "Nome: " + name + "\n" +
                "Categoria: " + category + "\n" +
                "Prezzo: " + price + "\n";
    }
}

