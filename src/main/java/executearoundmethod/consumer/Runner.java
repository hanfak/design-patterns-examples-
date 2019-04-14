package executearoundmethod.consumer;

import java.util.function.Consumer;

public class Runner {
  public static void main(String... args) {
    // First example - need to close resource
    Resource resource = new Resource();
    resource.op1();
    resource.op2();
    //If not closed then memory leakage, resource not cleaned by garbage collector
    resource.close();

    // What about exception when doing the op1???
    Resource resourceWithException = new Resource();
    try {
      resourceWithException.op1();
      resourceWithException.op2();
    } finally {
      resourceWithException.close();
    }

    // Too verbose above, how about using java ARM from java 7
    try (Resource2 resource2 = new Resource2()) {
      resourceWithException.op1();
      resourceWithException.op2();
    }

    System.out.println();
    // Rather than rely on ARM, can extract the verbosity out
    Resource3.use(resource3 -> resource3.op1().op2());
    // This allows to focus on using the object, rather than dealing with the exceptions
    // or closing the resources

    Resource4.use2(resource4 -> resource4.op1().op2());


  }
}

class Resource {
  public Resource() {
    System.out.println("Created ...");
  }

  public void op1() {
    System.out.println("Op1");
  }

  public void op2() {
    System.out.println("Op2");
  }

  public void close() {
    System.out.println("cleanup...");
  }

}

class Resource2 implements AutoCloseable {
  public Resource2() {
    System.out.println("Created ...");
  }

  public void op1() {
    System.out.println("Op1");
  }

  public void op2() {
    System.out.println("Op2");
  }

  @Override
  public void close() {
    System.out.println("cleanup...");
  }

}

class Resource3 {
  private Resource3() {
    System.out.println("Created ...");
  }

  public Resource3 op1() {
    System.out.println("Op1");
    return this;
  }

  public Resource3 op2() {
    System.out.println("Op2");
    return this;
  }

  public void close() {
    System.out.println("cleanup...");
  }

  public static void use(Consumer<Resource3> block) {
    Resource3 resource3 = new Resource3();
    try {
      block.accept(resource3);
    } finally {
      resource3.close();
    }
  }

}

class Resource4 implements AutoCloseable {
  private Resource4() {
    System.out.println("Created ...");
  }

  public Resource4 op1() {
    System.out.println("Op1");
    return this;
  }

  public Resource4 op2() {
    System.out.println("Op2");
    return this;
  }

  public void close() {
    System.out.println("cleanup...");
  }


  public static void use2(Consumer<Resource4> block) {
    try (Resource4 resource4 = new Resource4()) {
      block.accept(resource4);
    }
  }
}
