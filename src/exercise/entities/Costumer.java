package exercise.entities;

import java.util.Random;

public class Costumer {
    private final long id;
    private final String name;
    private final int tier;
    Random random = new Random();

    public Costumer(String name, int tier) {
        this.id = random.nextLong(1000000000000000000L, 9223372036854775807L);
        this.name = name;
        this.tier = tier;
    }

    public int getTier() {
        return tier;
    }

    @Override
    public String toString() {
        return "\nCLIENTE:" + "\n" +
                "Id: " + id + "\n" +
                "Nome: " + name + "\n" +
                "Tier: " + tier + "\n";
    }
}
