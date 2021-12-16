package gangoffour.template.exampletwo.before;

public class Aggregators {
  public static int sum(Iterable<Integer> seq) {
    int sum = 0;
    for(var i : seq) {
      sum += i;
    }
    return sum;
  }

  public static int product(Iterable<Integer> seq) {
    int product = 0;
    for(var i : seq) {
      product = product * i;
    }
    return product;
  }
}
