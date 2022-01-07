package sorting;

import java.util.*;
import java.util.stream.Collectors;

public class CompartorExample {

    private static final Item book = new Item("book", 7.99, false);
    private static final Item ball = new Item("ball", 2.0, false);
    private static final Item dog = new Item("dog", 15.74, true);
    private static final Item chair = new Item("chair", 7.93, false);

    private static final List<Item> items1 = Arrays.asList(dog, ball, chair, book);
    private static final List<Item> items2 = Arrays.asList(dog, ball, chair, book);
    private static final List<Item> items3 = Arrays.asList(dog, ball, chair, book);
    private static final List<Item> items4  = Arrays.asList(dog, ball, chair, book);
    private static final List<Item> items5  = Arrays.asList(dog, ball, chair, book);

    public static void main(String[] args) {
        System.out.println("Mutative");

        orderItemsByNameInAscendingOrder();

        orderItemsByNameInDescendingOrder();

        orderItemsByPriceInDescendingOrder();

        System.out.println("\nNon mutative");

        orderItemsByPriceInDescendingOrderFunctionally();

        orderItemsByPriceInAscendingOrderFunctionally();

        orderItemsByPriceInAscendingOrderImperatively();
    }

    private static void orderItemsByPriceInAscendingOrderImperatively() {
        System.out.println("\nAscending order by price");
        System.out.println("\nImperative way");
        System.out.println(items5);
        @SuppressWarnings("ComparatorCombinators") List<Item> sortedItems3 = items3.stream()
                .sorted((item1, item2) -> item1.price.compareTo(item2.price))
                .collect(Collectors.toList());
        System.out.println(sortedItems3);
    }

    private static void orderItemsByPriceInAscendingOrderFunctionally() {
        System.out.println("\nAscending order by price");
        System.out.println("\nUsing functional style");
        System.out.println(items4);
        List<Item> sortedItems2 = items4 .stream()
                .sorted(Comparator.comparing(o -> o.price))
                .collect(Collectors.toList());
        System.out.println(sortedItems2);
    }

    private static void orderItemsByPriceInDescendingOrderFunctionally() {
        System.out.println("\nDescending order by price");
        System.out.println("\nUsing functional style");
        System.out.println(items3);
        List<Item> sortedItems1 = items3.stream()
                .sorted((item1, item2) -> {
                    Double price = item2.price;
                    return price.compareTo(item1.price);
                })
                .collect(Collectors.toList());
        System.out.println(sortedItems1);
    }


    private static void orderItemsByPriceInDescendingOrder() {
        System.out.println("\nDescending order by price");
        List<Item> sortedList = new ArrayList<>(items3);
        System.out.println(items3);
        sortedList.sort(Item.compartorPriceDescending);
        System.out.println(sortedList);
    }

    private static void orderItemsByNameInDescendingOrder() {
        System.out.println("\nDescending order by name");
        System.out.println(items2);
        items2.sort(Item.compartorNameDescending);
        System.out.println(items2);
    }

    private static void orderItemsByNameInAscendingOrder() {
        System.out.println("\nAscending order by name");
        System.out.println(items1);
        Collections.sort(items1, Item.compartorNameAscending);
        System.out.println(items1);
    }
}

