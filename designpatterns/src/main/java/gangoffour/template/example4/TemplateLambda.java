package gangoffour.template.example4;

import java.util.function.Consumer;

public class TemplateLambda {
  public static void withResource(Consumer<Resource> consumer) {
    Resource resource = new Resource();
    try {
      consumer.accept(resource);
    } finally {
      resource.dispose();
    }
  }

  public static void main(String[] args) {
    withResource(Resource::useResource);
    withResource(Resource::employResource);
  }
}