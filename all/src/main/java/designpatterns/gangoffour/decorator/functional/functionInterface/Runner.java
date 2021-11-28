package designpatterns.gangoffour.decorator.functional.functionInterface;

import java.util.function.Function;

public class Runner {
  public static void main(String... args) {
    Function<Integer,Integer> increment = e -> e + 1;
    Function<Integer,Integer> doubleIt = e -> e * 2;

    System.out.println(doWork(5, increment));
    System.out.println(doWork(5, doubleIt));

    // combine to strategies, composition
    int temp = doWork(5, increment); // temp useless var
    System.out.println(doubleIt.apply(temp));

    // better way
    System.out.println(doWork(5, increment.andThen(doubleIt)));
  }

  private static int doWork(int i, Function<Integer, Integer> increment) {
    return increment.apply(i);
  }
}
