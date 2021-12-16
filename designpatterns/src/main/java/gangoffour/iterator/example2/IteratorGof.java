package gangoffour.iterator.example2;

import java.util.Iterator;
import java.util.List;

public class IteratorGof {
  static final List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

  public static void main(String[] args) {

      for (Integer integer : list) {
          System.out.println(integer);
      }

    for (Integer i : list) {
      System.out.println(i);
    }
  }
}
