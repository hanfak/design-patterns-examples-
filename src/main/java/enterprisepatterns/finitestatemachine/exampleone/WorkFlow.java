package enterprisepatterns.finitestatemachine.exampleone;

import com.google.common.collect.ImmutableMap;

import java.util.Collections;
import java.util.List;

public class WorkFlow {
  private static ImmutableMap<Class<? extends Events>, List<Class<? extends Events>>> immutableMap = ImmutableMap.<Class<? extends Events>, List<Class<? extends Events>>>builder()
          .put(FirstEvent.class, List.of(SecondEvent.class))
          .put(SecondEvent.class, List.of(ThirdEvent.class, ThirdErrorEvent.class))
          .put(ThirdErrorEvent.class, List.of(SecondEvent.class))
          .put(ThirdEvent.class, List.of(FourthEvent.class))
          .put(FourthEvent.class, Collections.emptyList())
          .build();

  public static ImmutableMap<Class<? extends Events>, List<Class<? extends Events>>> workflow() {
    return immutableMap;
  }
}
