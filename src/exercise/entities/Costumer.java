package exercise.entities;

import java.util.Random;

public class Costumer {
    long id;
    String name;
    int tier;
    Random random = new Random();

    public Costumer(String name, int tier) {
        this.id = id = random.nextLong(1000000000000000000L, 9223372036854775807L);
        this.name = name;
        this.tier = tier;
    }

    public int getTier() {
        return tier;
    }
}
