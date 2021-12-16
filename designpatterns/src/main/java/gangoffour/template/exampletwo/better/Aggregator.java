package gangoffour.template.exampletwo.better;

import java.util.function.BiFunction;

public interface Aggregator<T, S> {
  default S aggregate(Iterable<T> seq, S initial, BiFunction<T, S, S> aggregator) {
    S state = initial;
    for (T t : seq) {
      state = aggregator.apply(t, state);
    }
    return state;
  }
}
