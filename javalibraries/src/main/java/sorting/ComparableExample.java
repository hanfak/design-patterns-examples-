package sorting;

import java.util.*;
import java.util.stream.Collectors;

public class ComparableExample {

    private static final ComparableItem book = new ComparableItem("book", 7.99, false);
    private static final ComparableItem ball = new ComparableItem("ball", 2.0, false);
    private static final ComparableItem dog = new ComparableItem("dog", 15.74, true);
    private static final ComparableItem chair = new ComparableItem("chair", 7.93, false);
    private static final List<ComparableItem> items = Arrays.asList(dog, ball, chair, book);

    private static ComparableItem[] arrayItems = new ComparableItem[] {dog, ball, chair, book};

    private static final Item book1 = new Item("book", 7.99, false);
    private static final Item ball1 = new Item("ball", 2.0, false);
    private static final Item dog1 = new Item("dog", 15.74, true);
    private static final Item chair1 = new Item("chair", 7.93, false);
    private static final List<Item> items1 = Arrays.asList(dog1, ball1, chair1, book1);

    private static final Stock stock1 = new Stock(book, 10);
    private static final Stock stock2 = new Stock(book, 5);
    private static final Stock stock3 = new Stock(book, 7);
    private static final Stock stock4 = new Stock(chair, 10);
    private static final List<Stock> stocks = Arrays.asList(stock1, stock2, stock3, stock4);

    private static final ItemNoEquals book2 = new ItemNoEquals("book", 7.99, false);

    public static void main(String[] args) {
        int abook = new ComparableItem("book", 7.99, false).hashCode();
        System.out.println("book = " + abook);
        int anotherBook = new ComparableItem("book", 7.99, false).hashCode();
        System.out.println("book1 = " + anotherBook);

        System.out.println();
        int aball = new Item("ball", 2.0, false).hashCode();
        System.out.println("ball = " + aball);
        int ball1 = new Item("ball", 2.0, false).hashCode();
        System.out.println("ball1 = " + ball1);

        System.out.println();

        System.out.println("All the same value");
        int stockOne = new Stock(book, 10).hashCode();
        System.out.println("stockOne = " + stockOne);
        int stockTwo = new Stock(book, 10).hashCode();
        System.out.println("stockTwo = " + stockTwo);
        int stockThree = new Stock(book, 10).hashCode();
        System.out.println("stockThree = " + stockThree);
        System.out.println();

        System.out.println("different hashcodes");
        int blah = new ComparableItem2("book", 7.99, false).hashCode();
        System.out.println(blah);
        int blah2 = new ComparableItem2("book", 7.99, false).hashCode();
        System.out.println(blah2);
        System.out.println();

        System.out.println("Hashmap - hashcode overridden");
        Map<Item, String> someMap = new HashMap<>();
        someMap.put(new Item("book", 7.99, false), "Boom Ball");
        String s = someMap.get(new Item("book", 7.99, false));
        System.out.println(s);
        System.out.println();

        System.out.println("no hashcode overidden but equals has");
        Map<ComparableItem2, String> othermap = new HashMap<>();
        othermap.put(new ComparableItem2("book", 7.99, false), "Effecitve java");
        String t = othermap.get(new ComparableItem2("book", 7.99, false));
        System.out.println(t);
        System.out.println();

        System.out.println("CompareTo examples");

        ArrayList<ComparableItem> comparableItems = new ArrayList<>(items);
        ArrayList<ComparableItem> comparableItems2 = new ArrayList<>(items);
        System.out.println("before sort = " + items);
        List<ComparableItem> collect = comparableItems.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("after sort  = " + collect);

        List<ComparableItem> collect2 = comparableItems2.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("after sort reversed = " + collect2);
        System.out.println();

        // Mutative
        System.out.println("Before sort array list " + items);
        Collections.sort(items);
        System.out.println("After sort array list " + items);
        System.out.println();

        System.out.println("Before sort array items " + arrayItems);
        Arrays.sort(arrayItems);
        System.out.println("After sort array items " + arrayItems);
        System.out.println();

        // Cannot use sort as comparable has not been implemented by Item and compareTo method not implemented
//        System.out.println("Before sort array list " + items1);
//        Collections.sort(items1);
//        System.out.println("After sort array list " + items1);

        System.out.println("Before sort array list " + stocks);
        Collections.sort(stocks);
        System.out.println("After sort array list " + stocks);
        System.out.println();


        System.out.println("Equals examples");

        System.out.println("Equals examples");
        boolean checkEquality = book2.equals(new ItemNoEquals("book", 7.99, false));
        System.out.println("checkEquality = " + checkEquality);

        boolean checkEquality1 = book1.equals(new Item("book", 7.99, false));
        System.out.println("checkEquality1 = " + checkEquality1);

        System.out.println(book1.equals(book1));
        System.out.println(book2.equals(book2));



    }
}

