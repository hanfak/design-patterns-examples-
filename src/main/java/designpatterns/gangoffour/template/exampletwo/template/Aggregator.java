package designpatterns.gangoffour.template.exampletwo.template;

public abstract class Aggregator<T,S> {
  protected S state;
  protected Iterable<T> seq;

  protected Aggregator(Iterable<T> seq) {
    this.seq = seq;
  }

  public final S evaluate() {
    setInitialState();
    for(T t : seq) {
      aggregate(t);
    }
    return state;
  }

  protected abstract void setInitialState();
  protected abstract void aggregate(T t);
}
