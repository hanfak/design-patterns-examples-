package concurrency.executearoundmethod.function;


import java.util.function.Function;

public class Runner {
  public static void main(String... args) {
    String use = Resource.use(Resource::op1);
  }
}

class Resource implements AutoCloseable {
  public Resource() {
    System.out.println("Created ...");
  }

  public String op1() throws IllegalStateException {
    System.out.println("Op1");
    return "Op1";
  }

  public String op2() {
    System.out.println("Op2");
    return "Op2";
  }

  @Override
  public void close() {
    System.out.println("cleanup...");
  }

  public static String use(Function<Resource, String> block) {
    Resource resource = new Resource();
    return block.apply(resource);
  }

}
