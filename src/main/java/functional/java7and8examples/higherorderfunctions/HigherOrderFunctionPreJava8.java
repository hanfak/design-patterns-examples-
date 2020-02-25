package functional.java7and8examples.higherorderfunctions;

import java.util.Comparator;

public class HigherOrderFunctionPreJava8 {
    public static void main(String[] args) {
        String[] innerplanets = {"Mercury", "Venus", "Earth", "Mars"};
        dump(innerplanets);
        sort(innerplanets, new Comparator<String>() {
            @Override
            public int compare(String e1, String e2) {
                return e1.compareTo(e2);
            }
        });
        dump(innerplanets);
        sort(innerplanets, new Comparator<String>() {
            @Override
            public int compare(String e1, String e2) {
                return e2.compareTo(e1);
            }
        });
        dump(innerplanets);
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


}
