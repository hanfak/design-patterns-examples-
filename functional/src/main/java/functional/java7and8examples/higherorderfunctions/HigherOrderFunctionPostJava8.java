package functional.java7and8examples.higherorderfunctions;

import java.util.Comparator;
import java.util.stream.IntStream;

public class HigherOrderFunctionPostJava8 {
    public static void main(String[] args) {
        // Not purely functional as innerPlanets2 is being mutated

        // Using intellij
        String[] innerPlanets = {"Mercury", "Venus", "Earth", "Mars"};
        dump(innerPlanets);
        sort(innerPlanets, Comparator.naturalOrder());
        dump(innerPlanets);
        sort(innerPlanets, Comparator.reverseOrder());
        dump(innerPlanets);

        // Using lambdas
        String[] innerPlanets2 = { "Mercury", "Venus", "Earth", "Mars" };
        dump(innerPlanets2);
        sort(innerPlanets2, (e1, e2) -> e1.compareTo(e2));
        dump(innerPlanets2);
        sort(innerPlanets2, (e1, e2) -> e2.compareTo(e1));
        dump(innerPlanets2);

        // Using method references
        String[] innerPlanets3 = { "Mercury", "Venus", "Earth", "Mars" };
        dump(innerPlanets3);
        sort(innerPlanets3, String::compareTo);
        dump(innerPlanets3);
        sort(innerPlanets3, Comparator.comparing(String::toString).reversed());
        dump(innerPlanets3);

        // using functional impl of bubble sort

        String[] innerPlanets34 = {"Mercury", "Venus", "Earth", "Mars"};
        dump(innerPlanets34);
        bubbleSort(innerPlanets34, Comparator.naturalOrder());
        dump(innerPlanets34);
        bubbleSort(innerPlanets34, (e1, e2) -> e2.compareTo(e1));
        dump(innerPlanets34);

    }

    private static <T> void dump(T[] array) {
        for (T element : array)
            System.out.println(element);
        System.out.println();
    }

    private static <T> void sort(T[] array, Comparator<T> cmp) {
        for (int pass = 0; pass < array.length - 1; pass++)
            for (int i = array.length - 1; i > pass; i--)
                if (cmp.compare(array[i], array[pass]) < 0)
                    swap(array, i, pass);
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // not using comparator, only fixed comparison
    static void bubbleSort(Integer[] arr) {
        int n = arr.length;
        IntStream.range(0, n - 1)
                .flatMap(i -> IntStream.range(1, n - i))
                .forEach(j -> {
                    if (arr[j - 1] > arr[j]) {
                        swap(arr, j, j - 1);
                    }
                });
    }

    private static <T> void bubbleSort(T[] arr, Comparator<T> cmp) {
        int n = arr.length;

        IntStream.range(0, n - 1)
                .flatMap(i -> IntStream.range(1, n - i))
                .forEach(j -> {
                    if (cmp.compare(arr[j], arr[j-1]) < 0) {
                        swap(arr, j, j - 1);
                    }
                });
    }
}
