package workflows.usecase;

public interface Service {
  Response send(Integer input);

  String sendSomething(String length);

  String sendSomethingElse(String input);

  class Response {
    private final String value;

    public Response(String value) {
      this.value = value;
    }
  }
}
