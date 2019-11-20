package effectivejava.builder;


// Builder pattern, good for entities (ie those used by jpa) as it minimises mutability
public class Person {
  private final String title;
  private final String name;
  private final String surname;
  private final String prefix;

  private Person(Builder builder) {
    this.title = builder.title;
    this.name = builder.name;
    this.surname = builder.surname;
    this.prefix = builder.prefix;
  }

  public static Builder builder(String name, String surname) {
    return new Builder(name, surname);
  }
  // This can be in another class, then person class will just be a simple value object
  public static class Builder {
    // can have all non final, and all optional
    // Can have all non final, and gvie it a default value in the field
    private final String name;
    private final String surname;
    private String title;
    private String prefix;

    private Builder(String name, String surname) {
      this.name = name;
      this.surname = surname;
    }

    public Builder withTitle(String title) {
      this.title = title;
      return this;
    }

    public Builder wihtPrefix(String prefix) {
      this.prefix = prefix;
      return this;
    }

    public Person build() {
      // Can have some validations
      // Checl that the optional fields are primmed
      return new Person(this);
    }
  }

  public static void main(String... args) {
    Person person = Person.builder("han", "blah") // Non optional fields
            .wihtPrefix("K") // optional field
            .withTitle("Sir") // optional field
            .build();
  }
}

