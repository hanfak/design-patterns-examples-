package designpatterns.gangoffour.template.exampletwo.template;

public class Sum extends Aggregator<Integer, Integer> {

  protected Sum(Iterable<Integer> seq) {
    super(seq);
  }

  @Override
  protected void setInitialState() {
    state = 0;
  }

  @Override
  protected void aggregate(Integer o) {
    state += o;
  }
}
