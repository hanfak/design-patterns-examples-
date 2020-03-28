package designpatterns.template.exampletwo.template;

public class Product extends Aggregator<Integer, Integer> {
  protected Product(Iterable<Integer> seq) {
    super(seq);
  }

  @Override
  protected void setInitialState() {
    state = 1;
  }

  @Override
  protected void aggregate(Integer o) {
    state *= o;
  }
}
