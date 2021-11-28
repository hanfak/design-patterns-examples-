package integrations.httpclient.decorator;

import java.util.UUID;

import static java.util.Objects.isNull;

public class TraceyId {

  private static UUID id;

  public static boolean hasValue() {
    return !isNull(id);
  }

  public static String get() {
    return id.toString();
  }

  public static String makeOneUp() {
    id = UUID.randomUUID();
    return id.toString();
  }
}
