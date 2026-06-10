package exercise;

import exercise.entities.Costumer;
import exercise.entities.Order;
import exercise.entities.Product;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // Categoria Books
    // Prezzo superiore 100
    // Categoria Baby
    // Categoria Boys
    // tier livello 2
    // data inizio e data di fine 01 Febbraio 2021 - 01 Aprile 2021
    static void main() {
        DecimalFormat df = new DecimalFormat("###.##");

        Costumer gianni = new Costumer("Gianni", 2);
        Costumer mario = new Costumer("Mario", 2);
        Costumer marco = new Costumer("Marco", 1);
        Costumer giacomo = new Costumer("Giacomo", 3);
        Costumer francesco = new Costumer("Francesco", 1);
        Costumer giorgio = new Costumer("Giorgio", 1);
        Costumer lucrezia = new Costumer("Lucrezia", 3);
        Costumer martina = new Costumer("Martina", 2);

        Product signoreAnelli = new Product("Il Signore Degli Anelli", "Books", 103.50);
        Product harryPotter = new Product("Harry Potter", "Boys", 27.90);
        Product deBello = new Product("De Bello Gallico - Illustrato", "Books", 120.30);
        Product PercyJackson = new Product("Percy Jackson e gli dei dell'Olimpo", "Boys", 23.60);
        Product primaveraPerduta = new Product("Primavera Perduta", "Boys", 109.74);
        Product tinTin = new Product("Le avventure di Tin Tin", "Boys", 113.50);
        Product favoleEsopo = new Product("Le Favole di Esopo", "Baby", 10.90);
        Product gattoStivali = new Product("Il Gatto Con Gli Stivali", "Books", 23.50);
        Product cenerentola = new Product("Cenerentola", "Baby", 10.50);

        List<Product> cart1 = new ArrayList<>();

        cart1.add(signoreAnelli);
        cart1.add(harryPotter);
        cart1.add(deBello);
        cart1.add(PercyJackson);
        cart1.add(primaveraPerduta);
        cart1.add(tinTin);

        List<Product> cart2 = new ArrayList<>();

        cart2.add(deBello);
        cart2.add(primaveraPerduta);
        cart2.add(favoleEsopo);
        cart2.add(gattoStivali);
        cart2.add(cenerentola);

        List<Product> cart3 = new ArrayList<>();

        cart3.add(signoreAnelli);
        cart3.add(deBello);
        cart3.add(primaveraPerduta);
        cart3.add(favoleEsopo);
        cart3.add(cenerentola);

        List<Product> cart4 = new ArrayList<>();

        cart4.add(signoreAnelli);
        cart4.add(harryPotter);
        cart4.add(deBello);
        cart4.add(PercyJackson);
        cart4.add(primaveraPerduta);
        cart4.add(tinTin);
        cart4.add(favoleEsopo);
        cart4.add(gattoStivali);
        cart4.add(cenerentola);


        List<Product> cart5 = new ArrayList<>();
        cart5.add(signoreAnelli);

        List<Order> orders = new ArrayList<>();

        Order order1 = new Order("delivered", LocalDate.of(2021, 2, 1), LocalDate.of(2021, 2, 3), cart1, gianni);
        Order order2 = new Order("delivered", LocalDate.of(2021, 3, 4), LocalDate.of(2021, 3, 10), cart2, martina);
        Order order3 = new Order("shipping", LocalDate.of(2021, 10, 4), LocalDate.of(2021, 11, 10), cart3, lucrezia);
        Order order4 = new Order("shipping", LocalDate.of(2021, 4, 1), LocalDate.of(2021, 5, 10), cart4, martina);
        Order order5 = new Order("shipping", LocalDate.of(2021, 4, 1), LocalDate.of(2021, 5, 10), cart5, martina);
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);

        //1)
        List<Product> libriPrezzo100 = order4.getProductsList().stream().filter(product -> product.getCategory().equals("Books") && product.getPrice() > 100).toList();
//        libriPrezzo100.forEach(book -> System.out.println(book));

        //2)
        List<Order> ordersBaby = orders.stream().filter(order -> order.getProductsList().stream().anyMatch(product -> product.getCategory().matches("Baby"))).toList();
        System.out.println(ordersBaby);

        //3)
        List<String> ragazziSconto = cart4.stream().filter(book -> book.getCategory().equals("Boys")).map(book -> "\n" + book.getName() + "\nPrezzo originale: " + book.getPrice() + "\nPrezzo scontato 10%: " + df.format(book.getPrice() - (book.getPrice() * 10 / 100))).toList();
//        ragazziSconto.forEach(book -> System.out.println(book));

        //4)
        List<String> filteredProductDateTier2 = orders.stream()
                .filter(order -> order.getOrderDate().isAfter(LocalDate.of(2021, 1, 31)))
                .filter(order -> order.getDeliveryDate().isBefore(LocalDate.of(2021, 4, 1)))
                .filter(order -> order.getCostumer().getTier() >= 2).map(order -> order.getProductsList())
                .map(list -> list.stream()
                        .map(product -> "\nProdotto comprato fra il 01 febbraio e il 1 aprile 2021: " + product).toList())
                .map(frasi -> frasi + "").toList();
//        filteredProductDateTier2.forEach(product -> System.out.println(product));

    }


}
