package designpatterns.gangoffour.iterator.example2;

import java.util.List;


public class IteratorLambda {
  static final List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

  public static void main(String[] args) {
    list.forEach(System.out::println);
  }
}
