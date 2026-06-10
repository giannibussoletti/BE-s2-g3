import com.github.javafaker.Faker;
import entities.User;
import functional_interfaces.StringModifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    static void main() {
        //--------------------LAMBDA FUNCTIONS---------------
        // Se abbiamo già definito o se è già presente una interfaccia funzionale
        //allora possiamo creare una LAMDA FUNCTION a partire da essa.

        //Come si crea una LAMBDA FUNCTION

        //Richiamiamo l'interfaccia
        StringModifier stringWrapper = testo -> {
            return "***" + testo + "***";
        };

        StringModifier dotsWrapper = testo -> "...." + testo + "....";
        System.out.println(dotsWrapper.modify("Hello"));

        StringModifier stringInverter = testo -> {
            String[] splitting = testo.split("");
            StringBuilder inverted = new StringBuilder();
            for (int i = splitting.length - 1; i > 0; i--) {
                inverted.append(splitting[i]);
            }
            return inverted.toString();
        };

        System.out.println(stringInverter.modify("Hello"));

        Supplier<Integer> randomIntSupplier = () -> {
            Random random = new Random();
            return random.nextInt(1, 100000);
        };

        for (int i = 0; i < 100; i++) {
            System.out.println(randomIntSupplier.get());

        }
        Supplier<List<Integer>> listSupplier = () -> {
            List<Integer> listRandom = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                listRandom.add(random.nextInt(1, 10000));

            }
            return listRandom;
        };

        System.out.println(listSupplier.get());

        Faker faker = new Faker(Locale.ITALIAN);
        Supplier<List<User>> randomUser = () -> {
            List<User> users = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                users.add(new User(faker.lebowski().character(), faker.book().author(), random.nextInt(0, 100)));
            }
            return users;
        };

        for (User user : randomUser.get()) {
            System.out.println(user);
        }

        List<User> randomUsers = randomUser.get();

        //-----------------PREDICATES----------------
        //Simili ai filtri in JS
        // Ritornano un booleano
        Predicate<Integer> isPositive = num -> num > 0;
        Predicate<Integer> isLessThan100 = num -> num < 100;
        System.out.println(isPositive.test(20));
        //I predicate sono anche concatenabili
        // e possono usare and per avere le entrambe le condizioni vere
        System.out.println(isPositive.and(isLessThan100).test(99));
        // oppure OR
        System.out.println(isPositive.or(isLessThan100).test(200));

        Predicate<User> isAdult = user -> user.getAge() >= 18;

        randomUsers.forEach(user -> {
            if (isAdult.test(user)) System.out.println("L'utente " + user + " è maggiorenne");
            else System.out.println("L'utente " + user + " è minorenne");

        });
        //------------------------REMOVE IF-----------------
//        randomUsers.removeIf(isAdult);
        randomUsers.removeIf(user -> user.getAge() >= 18);

    }


}
