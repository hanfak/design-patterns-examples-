package enterprisepatterns.finitestatemachine.exampleone;

public class App {
  public static void main(String... args) {
    Events firstEvent = new FirstEvent();
    if (WorkFlow.workflow().containsKey(firstEvent.getClass())){
      System.out.println("blah");
      WorkFlow.workflow().get(firstEvent.getClass());
    }
  }
}
